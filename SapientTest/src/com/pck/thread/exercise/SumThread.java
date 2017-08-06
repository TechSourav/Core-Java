package com.pck.thread.exercise;

 /**
 * This thread finds the sum of a subsection of an array.
 */
public class SumThread extends Thread {
	
	private int[] arr;
	private int lo;
	private int hi;
	private int ans=0;
	
	SumThread(int[] arr, int low, int high){
		this.lo=low;
		this.arr=arr;
		this.hi=high;
	}
	
	public void run(){
		for(int i=lo;i<hi;i++){
			ans+=arr[i];
		}
	}
	
	public static int sum(int[] arr) throws InterruptedException{
		
	int len= arr.length;
	SumThread[] th = new SumThread[4];
	int ans=0;
	for(int i=0; i <4;i++){
		th[i]=new SumThread(arr, (i*len)/4,((i+1)*len/4));
		th[i].start();
	}
	
	for(int i=0; i <4;i++){
			th[i].join();
			ans+=th[i].ans;
	}
	return ans;
	} 
	
    
    public static void main(String[] args) throws InterruptedException {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        int sum = sum(arr);
        System.out.println("Sum: " + sum);
    }
    
    
}