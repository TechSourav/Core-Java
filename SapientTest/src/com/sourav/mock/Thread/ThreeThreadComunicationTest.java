package com.sourav.mock.Thread;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreeThreadComunicationTest {

	public static void main(String[] args) {
		
		AtomicInteger counter = new AtomicInteger(1);
		int[] array1 = new int[]{1, 4, 7};
		int[] array2 = new int[]{2, 5, 8};
		int[] array3 = new int[]{3, 6, 9};
		
		ThreeThreadComunication obj1 = new ThreeThreadComunication(array1, counter);
		ThreeThreadComunication obj2 = new ThreeThreadComunication(array2, counter);
		ThreeThreadComunication obj3 = new ThreeThreadComunication(array3, counter);
		
		Thread t1 = new Thread(obj1, "1");
		Thread t2 = new Thread(obj2, "2");
		Thread t3 = new Thread(obj3, "3");
		
		t1.start();
		t2.start();
		t3.start();
	}

}
