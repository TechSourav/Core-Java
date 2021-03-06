package com.sapient.sourav.thread;

import java.util.concurrent.Semaphore;

public class IncThread implements Runnable{
	
	Semaphore sem;
	String name="";
	
	IncThread(Semaphore s, String n){
		sem=s;
		name =n;
		new Thread(this).start();
		
	}

	@Override
	public void run() {
		System.out.println("Starting:"+ name);
		try{
		System.out.println(name+ " is waiting for a permit");
		sem.acquire();
		System.out.println(name+ " gets a permit");
		
		for(int i=0;i<5;i++){
			SharedResource.count++;
			System.out.println(name+ " : " +SharedResource.count);
		    Thread.sleep(1000);
		}
		}catch(InterruptedException ex){
			ex.printStackTrace();
		}
		System.out.println(name+ " releases the permit");
		sem.release();
	}

}
