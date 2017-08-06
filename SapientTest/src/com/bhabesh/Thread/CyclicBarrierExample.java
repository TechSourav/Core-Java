package com.bhabesh.Thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {
	
	public static void main(String[] args){
		CyclicBarrier cb = new CyclicBarrier(2, new BarrierClass());
		MyBarrierClass mbc = new MyBarrierClass(cb,"A");
		MyBarrierClass mbc2 = new MyBarrierClass(cb,"B");
		System.out.println("Going to call MyBarrierClass from "+ Thread.currentThread().getName());
		mbc.start();
		mbc2.start();
		
	}

}

class MyBarrierClass extends Thread {
	
	CyclicBarrier c;
	String s;
	
	MyBarrierClass(CyclicBarrier cb, String s){
		this.c=cb;
		this.s=s;
	}
	
	public void run(){
		System.out.println("WIthin "+ s);
		
		for(int i=0;i<3;i++){
			System.out.println("Hi "+i);
		}
		
		try {
			c.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}

class BarrierClass implements Runnable{

	
	@Override
	public void run() {
		
	System.out.println(" ........................................    ");	
	}
	
	
}


