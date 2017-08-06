package com.sourav.designPattern.HouseDecorator;

public class HouseDecorator implements IHouse{

	protected IHouse decorHouse;
	HouseDecorator(IHouse house){
		this.decorHouse=house;
	}
	
	@Override
	public String makeHouse() {
		// TODO Auto-generated method stub
		return "Welcome to house decorator. ";
	}

	@Override
	public String getHouseDescription() {
		// TODO Auto-generated method stub
		return "This is house Decorator. ";
	}

}
