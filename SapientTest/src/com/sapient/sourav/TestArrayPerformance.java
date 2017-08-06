package com.sapient.sourav;

import java.util.ArrayList;

public class TestArrayPerformance {
	
	public static void main(String[] args){
		ArrayList arr= new ArrayList();
		for(int i = 0; i<=1000; i++){
			arr.add(i);
		}
		
		m(null);
	}
	static void m(B b){
		synchronized(b){
			System.out.println("Hi");
		}
	}

}
class B{
	
}