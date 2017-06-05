package org.sourav.delhi.metrosmartcard.util;

import java.sql.SQLException;
import java.util.TimeZone;

import org.sourav.delhi.metrosmartcard.exception.InsufficientException;
import org.sourav.delhi.metrosmartcard.exception.MinimumBalanceException;

public class DelhiMetroSmartCardProcessing {

	public static void main(String args[]) throws SQLException, MinimumBalanceException, InsufficientException{
		
		CustomerJourney custJourney  = new CustomerJourney();
		// Swipe the Card 
		SmartCardDetails cardDtls=custJourney.processCustomerJourney();
		// Card Swipe out
		custJourney.swipeOut(cardDtls, MetroStationDetails.A8.toString(), TimeZone.getDefault());
		// get report of card details..
		custJourney.cardReport(cardDtls);
		//calcuate footfall
		custJourney.calculateFootFall(MetroStationDetails.A8);
		
	}
	
}
