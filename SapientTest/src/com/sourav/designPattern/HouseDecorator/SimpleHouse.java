package com.sourav.designPattern.HouseDecorator;

public class SimpleHouse implements IHouse{

	@Override
	public String makeHouse() {
		return "Going to decoate the house.";
	}

	@Override
	public String getHouseDescription() {
		return "this is a simple house";
	}

}
