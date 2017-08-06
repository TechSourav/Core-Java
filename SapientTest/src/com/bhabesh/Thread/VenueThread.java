package com.bhabesh.Thread;

public class VenueThread implements Runnable{
	
	@Override
	public void run() {
		
		WeddingCardPrintingThread.venTh=Thread.currentThread();
		
		for(int i=0;i<2;i++){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Venue Decided" + i);
		}
	}

}
