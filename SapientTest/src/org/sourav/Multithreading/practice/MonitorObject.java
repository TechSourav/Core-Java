package org.sourav.Multithreading.practice;

public class MonitorObject {

public static void main(String[] args) throws InterruptedException	{
	
		MySharedObject t1 = new MySharedObject();
		
        t1.start();
        
        synchronized(t1){
        	
        	System.out.println("I am in main thread..");
        	for(int i=1;i<=10;i++){
        		if(i%2==1){
        			System.out.println("Hi Main Odd- "+ i);
        			t1.notify();
        			t1.wait();
        		}
			}
        	//t1.wait();
        	System.out.println("Returning from Child");
        	System.out.println("Happy waiting ...");
        }
}
}

class MySharedObject extends Thread{
	
	
	public void run(){
		
		System.out.println("I am inside Child Thread now..");
		
		synchronized(this){
			for(int i=1;i<=10;i++){
				if(i%2==0){
					System.out.println("Hi CHild Even- "+ i);
					this.notify();
        			try {
						this.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			//this.notify();
			System.out.println(".............  NOTIFIED ..........");
		}
		
		
	}
	
}

