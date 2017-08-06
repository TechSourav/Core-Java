package com.sourav.mock.Thread;

public class CDLCustom {
	
	private int count;
	
	CDLCustom(int cnt){
		this.count=cnt;
	}
	
	public synchronized void await() throws InterruptedException{
	
		if(count>0){
			this.wait();
		}
		
	}
	
	public synchronized  void countDown(){
		
		count--;
		
		if(count==0){
			this.notifyAll();
		}
		
	}

}

class CDLCustomTest{
	
	public static void main(String[] args) throws InterruptedException{
		CDLCustom latch = new CDLCustom(3);
        MyLatch ml = new MyLatch(latch);
        System.out.println("Going to call countdpwn latch");
        ml.start();
        latch.await();
        System.out.println("latch opened");
	}
	
}

class MyLatch extends Thread{
	CDLCustom  cdl;
	
	MyLatch(CDLCustom l){
		this.cdl=l;
	}
	
	public void run(){
		for(int i=0;i<4;i++){
			System.out.println("Thread - "+ i);
			cdl.countDown();
		}
	}
	
}



