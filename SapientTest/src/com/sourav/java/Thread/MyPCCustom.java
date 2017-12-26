package com.sourav.java.Thread;

import java.util.ArrayList;
import java.util.List;

class Info {
	
	private String message;

	Info(String msg){
		this.message=msg;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}

public class MyPCCustom {
	
	public static void main(String[] args){
		List queue = new ArrayList();
		int size=5;
		ProdCustom pc = new ProdCustom(queue,size);
		ConCustom cc = new ConCustom(queue,size);
		System.out.println(pc.getState());
		pc.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
			
			@Override
			public void uncaughtException(Thread t, Throwable e) {
				
				
			}
		});
		pc.start();
		cc.start();
	}
	
}

class ProdCustom extends Thread{

	private final List sharedQ;
	private final int size;	
	ProdCustom(List q, int size){
		this.sharedQ=q;
		this.size=size;
	}
	
	public void run(){
		
		for(int i=0;i<5;i++){
			//Info msg = new Info(" "+i);
			
			while(sharedQ.size()==this.size){
			synchronized(sharedQ){
				
					System.out.println("Queue is full");
					try {
						this.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
			synchronized(sharedQ){
				this.notifyAll();
				sharedQ.add(i);
				System.out.println(i + "Added to the queue");
			}
			
		}
	}
	
}

class ConCustom extends Thread{

	private final  List sharedQ;
	private final  int size;	
	ConCustom(List q, int size){
		this.sharedQ=q;
		this.size=size;
	}
	public void run(){
	
		while(true){
			while(sharedQ.isEmpty()){
			 synchronized(sharedQ){
				
					System.out.println("Queue is Empty..");
					try {
						this.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
			synchronized(sharedQ){
				this.notify();
				System.out.println("Consumder consumed "+ sharedQ.remove(0));
			}
			
		}
		
	}



}