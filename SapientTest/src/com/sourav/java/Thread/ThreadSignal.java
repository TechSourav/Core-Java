package com.sourav.java.Thread;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadSignal implements Runnable {
	AtomicInteger counter;
	static final Object mutex = new Object();
	public ThreadSignal(AtomicInteger counter){
		this.counter = counter;
	}
	@Override
	public void run() {
		while(true){
			synchronized(mutex){
				if(Integer.parseInt(Thread.currentThread().getName()) == counter.get()){
					System.out.println("Signal: " + Thread.currentThread().getName() + " is green");
					if(counter.get() == 4){
						counter.getAndSet(1);
					}else{
						int c = counter.get();
						counter.getAndSet(++c);
					}
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("Signal: " + Thread.currentThread().getName() + " is yellow");
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				mutex.notifyAll();
				try {
					mutex.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
