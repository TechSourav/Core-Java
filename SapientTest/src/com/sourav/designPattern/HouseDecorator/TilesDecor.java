package com.sourav.designPattern.HouseDecorator;

public class TilesDecor extends HouseDecorator{

	TilesDecor(IHouse house) {
		super(house);
		System.out.println("Congratulations!! Adding tiles to your new house");
	}

	@Override
	public String makeHouse() {
		// TODO Auto-generated method stub
		return decorHouse.makeHouse() + "\n Adding tiles here. ";
	}

	@Override
	public String getHouseDescription() {
		// TODO Auto-generated method stub
		return decorHouse.getHouseDescription();
	}
	
	
}
