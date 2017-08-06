package com.sapient.sourav.thread;

import java.util.concurrent.Semaphore;

class SemDemo {

	public static void main(String[] args){
		Semaphore sem = new Semaphore(1);
		
		new IncThread(sem, "A");
		new DecThread(sem, "B");
	}
	
}

class SharedResource{
	
	static int count=0;
}


