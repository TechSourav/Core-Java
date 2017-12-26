package com.sourav.java.SortingSearching;

import java.util.Arrays;

public class TestInsertionSort {
	
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
	
	public static void sortArray(int[] arr){
		int temp;
		for(int i=1;i<=arr.length-1;i++){
			for(int j=0;j<=i;j++){
				if(arr[j]>arr[i]){
					temp=arr[j];
					arr[j]=arr[i];
					arr[i]=temp;
				}
			}
			
		}
		
	}

}
