package com.sapient.sourav;

import java.util.Arrays;

public class TestMergeSort {
	
	public static void main(String[] args){
		
		int[] arr = inputArray();
		System.out.println("Unsorted Array ::");
		dispalyArray(arr);
		sortArray(arr);
		System.out.println("Sorted Array ::");
		dispalyArray(arr);
		
	}
	
	public static int[] inputArray(){
		int [] arr ={10,22,15,20,11,5,14};
		return arr;
	}
	
	public static void dispalyArray(int[] array){
		System.out.println(Arrays.toString(array));
		
	}
	public static void sortArray(int[] arr){
		mergeSort(arr,0,arr.length-1);
	}
    public static void mergeSort(int[] array,int low,int high){
    	if(low<high){
    		int mid = (low+high)/2;
    		mergeSort(array,low,mid);
    		mergeSort(array,mid+1,high);
    		merge(array,low,mid,high);
    	}
    	
    }
    
    public static void merge(int[] array,int low,int mid, int high){
    	
    	int [] temp = new int[high-low+1];
    	int left = low;
    	int right = mid+1;
    	int k=0;
    	while(left<=mid && right<=high){
    		if(array[left]<array[right]){
    			temp[k]= array[left];
    			left+=1;
    		}else if(array[left]>array[right]){
    			temp[k]= array[right];
    			right+=1;
    		}
    		k+=1;
    	}
    	
    	if(left<=mid){
    		while(left<=mid){
    			temp[k]= array[left];
    			left =left+1;
    			k+=1;
    		}
    	}else if(right<=high){
    		while(right<=high){
    			temp[k]= array[right];
    			right+=1;
    			k+=1;
    		}
    	}
    	
    	for(int i=0; i <temp.length;i++){
    		array[low+i]=temp[i];
    	}
    }
}
