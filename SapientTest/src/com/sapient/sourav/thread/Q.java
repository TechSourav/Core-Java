package com.sapient.sourav.thread;

import java.util.concurrent.Semaphore;

public class Q {

	int count;
	
	// initially consumer will not be able to start..
			Semaphore semCon = new Semaphore(0);
			Semaphore proCon = new Semaphore(1);
			
	public void put(int count){
	
		try {
			proCon.acquire();
			System.out.println("PUT: " + count);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.count=count;
		semCon.release();
		
	}
	public void get(){
		try {
			semCon.acquire();
			System.out.println("GET: " + count);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		proCon.release();
	}
}
