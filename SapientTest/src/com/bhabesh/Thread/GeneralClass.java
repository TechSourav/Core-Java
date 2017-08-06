package com.bhabesh.Thread;

public class GeneralClass {
	
	public static synchronized void m1(String n){

			for(int i = 0; i<5;i++){
				
				System.out.println("Inside static "+ n  +" "+ i);
			}
	}
	
	public synchronized void m2(String n){
		for(int i = 0; i<5;i++){
			
			System.out.println("Inside non static "+n+" "+ i);
		}
	}

}
