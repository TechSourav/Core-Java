package com.sourav.designPattern.PizzaDecorator;

public class TopicDecorator implements IPizza{
	
	protected IPizza tempPizza;
	
	TopicDecorator(IPizza pizza){
		this.tempPizza=pizza;
	}

	@Override
	public String getDescription() {
		return tempPizza.getDescription();
	}

	@Override
	public double getCost() {
		// TODO Auto-generated method stub
		return tempPizza.getCost();
	}

}
