package com.sapient.sourav;

public class Monitor {
	
	private String model="";
	private String manufacturer="";
	private Resolution resltn;
		
	public Monitor(String model, String manufacturer, Resolution resltn) {
		super();
		this.model = model;
		this.manufacturer = manufacturer;
		this.resltn = resltn;
	}
	
	public void drwaPixelAt(int x, int y, int color){
		System.out.println("Drawing pixel at:"+ x+y+color);
	}
	public String getModel() {
		return model;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public Resolution getResltn() {
		return resltn;
	}

}
