package com.bhabesh.Thread;

public class ThreadExample1 {
	
	public static void main(String[] args) throws InterruptedException{
		
		ThreadChild1 lockingObj = new ThreadChild1();
		lockingObj .start();
		synchronized(lockingObj ){
			for(int i=1;i<10;i++){
				System.out.println("Main "+i);
			}
			lockingObj.wait();
			System.out.println("Main got notified");
		
		}
		
	}

}

class ThreadChild1 extends Thread{
	
	public void run(){
		synchronized(this){
			for(int i=1;i<10;i++){
				System.out.println("Child "+i);
			}
			this.notify();
			}
	}
}





