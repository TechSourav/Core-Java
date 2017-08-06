package com.sapient.sourav.thread;

import java.util.concurrent.Semaphore;

public class ProConSem {
	
	public static void main(String[] args){
		
		Q q = new Q();
		new ProducerSem(q,"Producer");
		new ConsumerSem(q,"Consumer");
	}

}
