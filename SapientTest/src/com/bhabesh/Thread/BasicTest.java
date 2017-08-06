package com.bhabesh.Thread;

public class BasicTest {
	public static void main(String[] args) throws InterruptedException{
		
		ThreadB b = new ThreadB();
		b.start();
		synchronized(b){
			System.out.println("Parent thread starts execution..");
			b.wait();
			System.out.println("Main got notified..");
			System.out.println(b.total);
		}
		
	}

}

class ThreadB extends Thread{
	int total =0;
	public void run(){
		synchronized(this){
			System.out.println("Child Thread starts calculation..");
			for(int i=0;i<10;i++){
				total=total+i;
			}
			System.out.println("Child thread give notification.."+ total );
			this.notify();
		}
	}
	
}