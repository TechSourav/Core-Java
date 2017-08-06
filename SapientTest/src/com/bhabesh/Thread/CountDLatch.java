package com.bhabesh.Thread;

import java.util.concurrent.CountDownLatch;

public class CountDLatch {
	
	public static void main(String[] args) throws InterruptedException{
		CountDownLatch cdl = new CountDownLatch(3);
		MyLatch ml = new MyLatch(cdl);
		ml.start();
		System.out.println("Started the Latch from Main..");
		cdl.await();
		
		for(int i=0;i<3;i++){
			System.out.println("Printing: "+ i);
		}
	}

}

class MyLatch extends Thread{
	CountDownLatch cdl;
	MyLatch(CountDownLatch c){
		this.cdl=c;
	}
	public void run(){
		for(int i=0;i<3;i++){
			System.out.println("In MyLatch Thread and I am counting " + i);
			cdl.countDown();
		}
		
	}
}
