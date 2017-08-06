package com.sourav.designPattern.CarBuilder;

public class MechanicalEngineer {

	private CarBuilder carBuilder;
	
	public MechanicalEngineer(CarBuilder carBuilder){
		this.carBuilder=carBuilder;
	}
	
	public Car getCar(){
	return this.carBuilder.getCar();	
	}
	
	public void makeCar(){
		this.carBuilder.buildCarBase();
		this.carBuilder.buildCarDoors();
		this.carBuilder.buildCarEngine();
		this.carBuilder.buildCarRoof();
		this.carBuilder.buildCarSteering();
		this.carBuilder.buildCarWheel();
		this.carBuilder.buildCarWindows();
		
	}
	
}
