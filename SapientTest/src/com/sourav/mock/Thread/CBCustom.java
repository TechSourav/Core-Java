package com.sourav.mock.Thread;

public class CBCustom {
	
	private int partiesAwait;
	private int initialParties;
	Runnable action;
	
	CBCustom(int cnt, Runnable act){
		this.initialParties=cnt;
		this.partiesAwait=cnt;
		this.action=act;
		
	}
	
	public synchronized void await() throws InterruptedException{
		partiesAwait--;
		if(partiesAwait>0){
			this.wait();
		}else{
			partiesAwait=initialParties;
			this.notifyAll();
			this.action.run();
		}
	}

}

class MyBarrier extends Thread{
	CBCustom cb;
	
	MyBarrier(CBCustom c){
		this.cb=c;
	}
	public void run(){
		for(int i=0;i<3;i++){
			System.out.println("Thread- "+ i);
			try {
				cb.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class MyBarrierTest {
	public static void main(String[] atr){
		CBCustom cbc = new CBCustom(3, new BarrierAction());
		MyBarrier mb1 = new MyBarrier(cbc);
		MyBarrier mb2 = new MyBarrier(cbc);
		MyBarrier mb3 = new MyBarrier(cbc);
		mb1.start();
		mb2.start();
		mb3.start();
		System.out.println("...JOB DONE...");
	}
}

class BarrierAction implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Hi ! I am inside BarrierAction");
	}
	
}

