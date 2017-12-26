package com.sourav.java.Thread;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class MyPCBQ {
	
	public static void main(String[] args){
		BlockingQueue<Info> queue = new ArrayBlockingQueue<Info>(5);
		int size=5;
		ProdCustomBQ pc = new ProdCustomBQ(queue,size);
		ConCustomBQ cc = new ConCustomBQ(queue,size);
		pc.start();
		cc.start();
	}

}

class ConCustomBQ extends Thread{
	private final BlockingQueue<Info> queue;
	private final int size;
	
	ConCustomBQ(BlockingQueue<Info> q, int s){
		this.queue=q;
		this.size=s;
	}
	
	public void run(){
	Info msg = new Info("");
		try {
			while((msg=queue.take()).getMessage()!="exit"){
				System.out.println("Consumded: "+ msg.getMessage());
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}

class ProdCustomBQ extends Thread{
	private final BlockingQueue<Info> queue;
	private final int size;
	
	ProdCustomBQ(BlockingQueue<Info> q, int s){
		this.queue=q;
		this.size=s;
	}
	
	public void run(){
		for(int i=0;i<5;i++){
			Info m = new Info(" "+i);
			try {
				Thread.sleep(1000);
				queue.put(m);
				System.out.println("Produced "+ i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Info m = new Info("EXIT");
		try {
			queue.put(m);
			System.out.println("WE are out!");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}



