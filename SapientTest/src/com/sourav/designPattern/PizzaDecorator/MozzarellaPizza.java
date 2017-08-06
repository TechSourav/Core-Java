package com.sourav.designPattern.PizzaDecorator;

public class MozzarellaPizza extends TopicDecorator {

	MozzarellaPizza(IPizza pizza) {
		super(pizza);
		System.out.println("Add Mozarella");
	}

	public String getDescription() {
		return tempPizza.getDescription();
	}
	
	public double getCost() {
		// TODO Auto-generated method stub
		return tempPizza.getCost() + 100.00;
	}
}
