package com.sapient.sourav;

public class Motherboard {

	private String model="";
	private String manufacturer="";
	private String ramSlots="";
	private String bios="";
	private String cardSlots="";
	
	Motherboard(String md, String m, String r,String b, String c){
		this.model=md;
		this.manufacturer=m;
		this.ramSlots=r;
		this.bios=b;
		this.cardSlots=c;
	}
	public void loadProgram(String program){
		System.out.println("Program"+ program+ "is loaded");
	}
	
	public String getModel() {
		return model;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public String getRamSlots() {
		return ramSlots;
	}

	public String getBios() {
		return bios;
	}

	public String getCardSlots() {
		return cardSlots;
	}

	
	
}
