package com.bhabesh.Thread;

public class TestThreadBhavesh {
	
	public static void main(String[] args){
		
		Sapient sp = new Sapient();
		TCS tc = new TCS();
		TestThread1 t1 = new TestThread1(sp);
		TestThread2 t2 = new TestThread2(tc);
		
		t1.start();
		t2.start();
	}

}

class Sapient{
	
	public void peopleSuccess(){
		System.out.println("Inside Sapient People Success Department.");
	}
}

class TCS{
	
	public void resourceManagement(){
		System.out.println("Inside TCS Resource Management Department.");
	}
}

class TestThread1 extends Thread{
	Sapient sp;
	static Thread th2 ;
	TestThread1(Sapient s){
		this.sp=s;
	}
	public void run(){
		
		try {
			Thread.sleep(2000);
			th2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sp.peopleSuccess();
	}
}

class TestThread2 extends Thread{
	TCS tc;
	
	TestThread2(TCS t){
		this.tc=t;
	}
	public void run(){
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TestThread1.th2 = Thread.currentThread();
		tc.resourceManagement();
	}
}


