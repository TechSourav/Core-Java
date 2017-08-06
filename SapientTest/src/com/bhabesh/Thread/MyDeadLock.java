package com.bhabesh.Thread;

public class MyDeadLock {

	public static void main(String[] args) {
		
		Thread1 t1= new Thread1();
		Thread2 t2= new Thread2();
		t1.start();
		t2.start();
	}

}

class Thread1 extends Thread{
	
	public void run(){
	  synchronized(String.class){
		  System.out.println(Thread.currentThread().getName() + "Inside String.class");
		  synchronized(Integer.class){
			  System.out.println(Thread.currentThread().getName() + "Inside Integer.class");  
		  }
	  }	
	}
}

class Thread2 extends Thread{
	
	public void run(){

		  synchronized(Integer.class){
			  System.out.println(Thread.currentThread().getName() +  "Inside Integer.class");
			  synchronized(String.class){
				  System.out.println(Thread.currentThread().getName() + "Inside String.class");  
			  }
		  }	
		
	}

}
