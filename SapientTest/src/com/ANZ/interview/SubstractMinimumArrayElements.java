package com.ANZ.interview;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class SubstractMinimumArrayElements {

	public static void main(String[] args) {
		int[] arr = {6,7,5,9,8,1,4,3};
		int length =  arr.length;
		int[] newArray= new int[arr.length];
		int count=0;
		System.out.println("Array Length"+ length);
		PriorityQueue<Integer> queue1 = new PriorityQueue<Integer>();
		PriorityQueue<Integer> tempQueue = new PriorityQueue<Integer>();
		for(int i=0;i<length;i++){
			queue1.add(arr[i]);
		}
		System.out.println("Queue"+ queue1);
		while(!allEqual(arr,0)){
			for(int i=0;i<length;i++){
				int x = queue1.peek();
				if(arr[i]>0){
					tempQueue.add(arr[i]-x);
					arr[i]=arr[i]-x;
				}
			}
			queue1.clear();
			tempQueue.poll();
			queue1.addAll(tempQueue);
			tempQueue.clear();
			count++;
		}
		System.out.println("Total Loop count : "+count);
	}
	
	public static boolean allEqual(int[] array, int element) {
	    for(int e : array) {
	        if(e != element) {
	            return false;
	        }
	    }
	    return true;
	}

}
