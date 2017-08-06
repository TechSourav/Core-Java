package com.bhabesh.Thread;

public class MyThread1 extends Thread{

	GeneralClass gc;
	String name;
	MyThread1(GeneralClass g, String s){
		this.gc=g;
		this.name=s;
	}
	
	public void run(){
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		gc.m1(name);
	}
	
}

class MyThread2 extends Thread{

	GeneralClass gc;
	String name;
	MyThread2(GeneralClass g, String s){
		this.gc=g;
		this.name=s;
	}
	
	public void run(){
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		gc.m2(name);
	}
	
}

class TestBhaveshProblem{
	
public static void main(String[] args){
	
	GeneralClass gc = new GeneralClass();
	
	MyThread1 mt1 = new MyThread1(gc,"mt1");
	MyThread2 mt2 = new MyThread2(gc,"mt2");
	
	mt1.start();
	mt2.start();
}	
	
	
}

