package com.sourav.mock.Thread;

import java.util.concurrent.atomic.AtomicInteger;

public class TrafficSignalTest {

	public static void main(String[] args) {
		AtomicInteger counter = new AtomicInteger(1);
		
		ThreadSignal obj1 = new ThreadSignal(counter);
		ThreadSignal obj2 = new ThreadSignal(counter);
		ThreadSignal obj3 = new ThreadSignal(counter);
		ThreadSignal obj4 = new ThreadSignal(counter);
		
		Thread t1 = new Thread(obj1, "1");
		Thread t2 = new Thread(obj2, "2");
		Thread t3 = new Thread(obj3, "3");
		Thread t4 = new Thread(obj4, "4");
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}

}
