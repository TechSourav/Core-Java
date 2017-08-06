package org.sourav.Multithreading.practice;

import java.util.concurrent.CountDownLatch;

public class DeadLockByCDL {
	
	public static void main(String[] args){
		
		Object mutex1 = new Object();
		Object mutex2 = new Object();
		
		CountDownLatch cdl = new CountDownLatch(2);
		
		MyCDLDead md1 = new MyCDLDead(mutex1,mutex2,cdl);
		MyCDLDead md2 = new MyCDLDead(mutex2,mutex1,cdl);
		
		md1.start();
		md2.start();
		
	}

}


class MyCDLDead extends Thread{
	
	Object mutex1;
	Object mutex2;
	
	CountDownLatch cdl;
	
	MyCDLDead(Object o1, Object o2 , CountDownLatch cdl){
		this.mutex1=o1;
		this.mutex2=o2;
		this.cdl=cdl;
	}
	
	public void run(){
		
		synchronized(mutex1){
		  cdl.countDown();
		  System.out.println(Thread.currentThread().getName());
		  try {
			cdl.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  synchronized(mutex2){
			  System.out.println("Thread Finished");
		  }
		}
	}
}

