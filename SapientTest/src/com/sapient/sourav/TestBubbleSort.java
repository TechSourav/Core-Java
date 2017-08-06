package com.sapient.sourav;

import java.util.Arrays;

public class TestBubbleSort {
	
	public static void main(String[] args){
		
		int[] arr=readArray();
		System.out.println("Unsorted Array::");
		printArray(arr);
		sortArray(arr);
		System.out.println("Sorted Array::");
		printArray(arr);
	}
	private static int[] readArray(){
		int[] arr= {10,15,50,40,35,-9,-2,0};
		return arr;
	}
	private static void printArray(int[] arr){
		System.out.println(Arrays.toString(arr));
	}
	private static void sortArray(int[] arr){
		int temp;
		
		//Approach 1
		
		/*for(int i=0; i<arr.length;i++){
			for(int j=0;j<arr.length-1;j++){
				if(arr[j]>arr[j+1]){
				temp = arr[j];
				arr[j]=arr[j+1];
				arr[j+1]=temp;
				}
			}
			
		}*/
		
		// Approach 2
		
		boolean flag= true;
		while(flag){
			flag= false;
			for(int j=0;j<arr.length-1;j++){
				if(arr[j]>arr[j+1]){
				temp = arr[j];
				arr[j]=arr[j+1];
				arr[j+1]=temp;
				flag= true;
				}
			}
			
		}
	}

}
