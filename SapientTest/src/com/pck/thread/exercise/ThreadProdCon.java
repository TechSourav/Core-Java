package com.pck.thread.exercise;

import java.util.ArrayList;
import java.util.Vector;

public class ThreadProdCon {

	public static void main(String[] args){
		
		Vector lst = new Vector();
		int size = 7;
		
		Thread prodTh = new Thread(new Producer(lst,size),"Producer");
		Thread conTh = new Thread(new Consumer(lst,size),"Consumer");
		
		prodTh.start();
		conTh.start();
	}
	
}

class Producer extends Thread{
	
	private final Vector list;
	private final int sz;
	
	Producer(Vector l, int s){
		this.list = l;
		this.sz=s;
	}
	
	public void run(){
		
		for(int i=0;i<7;i++){
			try {
				produce(i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public void produce(int i) throws InterruptedException{
		
		while(list.size()==sz){
			synchronized(list){
				System.out.println("Queue is Full of "+ Thread.currentThread().getName() + " no other elements can be added."+ list.size());
				list.wait();
			}
		}
		synchronized(list){
		System.out.println("Produced: "+ i);
		list.add(i);
		list.notify();	
		}
		
	}
	
}

class Consumer extends Thread{
	
	private final Vector list;
	private final int sz;
	
	Consumer(Vector l, int s){
		this.list = l;
		this.sz=s;
		
	}
	
	public void run(){
		while(true){
		
			try {
				System.out.println("Consumed: " + consume());
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public int consume() throws InterruptedException{
		
		while(list.isEmpty()){
			synchronized(list){
			System.out.println("Queue is empty "+ Thread.currentThread().getName()+ " no more elements to be taken "+ list.size());
			list.wait();
		}
		
		}
		
		synchronized(list){
			list.notify();
			return (Integer)list.remove(0);
		}
	}
	
}

