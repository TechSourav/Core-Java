package com.bhabesh.Thread;

public class WeddingDemo {
	
	public static void main(String[] args) throws InterruptedException {
		
		VenueThread vt = new VenueThread();
		WeddingCardPrintingThread wcpt= new WeddingCardPrintingThread();
		WeddingCardDistThread acdt = new WeddingCardDistThread();
		
		Thread t1 = new Thread(vt);
		Thread t2 = new Thread(wcpt);
		Thread t3 = new Thread(acdt);
		
		t1.start();
		t2.start();
		t3.start();
		t3.join();
		
		for(int i=0; i<5;i++){
			System.out.println("Inside main thread.. ");
		}
		
	}

}
