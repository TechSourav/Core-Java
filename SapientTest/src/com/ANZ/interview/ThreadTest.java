package com.ANZ.interview;

import java.util.LinkedList;
import java.util.List;

/**
 *  Print Even Odd numbers 
 * 
 ***/


/*public class ThreadTest {

	public static void main(String[] args) {
		Object lock = new Object();
		Thread t1= new Thread(new Thread1(lock));
		Thread t2= new Thread(new Thread2(lock));
	    t1.start();
	    t2.start();
	}

}

class Thread1 implements Runnable{
	Object lock;
	Thread1(Object lock){
		this.lock=lock;
	}

	@Override
	public void run() {
		synchronized(lock){
			for(int i=1;i<21;i++){
				if(i%2==1){
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					System.out.println(i);
					lock.notify();
					try {
						lock.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		}
	}
	
}

class Thread2 implements Runnable{
	Object lock;
	Thread2(Object lock){
		this.lock=lock;
	}
	@Override
	public void run() {
		synchronized(lock){
			for(int i=1;i<21;i++){
				if(i%2==0){
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					System.out.println(i);
					lock.notify();
					try {
						lock.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		}
	}
	
}*/



public class ThreadTest {
	
	public static void main(String[] args){
       		List<String> list= new LinkedList<>();
			Thread t1= new Thread(new Producer(list));
       		Thread t2= new Thread(new Consumer(list));
       		t1.start();
       		t2.start();
	}
}

class Producer implements Runnable{
	List<String> list;
	Producer(List<String> list){
		this.list=list;
	}
	
	@Override
	public void run() {
		synchronized(list){
			//if(list.size()){
				for(int i=1;i<11;i++){
					System.out.println("Producer thread producing:- "+ i);
					list.add("Added task:- "+i);
					list.notifyAll();
				}
				try {
					list.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			//}
		}
		
	}
	
}

class Consumer implements Runnable{
	List<String> list;
	Consumer(List<String> list){
		this.list=list;
	}
	
	@Override
	public void run() {
		synchronized(list){
			while(!list.isEmpty()){
				for(int i=1;i>11;i++){
					System.out.println("Consumer thread consuming:- "+ i);
					System.out.println("Reoving task:- "+ list.remove(i));
					list.notifyAll();
				}
			}
			try {
				list.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}