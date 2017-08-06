package com.sapient.sourav.thread;

import java.util.concurrent.Semaphore;

public class ConsumerSem implements Runnable{
	
	Semaphore sm;
	String name;
	Q q;
	
	ConsumerSem(Q s, String n){
		q=s;
		name=n;
		new Thread(this).start();
	}

	@Override
	public void run() {
		for(int i =0; i<10; i++){
			q.get();
		}		
	}

}
