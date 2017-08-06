package com.sapient.sourav;

import java.util.Arrays;

public class TestQuickSort {
	
	public static void main(String[] args){
		int[] arr ={10,15,50,40,35,-9,-2,0};
		System.out.println("Unsorted Array::");
		printArray(arr);
		sortArray(arr, 0,arr.length-1);
		System.out.println("Sorted Array::");
		printArray(arr);
	}
	private static void printArray(int[] arr){
		System.out.println(Arrays.toString(arr));
	}
	
	private static void sortArray(int[] arr, int low, int high)
	{
		if(low<high){
			int pos= partition(arr, low, high);
			System.out.println("Partition is done on : " + pos);
			printArray(arr);
			sortArray(arr, low, pos-1);
			sortArray(arr, pos+1,high);
		}
	}
	private static int partition(int[] arr, int low , int high){
		 
		int pivot = arr[low];
		int left=low, temp;
		int right = high;
		while(left<right){
			while(left<right && arr[left]<=pivot && left<=high){
				left++;
			}
			while(arr[right]>pivot){
				right--;
			}
			if(left<right){
				temp= arr[left];
				arr[left]= arr[right];
				arr[right]=temp;
		   }
		}
		
		arr[low]=arr[right];
		arr[right]=pivot; // placing the pivot in right position..
		return right;
	}

}
