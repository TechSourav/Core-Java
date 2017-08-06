package com.pck.thread.exercise;

import java.util.concurrent.BlockingQueue;

public class ConsumerTh extends Thread{
	
	private final BlockingQueue<Message> queue;
	
	ConsumerTh(BlockingQueue<Message> q){
		this.queue=q;
	}
	
	public void run(){
		try{
			Message msg;
			while((msg=queue.take()).getMessage()!="exit"){
				Thread.sleep(100);
				System.out.println("Consumed: "+ msg.getMessage());
			}
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}

}
