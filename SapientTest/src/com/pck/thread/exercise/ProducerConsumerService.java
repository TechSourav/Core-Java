package com.pck.thread.exercise;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerService {
	
	public static void main(String[] args){
		BlockingQueue<Message> queue = new ArrayBlockingQueue<>(10);
		ProducerTh pt = new ProducerTh(queue);
		ConsumerTh ct = new ConsumerTh(queue);
		pt.start();
		ct.start();	
		System.out.println("Producer and consumer Thread has been started.");
		
		
	}

}
