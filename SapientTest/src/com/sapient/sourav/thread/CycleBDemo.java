package com.sapient.sourav.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CycleBDemo {
	
	public static void main(String[] args){
		
		CyclicBarrier cb = new CyclicBarrier(3, new BarAction());
		System.out.println("Starting");
		new MyThread1(cb,"A");
		new MyThread1(cb,"B");
		new MyThread1(cb,"C");
		
		new MyThread1(cb,"X");
		new MyThread1(cb,"Y");
		new MyThread1(cb,"Z");
		
	}

}

class MyThread1 implements Runnable{
	
	CyclicBarrier cb;
	String name;
	
	MyThread1(CyclicBarrier cb, String n){
		this.cb=cb;
		this.name=n;
		new Thread(this).start();
	}

	@Override
	public void run() {
		System.out.println(name);		
		try {

			//int x= cb.await();
			System.out.println("Variable : "+ cb.await());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}


class BarAction implements Runnable{
	public void run(){
		System.out.println("Barrier is Reached!!");
	}
}

