package com.sourav.java.Thread;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadSeqThree {
	
	

	public static void main(String[] args){
		
		AtomicInteger count = new AtomicInteger(1);
		int[] array1 = {1,4,7};
		int[] array2= {2,5,8};
		int[] array3 = {3,6,9};
		
		ThreeSeq ts1 = new ThreeSeq(array1,count,"1");
		ThreeSeq ts2 = new ThreeSeq(array2,count,"2");
		ThreeSeq ts3 = new ThreeSeq(array3,count,"3");
		
		ts1.start();
		ts2.start();
		ts3.start();
		
	}
	
}

class ThreeSeq extends Thread{
	private int[] arr;
	AtomicInteger counter;
	String name;
	static final  Object mutex = new Object();
	
	ThreeSeq(int[] arr, AtomicInteger count,String n){
		this.arr=arr;
		this.counter=count;
		this.setName(n);
	}
	public void run(){
		int i=0;
		while(i<arr.length){
			synchronized(mutex){
				if(Integer.parseInt(Thread.currentThread().getName())==counter.get()){
					System.out.println(arr[i]);
					if(counter.get()==3){
						counter.getAndSet(1);
					}else{
						int c=counter.get();
						counter.getAndSet(++c);
					}
					i++;
				}
				mutex.notify();
				try {
					mutex.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
		}
		
		
		
	}
	
}


