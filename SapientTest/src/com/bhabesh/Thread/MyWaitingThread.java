package com.bhabesh.Thread;

public class MyWaitingThread extends Thread {

	int total = 0;
	public void run(){
		
		synchronized(this){
		for(int i=0;i<101;i++){
			total = total+i;
		}
		System.out.println("Child Thread Nitified.. ");
		this.notify();
		System.out.println("Child thread updating");
		}
	}
	
}
