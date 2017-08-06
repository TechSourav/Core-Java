package com.sapient.sourav;

public class Application {

	public static void main(String[] args){
		
		XYZ a =  new XYZ();
		a.setValue(888);
		System.out.println(a.getValue());
		
	}
	
}

class XYZ{
	
	private int value;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
