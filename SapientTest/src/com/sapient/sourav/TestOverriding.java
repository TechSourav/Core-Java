package com.sapient.sourav;

import java.io.IOException;

public class TestOverriding {
	
	public static void main(String[] args) throws IOException{
		
	Vehicle v =  new Car();
	v.accelerator();
	v.brake();
	v.windows();
	System.out.println(v.noOfSeat());	
	v.drive(1,2);	
	}

}

class Vehicle{
	
	void brake() throws IOException{
		System.out.println("Inside Vehicle Brake");
	} 
	
	Object accelerator(){
		System.out.println("Inside Vehicle accelerator");
		return "";
	}
	
	int noOfSeat(){
		System.out.println("Inside Vehicle Seat");
		return 3;
	}
	
	static void windows(){
		System.out.println("Inside Vehicle Windows");
	}
	
	void drive(int...is){
		System.out.println("Drive Vehicle");
	}
}

class Car extends Vehicle{
	
	void brake() throws IOException{
		System.out.println("Inside Car Brake");
	} 
	
	String accelerator(){
		System.out.println("Inside car accelerator");
		return "";
	}
	
	final int noOfSeat(){
		System.out.println("Inside car Seat");
		return 5;
	}
	
	static void windows(){
		System.out.println("Inside car Windows");
	}
	
	void drive(int...is){
		System.out.println("Drive Car");
	}
	
}