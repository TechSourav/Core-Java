package com.sourav.designPattern.PizzaDecorator;

public class PlainPizza implements IPizza{

	@Override
	public String getDescription() {
		
		return "Different Tupes of Pizza";
	}

	@Override
	public double getCost() {
		// TODO Auto-generated method stub
		return 200.00;
	}

}
