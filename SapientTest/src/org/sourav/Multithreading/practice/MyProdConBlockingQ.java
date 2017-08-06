package org.sourav.Multithreading.practice;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class MyProdConBlockingQ {

	public static void main(String[] args) {
		BlockingQueue<PersonalMessage> bq = new ArrayBlockingQueue<PersonalMessage>(10);
		
		MyProducerBQ mprodbq =new  MyProducerBQ(bq);
		MyConsumerBQ mconbq = new  MyConsumerBQ(bq);
		mprodbq.start();
		mconbq.start();
	}

}

class MyProducerBQ extends Thread{
	
	private final BlockingQueue<PersonalMessage> bq;
	
	MyProducerBQ(BlockingQueue<PersonalMessage> q){
		this.bq=q;
	}
	
	public void run(){
		
	   for(int i=0;i<10;i++){
		PersonalMessage pm = new PersonalMessage("" +i);	
		System.out.println("Inside Producer Queue..");
		try {
			Thread.sleep(50);
			bq.put(pm);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Produced: "+ i);
	   }
	   
	   PersonalMessage pm = new PersonalMessage("EXIT");
	   try {
		bq.put(pm);
	   }catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	
}


class MyConsumerBQ extends Thread{
	
	private final BlockingQueue<PersonalMessage> bq;
	
	MyConsumerBQ(BlockingQueue<PersonalMessage> q){
		this.bq=q;
	}
	
	public void run(){
		
		try {
		PersonalMessage pmsg;
		
		while((pmsg=bq.take()).getMsg()!="Exit"){
				Thread.sleep(50);
				System.out.println("Consumed: "+ pmsg.getMsg());
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}	
	
}