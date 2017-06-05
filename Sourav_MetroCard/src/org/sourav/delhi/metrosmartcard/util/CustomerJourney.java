package org.sourav.delhi.metrosmartcard.util;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.sourav.delhi.metrosmartcard.IJourneyFarePlan;
import org.sourav.delhi.metrosmartcard.exception.InsufficientException;
import org.sourav.delhi.metrosmartcard.exception.MinimumBalanceException;
import org.sourav.delhi.metrosmartcard.impl.JourneyFarePlanFactory;
import org.sourav.smartcard.dao.TravelDetailsDAO;

public class CustomerJourney {
	
	public CustomerJourney(){
		System.out.println("Start of Customer Journey....");
	}
	
	private ConcurrentMap<String, AtomicInteger> stationFootFall = new ConcurrentHashMap<>();
	private TravelFareValidator validator = new TravelFareValidator(); 
	TravelDetailsDAO jdbc = TravelDetailsDAO.getInstance();
	private CalculateTravelCost fareCalc =new CalculateTravelCost();
		
	public SmartCardDetails processCustomerJourney() throws SQLException, MinimumBalanceException{	
		
	    
		IJourneyFarePlan farePlan = JourneyFarePlanFactory.getFareStrategy(Calendar.getInstance(TimeZone.getDefault()));
		
		/**ASSUMPTION
		 * 
		 * 1.Customer swaps in the smart card at metro station 
		 * 2.Capture the card details from swaping machine and store in our table.We assume we maintain 
		 * a master card list against each customer while registration process. It will be stored in T_Customer_SmartCard_Master_Data
		 * table.
		 **/
		
		SmartCardDetails smartCard = new SmartCardDetails("4412589755689852", "A2", "SATURDAY");
		CustomerDetails customer= jdbc.getCustomerDetailsByCard(smartCard);
		
		if(!validator.validateMinimumBalance(smartCard.getCardbalance(),farePlan.getFareValueDetails())){
			throw new MinimumBalanceException("Minimum balance of Rs 5.5 is required at Swipe In");
		}else {		
			swipeIn(smartCard,customer,TimeZone.getDefault());
		}
		return smartCard;
		
	}
		
	
	public void swipeIn(SmartCardDetails card,CustomerDetails customer,TimeZone dateTime) throws SQLException {
		
		Calendar dtTime=Calendar.getInstance(dateTime);
		stationFootFall.putIfAbsent(card.getStartStation(), new AtomicInteger());
        stationFootFall.get(card.getStartStation()).incrementAndGet();
        CardTrx trx = new CardTrx();
        trx.setSource(card.getStartStation());
        trx.setCard(card);
        trx.setStartTime(dtTime.getTime());
        int numberOfInsertion= jdbc.insertSmartCardDtls(card,customer,TimeZone.getDefault());  
	
	}
	
	public void swipeOut(SmartCardDetails cardDtls, String destination, TimeZone dateTime) throws SQLException, InsufficientException {
		
		Calendar dtTime=Calendar.getInstance(dateTime);
        stationFootFall.putIfAbsent(destination, new AtomicInteger());
        stationFootFall.get(destination).incrementAndGet();
        CardTrx trx = new CardTrx();
        SmartCardDetails card= jdbc.getSmartCardDetailsByCardNum(cardDtls);
        trx.setDestination(destination);
        trx.setEndTime(dtTime.getTime());
        MetroStationDetails dest= MetroStationDetails.valueOf(destination);
        MetroStationDetails src= MetroStationDetails.valueOf(trx.source);
        trx.setDistance(dest.distance(src));
        double journeyFare=fareCalc.getFare(src, dest, dtTime);
        trx.setFare(journeyFare);
        if (!validator.validateInsufficientBalance(cardDtls.getCardbalance(), journeyFare)) {
            throw new InsufficientException("Insufficient balance at Swipe Out, Please recharge card and try again");
        }
        trx.setFareStrategyUsed(JourneyFarePlanFactory.getFareStrategy(dtTime));
        trx.setBalance(cardDtls.getCardbalance() - trx.getFare());
        card.setCardBalance(cardDtls.getCardbalance() - trx.getFare());
        jdbc.updateEndTime(cardDtls, trx, dateTime);
    }
	
	public int calculateFootFall(MetroStationDetails station) {
			return 1;
	}
    
    public List<CardTrx> cardReport(SmartCardDetails card) throws SQLException {
        List<CardTrx> trxs = jdbc.getListOfCardDetailsFromCardTrx(card);
        
        return trxs;
    }
}
