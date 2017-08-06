package com.sapient.sourav.thread;

import java.util.concurrent.Semaphore;

public class PrintEvenOddNumberSemaphore {

	public static void main(String[] args) {
		
		SharePoint spoint = new SharePoint();
		EvenThread et = new EvenThread(spoint);
		OddThread  ot = new OddThread(spoint);
		Thread th1= new Thread(et);
		Thread th2= new Thread(ot);
		th1.start();
		th2.start();
	
	}

}

class EvenThread implements Runnable{

	SharePoint sp;
	
	EvenThread(SharePoint s){
	 	this.sp=s;
	}
	
	@Override
	public void run() {
	
		for(int i=1;i<=20;i++){
			if(i%2==0){
				sp.printEvenNumber(i);
			}
		}
	}
	
}

class OddThread implements Runnable{

	SharePoint sp;
	
	OddThread(SharePoint s){
	 	this.sp=s;
	}
	
	@Override
	public void run() {
		
		for(int i=1;i<=20;i++){
			if(i%2!=0){
				sp.printOddNumber(i);
			}
		}
		
	}
	
}

class SharePoint{
	
	Semaphore sp1 = new Semaphore(0);
	Semaphore sp2 = new Semaphore(1);
	
	public void printOddNumber(int num){
		try {
			sp2.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(num);
		sp1.release();
	}
	
	public void printEvenNumber(int num){
		try {
			sp1.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(num);
		sp2.release();
	}
	
}




