package org.sourav.delhi.metrosmartcard.util;

import java.util.Date;

import org.sourav.delhi.metrosmartcard.IJourneyFarePlan;

public class CardTrx {
    long id;
    SmartCardDetails card;
    String source;
    String destination;
    int distance;
    Date startTime;
    Date endTime;
    double balance;
    double fare;
    IJourneyFarePlan fareStrategyUsed;
	public IJourneyFarePlan getFareStrategyUsed() {
		return fareStrategyUsed;
	}
	public void setFareStrategyUsed(IJourneyFarePlan fareStrategyUsed) {
		this.fareStrategyUsed = fareStrategyUsed;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public SmartCardDetails getCard() {
		return card;
	}
	public void setCard(SmartCardDetails card) {
		this.card = card;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
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
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public double getFare() {
		return fare;
	}
	public void setFare(double fare) {
		this.fare = fare;
	}
 
}
