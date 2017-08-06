package com.sourav.designPattern.HouseDecorator;

public class HouseDecoratorMaker {

	public static void main(String[] args){
		IHouse house = new TilesDecor(new LightDecor(new HouseDecorator(new SimpleHouse())));
		System.out.println("House details: " + house.getHouseDescription());
		System.out.println("House made of : " + house.makeHouse());
	}

}
