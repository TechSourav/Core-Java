package com.sapient.sourav;

class SuperClass{
	
	public int x;
	
	{
		System.out.println("In Super Initializer block");
	}
	
	SuperClass(){
		System.out.println("In Super");
	}
	
	public static int m(){
		System.out.println("In Super M()");
		return 7;
	}
	
}

class SubClass extends SuperClass{
	
	public int y=8;
	
	{
		System.out.println("In SUB Initializer block");
	}
	
	SubClass(){
		System.out.println("In Sub");
		y=100;
		System.out.println(y);
	}
	
	
	public static int m(){
		System.out.println("In Sub m()");
		return 3;
	}
	
}

public class Test {
	
	public static void main(String[] args){
		
		SuperClass sc = new SubClass();
		System.out.println(sc.m());
		
	}

}


