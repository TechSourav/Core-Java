package com.sourav.java.Array;

public class FindDuplicate {

	public static void main(String[] args) {
		int[] arr={1,2,3,4,5,2,4,6,7,6};
		printDuplicate(arr,arr.length);
	}
	
	private static void printDuplicate(int[] arr, int size){
		for(int i=0;i<size;i++){
			if(arr[Math.abs(arr[i])]>=0){
				arr[Math.abs(arr[i])]=-arr[Math.abs(arr[i])];
			}else{
				System.out.print(Math.abs(arr[i])+ " ");
			}
		}
	}

}
