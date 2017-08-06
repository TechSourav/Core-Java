package com.bhabesh.Thread;

public class ThreadWaitingDemo {
	
	public static void main(String[] args) throws InterruptedException{
		
		MyWaitingThread mwt = new MyWaitingThread();
		
		mwt.start();
		
		synchronized(mwt){
			System.out.println("Main thread waiting..");
		mwt.wait();
		//Thread.sleep(12000);
		System.out.println(mwt.total);
		}
	}

}
