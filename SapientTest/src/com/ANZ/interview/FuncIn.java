package com.ANZ.interview;

@FunctionalInterface
public interface FuncIn {
	FuncIn up();
	
	public default void method(){
		System.out.println("hi Venkat");
	}
	
	static void method2(){
		System.out.println("Hi Rashid");
	}
	
	public static void main(String[] args){
		FuncIn f = ()->()->() -> null;
		System.out.println(f.up());
	}
	
}


