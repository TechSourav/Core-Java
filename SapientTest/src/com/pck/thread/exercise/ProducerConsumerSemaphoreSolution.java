package com.pck.thread.exercise;

import java.util.concurrent.Semaphore;

public class ProducerConsumerSemaphoreSolution {

	public static void main(String[] args){
		
		Semaphore conSem= new Semaphore(0);
		Semaphore prodSem= new Semaphore(1);
		
		Thread prod = new Thread(new ProducerSem(prodSem,conSem));
		Thread con = new Thread(new ConsumerSem(conSem,prodSem));
		
		prod.start();
		con.start();
	}
}

class ProducerSem extends Thread{
	
	private Semaphore semodProd;
	private Semaphore semodCon;
	
	ProducerSem(Semaphore s, Semaphore n){
		this.semodProd=s;
		this.semodCon=n;
	}
	
	public void run(){
      for(int i=1;i<=5;i++){
		try {
			semodProd.acquire();
			System.out.println("Aquired Lock on Producer thread Semaphore");
			System.out.println("Produced: "+ i);
			semodCon.release();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
      }
		
	}
	
}

class ConsumerSem extends Thread{
	
	private Semaphore semodProd;
	private Semaphore semodCon;
	
	ConsumerSem(Semaphore scon, Semaphore nprod){
		this.semodProd=nprod;
		this.semodCon=scon;
	}
	
	public void run(){
      for(int i=1;i<=5;i++){
		try {
			semodCon.acquire();
			System.out.println("Aquired Lock on Consumed thread Semaphore");
			System.out.println("Consumed: "+ i);
			semodProd.release();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
      }
		
	}
	
}