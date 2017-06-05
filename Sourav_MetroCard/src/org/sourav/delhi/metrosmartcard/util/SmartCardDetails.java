package org.sourav.delhi.metrosmartcard.util;

import java.util.Date;


public class SmartCardDetails {
	
	

	private  String ScId;
	private String cardNum;
	CustomerDetails customerDtl;
	private static double CardBalance = 100;
	private final double MIN_VALUE = 5;
	private String startStation;
	private String endStation;
	private String DayOfYear;
	private Date startTime;
	private Date endTime;
	
	
	public SmartCardDetails(){
		
	}
	
	public SmartCardDetails(String scId, String startStation, String day){
		this.ScId = scId;
		this.startStation = startStation;
		this.DayOfYear=day;
	}
	
	public String getStartStation() {
		return startStation;
	}
	public void setStartStation(String startStation) {
		this.startStation=startStation;
	}
	
	public String getDay() {
		return DayOfYear;
	}
	
	public String getEndStation() {
		return endStation;
	}

	public void setEndStation(String endStation) {
		this.endStation = endStation;
	}


	public double getCardbalance() {
		return CardBalance;
	}

	public String getCardNum() {
		return cardNum;
	}

	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}

	public String getScId() {
		return ScId;
	}

	public void setScId(String scId) {
		ScId = scId;
	}

	public CustomerDetails getCustomerDtl() {
		return customerDtl;
	}

	public void setCustomerDtl(CustomerDetails customerDtl) {
		this.customerDtl = customerDtl;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}	

	public static double getCardBalance() {
		return CardBalance;
	}

	public static void setCardBalance(double cardBalance) {
		CardBalance = cardBalance;
	}
}
