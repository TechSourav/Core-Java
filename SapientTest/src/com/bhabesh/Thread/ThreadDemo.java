package com.bhabesh.Thread;

public class ThreadDemo {

	public static void main(String[] args) throws InterruptedException{
		
		MyThread mt = new MyThread();
		mt.start();
		//mt.join(10000);
		mt.interrupt();
		mt.run(1);
		
		for(int i=0;i<10;i++){
			System.out.println("Main Thread..");
		}
		
	}
	
}
