package org.sourav.delhi.metrosmartcard.util;

public class TravelFareValidator {
	
	public TravelFareValidator(){
		
	}
	
	public boolean validateMinimumBalance(double cardBalance, double baseFare){
		
		if(cardBalance>baseFare)
			return true;
		else
		    return false;
	}
	
public boolean validateInsufficientBalance(double cardBalance, double journeyFare){
		
		if(cardBalance>journeyFare)
			return true;
		else
		    return false;
	}

}
