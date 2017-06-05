package org.sourav.delhi.metrosmartcard.util;

public class CustomerDetails {
	
	long cust_id;
	String name;
	String cardNum;
	
	public String getCardNum() {
		return cardNum;
	}
	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}
	public long getCust_id() {
		return cust_id;
	}
	public void setCust_id(long cust_id) {
		this.cust_id = cust_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public CustomerDetails(){
		
	}
	
	public CustomerDetails(String name,String cardNum){
		this.name=name;
		this.cardNum=cardNum;
		
	}

}
