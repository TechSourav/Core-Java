package com.bhabesh.Thread;

public class WeddingCardPrintingThread implements Runnable{
	
	static Thread venTh;

	@Override
	public void run() {
		
		WeddingCardDistThread.weddingCardDistTh = Thread.currentThread();
		
		try {
			venTh.join();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for(int i=1;i<=50;i++){
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println( i + "Wedding card gets printed.. ");
		}	
		
		
		
	}
}
