package com.morgan.interview;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class T1T2T3 {
	
	public static void main(String[] args){
		
		Worker wk1 = new Worker();
		Worker wk2 = new Worker();
		Worker wk3 = new Worker();
		Worker wk4 = new Worker();
		
		wk1.setName("Thread - 1 :: ");
		wk2.setName("Thread - 2 :: ");
		wk3.setName("Thread - 3 :: ");
		wk4.setName("Thread - 4 :: ");
		
		
		wk1.setNext(wk2);
		wk2.setNext(wk3);
		wk3.setNext(wk4);
		wk4.setNext(wk1);
		
		wk1.start();
		wk2.start();
		wk3.start();
		wk4.start();
		
		wk1.accept(1);
		
	}

}

class Worker extends Thread{
	BlockingQueue<Integer> bq = new LinkedBlockingQueue<Integer>();
	Worker next =null;
	//int [] arr;
	//Object obj;
	public void setNext(Worker t){
		this.next=t;
	}
	
	public void accept(int i){
		bq.add(i);
	}
		
	public void run(){
		
		while(true){
		  try{ 
				int x = bq.take();
				System.out.println( Thread.currentThread().getName() + "Green");
				Thread.sleep(2000);
				System.out.println( Thread.currentThread().getName() + "Yellow");
				if(next!=null){
					next.accept(x+1);
				}	
				
				Thread.sleep(2000);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			
		}
	}
}


