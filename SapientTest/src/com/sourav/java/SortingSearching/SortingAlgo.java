package com.sourav.java.SortingSearching;


public class SortingAlgo {

	public static void main(String[] args) {
		int[] arr1= {6,3,5,2,1,4,8,7,9};
		int[] arr2= {20,19,15,13,18,16,11,12};
		//bubbleSort(arr);
		insertionSort(arr1);
		selectionSort(arr2);
		quickSort(arr1);
		mergeSort(arr1);

	}
	
	private static void printArray(String str, int[] arr){
		System.out.println(str);
		for(Integer i:arr){
			System.out.println(i + " ");
		}
	}
	private static void bubbleSort(int[] arr){
		int temp=0;
		for(int i=0;i<arr.length-1;i++){
			for(int j=0;j<arr.length-i-1;j++){
				if(arr[j]>arr[j+1]){
					temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
				
			}
		}
		printArray("Bubble Sort ::",arr);
	}
	
	private static void insertionSort(int[] arr){
		
		/*int n= arr.length;
		int temp=0;
		for(int i=1;i<n-1;i++){
			for(int j=0;j<i;j++){
				if(arr[i]<arr[j]){
					temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
		}*/
		
		int n= arr.length;
		for(int i=1;i<n;++i){
			int key=arr[i];
			int j=i-1;
			while(j>=0 && arr[j]>key){
				arr[j+1]=arr[j];
				j=j-1;
			}
			arr[j+1]=key;
		}
		
		printArray("Insertion Sort ::",arr);
	}
	
	private static void selectionSort(int[] arr){
		int n= arr.length;
		for(int i=0;i<n;i++){
			int min =i;
			int j=i+1;
			for(;j<n;j++){
				if(arr[j]<arr[min]){
					min=j;
				}
			}
			int temp=arr[i];
			arr[i]=arr[min];
			arr[min]=temp;
		}
		
		printArray("Selection Sort ::",arr);
	}
	
	private static void quickSort(int[] arr){
		
	}
	
	private static void mergeSort(int[] arr){
		
	}

}
