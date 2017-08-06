package com.sourav.designPattern.PizzaDecorator;

public class PizzaMaker {
	public static void main(String[] args){
		IPizza pizza= new TomatoKetchup(new MozzarellaPizza(new TopicDecorator(new PlainPizza())));
		System.out.println("Basic Ingredient: "+ pizza.getDescription());
		System.out.println("Cost of Pizza: "+ pizza.getCost());
	}
}
