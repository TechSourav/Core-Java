package com.ANZ.interview;

public class TestDeadlock {
	
	public static void main(String[] args){
		Thread11 t1 = new Thread11();
		Thread22 t2 = new Thread22();
		t1.start();
		t2.start();
	}

}

class Thread11 extends Thread{
	
	public void run(){
		m1();
	}
	public void m1(){
		synchronized(String.class){
			System.out.println("Hi. Inside String.class method of Thread11");
			synchronized(Integer.class){
				System.out.println("Hi. Inside Integer.class method of Thread11");	
			}	
		}
	}
}

class Thread22 extends Thread{
	
	public void run(){
		m2();
	}
	public void m2(){
		synchronized(Integer.class){
			System.out.println("Hi. Inside Integer.class method of Thread22");
			synchronized(String.class){
				System.out.println("Hi. Inside String.class method of Thread22");	
			}	
		}
	}
}