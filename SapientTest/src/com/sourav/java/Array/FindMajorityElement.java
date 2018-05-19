package com.sourav.java.Array;


/**
 * Moore voting algo. 
 **/

public class FindMajorityElement {

	public static void main(String[] args) {
		
		int [] arr = {1,2,2,2,2,3,4};
		int i =getMajorityElement(arr);
		if(isMajorityElement(i,arr)){
			System.out.println(i + " is majority element.");
		}else{
			System.out.println("No element is majority.");
		}
	}
	
	private static int getMajorityElement(int[] arr){
		int count=1;
		int majorityEle = 0;
		for(int index=1; index<arr.length; index ++){
			if(arr[majorityEle]== arr[index]){
				count++;
			}else{
				count--;
			}
			if(count==0){
				majorityEle=index;
				count=1;
			}
		}
		return arr[majorityEle];
	}
	
	private static boolean isMajorityElement(int i, int[] arr){
		int count=0;
		for(int x=0;x<arr.length;x++){
			if(arr[i]==arr[x])
				count++;
		}
		return (count>arr.length/2);
	}
}
