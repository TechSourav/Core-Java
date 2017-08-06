package com.bhabesh.Thread;

public class MyThread extends Thread{
	
	public void run(){
		
		try {
			
		for(int i=0;i<10;i++){
			
				System.out.println("I am Lazy Thread..");
				Thread.sleep(3000);
			}
		}catch (InterruptedException e) {
				System.out.println("I am Interrupted.. ");
			}
			System.out.println("Child Thread..");
			//Thread.yield();
		}
	
	
	public void run(int i){
		
		System.out.println("HIIIII");
	}

}
