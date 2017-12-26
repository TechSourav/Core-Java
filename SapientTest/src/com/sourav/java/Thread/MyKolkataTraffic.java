package com.sourav.java.Thread;

import java.util.LinkedHashMap;
import java.util.PriorityQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyKolkataTraffic {
	
	public static void main(String[] args) {
		
		Lock lock = new ReentrantLock();
		Condition conSignal1 = lock.newCondition();
		Condition conSignal2 = lock.newCondition();
		Condition conSignal3 = lock.newCondition();
		
		KolkataTrafficSignal signal1 = new KolkataTrafficSignal();
		KolkataTrafficSignal signal2 = new KolkataTrafficSignal();
		KolkataTrafficSignal signal3 = new KolkataTrafficSignal();
		KolkataTrafficSignal signal4 = new KolkataTrafficSignal();
		
		signal1.start();
		signal2.start();
		signal3.start();
		signal4.start();
		
	}
		

}

class KolkataTrafficSignal extends Thread{
	
	static ReentrantLock lock = new ReentrantLock();
	
	@Override
	public void run(){
		
		lock.lock();
		
		System.out.println("Signal " + Thread.currentThread() + " Green.. ");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Signal " + Thread.currentThread() + " Yellow.. ");
		
		lock.unlock();
		
	}
	
}


