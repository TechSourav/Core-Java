package com.sourav;

public class ArrayFrequency {

	public static void main(String[] args) {
		int[] arr= {1,3,2,4,1,4,4,4,5,7,9,3};
		findFrequency(arr);
		for(int i:arr){
			System.out.print(i+",");
		}

	}
	private static void findFrequency(int[] arr){
		int len= arr.length;
		System.out.println("Length : "+ len);
		int temp[]= new int[len];
		for(int i=0;i<len;i++){
			temp[arr[i]]+=1;
		}
		for(int i=0;i<len;i++){
			arr[i]=temp[i];
		}
	}
	
	

}
