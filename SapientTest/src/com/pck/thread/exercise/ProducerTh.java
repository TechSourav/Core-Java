package com.pck.thread.exercise;

import java.util.concurrent.BlockingQueue;

public class ProducerTh extends Thread{
	
	private final BlockingQueue<Message> queue;
	
	ProducerTh(BlockingQueue<Message> q){
		this.queue=q;
	}
	
	public void run(){
		for(int i=0;i<5;i++){
			Message m = new Message(""+i);
			
			try {
				Thread.sleep(50);
				queue.put(m);
				System.out.println("Produced: "+ m.getMessage());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		Message m = new Message("Exit");
		try{
			queue.put(m);	
		}catch(InterruptedException e){
			e.printStackTrace();
			}
		
		
	}

}
