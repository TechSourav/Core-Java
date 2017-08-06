package com.bhabesh.Thread;

public class MySleepingThread extends Thread {
	
	public void run(){
		
		for(int i=0;i<10000;i++){
			System.out.println("I am lazy thread"+ i);
		}
		System.out.println("I am tired..");
		
		try {
			Thread.sleep(2000);
			System.out.println("I am sleeping..");
		} catch (InterruptedException e) {
			System.out.println("I am inturrrepted..");
		}
		System.out.println("AAAAAAAAAAAAAAAA");
	}

}
