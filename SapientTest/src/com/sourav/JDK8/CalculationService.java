package com.sourav.JDK8;

public class CalculationService {
	
	private ICalculationService addition;
	private ICalculationService subs;
	private ICalculationService multi;
	
	public int execute(String type, int x , int y){
		if(type.equals("add"))
			return calculateAdd(x, y);
		if(type.equals("subs"))
			return calculateSubs(x, y);
		if(type.equals("multi"))
			return calculateMulti(x, y);
		else
			return 0;
	}
	
	public int calculateAdd(int x, int y) {
		addition = new AdditionCalculationService();
		System.out.println("addition: "+ Thread.currentThread().getName());
		return addition.calculate(x, y);
	}
	public int calculateSubs(int x, int y) {
		subs = new SubstructionCalculationService();
		System.out.println("subs: "+ Thread.currentThread().getName());
		return subs.calculate(x, y);
		}
	public int calculateMulti(int x, int y) {
		multi = new MultiplicationCalculationService();
		System.out.println("multi: "+ Thread.currentThread().getName());
		return multi.calculate(x, y);
	}
}
