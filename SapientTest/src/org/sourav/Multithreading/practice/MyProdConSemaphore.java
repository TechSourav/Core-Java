package org.sourav.Multithreading.practice;

import java.util.concurrent.Semaphore;

public class MyProdConSemaphore {
	
	public static void main(String[] args){
		
		Semaphore conTh  =  new Semaphore(0);
		Semaphore prodTh =  new Semaphore(1);	
		
		MyProducerSem mps= new MyProducerSem(prodTh,conTh);
		MyConsumerSem mcs= new MyConsumerSem(conTh,prodTh);
		
		mps.start();
		mcs.start();
		
		
	}

}

class MyProducerSem extends Thread{
	
	Semaphore sct;
	Semaphore spt;
	
	MyProducerSem(Semaphore prod, Semaphore con){
		this.spt=prod;
		this.sct=con;
	}
	
	public void run(){
		
		for(int i=0;i<10;i++){
			
			try {
				spt.acquire();
				System.out.println("Produced: "+ i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			sct.release();
		}
	   
		
   }

}

class MyConsumerSem extends Thread{
	
	Semaphore sct;
	Semaphore spt;
	
	MyConsumerSem(Semaphore con, Semaphore prod){
		this.spt=prod;
		this.sct=con;
	}
	
	public void run(){
	   
		for(int i=0;i<10;i++){
			
			try {
				sct.acquire();
				System.out.println("Consumed: "+ i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			spt.release();
		}
   }

}



