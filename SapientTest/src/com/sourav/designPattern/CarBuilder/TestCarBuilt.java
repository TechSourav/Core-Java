package com.sourav.designPattern.CarBuilder;

public class TestCarBuilt {

	public static void main(String[] args) {
		CarBuilder car = new LigthMotorBuilder();
		MechanicalEngineer me = new MechanicalEngineer(car);
		me.makeCar();
		System.out.println(car.getCar().getBase());
		System.out.println(car.getCar().getDoors());
		System.out.println(car.getCar().getEngine());
		System.out.println(car.getCar().getRoof());
		System.out.println(car.getCar().getSteering());
		System.out.println(car.getCar().getWheel());
		System.out.println(car.getCar().getWindows());
	}

}
