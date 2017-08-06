package com.sourav.designPattern.PizzaDecorator;

public class TomatoKetchup extends TopicDecorator {

	TomatoKetchup(IPizza pizza) {
		super(pizza);
		System.out.println("Add Tomato Ketchup");
	}

	public String getDescription() {
		return tempPizza.getDescription();
	}
	
	public double getCost() {
		// TODO Auto-generated method stub
		return tempPizza.getCost() + 50.00;
	}
}
