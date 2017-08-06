package com.sourav.java.Array;

public class GeeksArray1 {

	public static void main(String[] args) {
	
		int[] arr = {6, 2, 3, 2, 1}; // 6, 1, 3, 2, 5
		
		int count = arr.length;
		
		System.out.println("No of characters:  "+count);
		
		int sum=0;
		
		for(int i=0;i<count;i++){
			sum+=arr[i];
			
		}
		int element = sum%2;
		System.out.println("The element"+ element+ "is to be removed.");
		
	}

}
