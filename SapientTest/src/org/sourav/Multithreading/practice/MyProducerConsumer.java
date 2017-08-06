package org.sourav.Multithreading.practice;

import java.util.ArrayList;
import java.util.List;

public class MyProducerConsumer {

	public static void main(String[] args) {
		
		List list = new ArrayList();
		int size=10;
		MyProducerTh mpt = new MyProducerTh(list,size);
		MyConsumerTh mct = new MyConsumerTh(list,size);
		
		mpt.start();
		mct.start();

	}

}

class MyProducerTh extends Thread{
	
	private final List al;
	private final int size;
	MyProducerTh(List l, int s){
		this.al=l;
		this.size=s;
	}
	
	public void run(){
		
		for(int i=0;i<10;i++){
			while(al.size()==size){
				synchronized(al){
					System.out.println("List is FULL");
					try {
						al.wait();
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
			
			synchronized(al){
				al.add(i);
				System.out.println("Produced: " + i);
				al.notify();
			}
		}
		
	}
}

class MyConsumerTh extends Thread{
	
	private final List al;
	private final int size;
	
	MyConsumerTh(List l,int s){
		this.al=l;
		this.size=s;
	}
	
	public void run(){
		
		while(true){
			try {
				Thread.sleep(50);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		while(al.isEmpty()){
			synchronized(al){
				try {
					al.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
			synchronized(al){
				System.out.println("Inside Consumer thread..");
				al.notify();
				System.out.println("Consumed - "+ al.remove(0));
			}
		}
	}
}
