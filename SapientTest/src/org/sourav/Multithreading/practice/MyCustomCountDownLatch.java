package org.sourav.Multithreading.practice;

public class MyCustomCountDownLatch {
	
	private int count;
	
	MyCustomCountDownLatch(){}
	
	MyCustomCountDownLatch(int count){
		this.count=count;
	}
	
	public synchronized void await() throws InterruptedException{
		if(count>0)
			this.wait();
	}
	
	public synchronized  void countDown(){
		count--;
		if(count==0){
			this.notifyAll();
		}
	}
	
}

class CustomCountDownLatchTest {
	
	public static void main(String[] args) throws InterruptedException{
		
		MyCustomCountDownLatch mcdl = new MyCustomCountDownLatch(2);
		
		CustomCDLThread cdl = new CustomCDLThread(mcdl);
		cdl.start();
		System.out.println("..Main...");
		mcdl.await();
		System.out.println("..HUrrahhhhhhhhhhh...");
	} 	
	
	
}

class CustomCDLThread extends Thread{
	
	MyCustomCountDownLatch cdl;
	CustomCDLThread(MyCustomCountDownLatch c){
		this.cdl=c;
		
	}
	
	public void run(){
	  
		for(int i =0;i<2;i++){
			System.out.println(".. Child.." + i);
			cdl.countDown();
		}
	}
}







