package com.sapient.sourav.thread;

import java.util.concurrent.Semaphore;

public class ProducerSem implements Runnable{
	
	Semaphore sm;
	String name;
	Q q;
	
	ProducerSem(Q s, String n){
		q=s;
		name=n;
		new Thread(this).start();
	}

	@Override
	public void run() {
		for(int i =0; i<10; i++){
			q.put(i);
		}		
	}

}
