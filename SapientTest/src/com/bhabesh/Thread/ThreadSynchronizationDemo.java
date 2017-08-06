package com.bhabesh.Thread;

public class ThreadSynchronizationDemo {
	
	public static void main(String[] args){
		
		// Example :: 1 ::
		
		/*Display display = new Display();
		MyFirstThreadSynchronization mt = new MyFirstThreadSynchronization(display,"DHONI");
		MyFirstThreadSynchronization mt1 = new MyFirstThreadSynchronization(display,"SACHIN");
		MyFirstThreadSynchronization mt2 = new MyFirstThreadSynchronization(display,"KHOLI");
		MyFirstThreadSynchronization mt3 = new MyFirstThreadSynchronization(display,"RAINA");
		mt.start();
		mt1	.start();
		mt2.start();
		mt3.start();*/
		
		// Example :: 2::
		
		Display display1 = new Display();
		Display display2 = new Display();
		MyFirstThreadSynchronization mt = new MyFirstThreadSynchronization(display1,"DHONI");
		MyFirstThreadSynchronization mt1 = new MyFirstThreadSynchronization(display2,"SACHIN");
		
		mt.start();
		mt1	.start();
		
		
		
	}

}
