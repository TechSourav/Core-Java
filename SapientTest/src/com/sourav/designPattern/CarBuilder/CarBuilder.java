package com.sourav.designPattern.CarBuilder;

public interface CarBuilder {
	
	public void buildCarBase();
	public void buildCarDoors();
	public void buildCarRoof();
	public void buildCarWindows();
	public void buildCarEngine();
	public void buildCarWheel();
	public void buildCarSteering();
	public Car getCar(); 
}
