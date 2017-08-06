package com.sourav.designPattern.HouseDecorator;

public class LightDecor extends HouseDecorator{

	LightDecor(IHouse house) {
		super(house);
		System.out.println("Congratulations!! Adding light to your new house");
	}

	@Override
	public String makeHouse() {
		// TODO Auto-generated method stub
		return decorHouse.makeHouse() + "\n Adding light here. ";
	}

	@Override
	public String getHouseDescription() {
		// TODO Auto-generated method stub
		return decorHouse.getHouseDescription();
	}
	
	
}
