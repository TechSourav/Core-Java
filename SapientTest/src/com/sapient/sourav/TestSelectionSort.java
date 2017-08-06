package com.sapient.sourav;

import java.util.Arrays;

public class TestSelectionSort {
	
	public static void main(String[] args){
		int[] arr ={10,15,50,40,35,-9,-2,0};
		System.out.println("Unsorted Array::");
		printArray(arr);
		sortArray(arr);
		System.out.println("Sorted Array::");
		printArray(arr);
	}
	private static void printArray(int[] arr){
		System.out.println(Arrays.toString(arr));
	}
	private static int findLargest(int[] arr, int len){
		
		int index=0 ;
		int length = len;
		int largest= arr[index];
		for(int i=1;i<length;i++ ){
			if(arr[i]>largest){
				largest= arr[i];
				index= i;
			}
		}
		
		return index;
	}
	
	private static void sortArray(int[] arr){
		int len= arr.length;
		int temp= 0;
		for(int i=len-1;i>=0;i--){
			int largestIndex=findLargest(arr,len);
			temp = arr[i];
			arr[i]=arr[largestIndex];
			arr[largestIndex]=temp;
			len-=1;
		}
	}

}
