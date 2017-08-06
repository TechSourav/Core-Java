package com.sapient.sourav;

public class Case {
	private String model;
	private String manufacturer;
	private String powerSupply;
	private Dimensions dimension;
	
	public Case(String model, String manufacturer, String powerSupply,
			Dimensions dimension) {
		super();
		this.model = model;
		this.manufacturer = manufacturer;
		this.powerSupply = powerSupply;
		this.dimension = dimension;
	}

	public String getModel() {
		return model;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public String getPowerSupply() {
		return powerSupply;
	}

	public Dimensions getDimension() {
		return dimension;
	}
	
	
	

}
