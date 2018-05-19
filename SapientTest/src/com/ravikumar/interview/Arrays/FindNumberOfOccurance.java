package com.ravikumar.interview.Arrays;

public class FindNumberOfOccurance {

	public static void main(String[] args) {
		int[] arr = {2,1,3,1,3,1,2};
		int result=0;
		for(int i=0;i<arr.length;i++){
			result = result ^ arr[i];
		}
		System.out.println(result);
	}

}
