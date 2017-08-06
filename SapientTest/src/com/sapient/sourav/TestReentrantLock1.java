package com.sapient.sourav;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class TestReentrantLock1 {
	
	public static void main(String[] args){
		
		MyThread5 m1 = new MyThread5();
		MyThread5 m2 = new MyThread5();
		m1.start();
		m2.start();
		
	}

}

class MyThread5 extends Thread{
	static ReentrantLock t = new ReentrantLock();
	
	public void run(){
	
	
	try {
		if(t.tryLock(1,TimeUnit.HOURS)){
			System.out.println(Thread.currentThread().getName()+ " got the lock after trying");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(t.getHoldCount());
			t.unlock();
		}else{
			System.out.println(Thread.currentThread().getName()+ " Fed up Trying..");
		}
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
 }
}
