package com.sourav.designPattern.CarBuilder;

public class LigthMotorBuilder implements CarBuilder{
	
	public Car car;
	
	LigthMotorBuilder(){
	   this.car= new Car();	
	}

	@Override
	public void buildCarBase() {
		// TODO Auto-generated method stub
		car.setCarBase("Flat");
	}

	@Override
	public void buildCarDoors() {
		// TODO Auto-generated method stub
		car.setCarDoors("White");
	}

	@Override
	public void buildCarRoof() {
		// TODO Auto-generated method stub
		car.setCarRoof("Wooden");
	}

	@Override
	public void buildCarWindows() {
		// TODO Auto-generated method stub
		car.setCarWindows("5");
	}

	@Override
	public void buildCarEngine() {
		// TODO Auto-generated method stub
		car.setCarEngine("4 Cylinders");
	}

	@Override
	public void buildCarWheel() {
		// TODO Auto-generated method stub
		car.setCarWheel("4");
	}

	@Override
	public void buildCarSteering() {
		// TODO Auto-generated method stub
		car.setCarSteering("Power Steering");
	}

	@Override
	public Car getCar() {
		// TODO Auto-generated method stub
		return this.car;
	}

}
