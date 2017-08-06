package com.bhabesh.Thread;

public class ThreadSleepDemo {

	public static void main(String[] args) throws InterruptedException{
		
		MySleepingThread mt = new MySleepingThread();
		mt.start();
		//mt.join(10000);
		mt.interrupt();
		for(int i=0;i<10;i++){
			System.out.println("Main Thread..");
		}
		
	}
	
}
