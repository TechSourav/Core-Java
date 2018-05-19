package com.ravikumar.interview.Arrays;

public class FindMaxDifference {
	
	public static void main(String[] args){
		int[] arr = {4,3,10,2,9, 1,6};
		int i = getMaxDifference(arr);
		System.out.println(i);
	}
	
	private static int getMaxDifference(int[] arr){
		
		int min_so_far = arr[0];
		int max_diff_so_far = arr[1]- arr[0];
		int curr_diff= arr[1]- arr[0];
		for(int index = 1; index<arr.length;index++){
			if(arr[index]<min_so_far){
				min_so_far=arr[index];
			}else{
				curr_diff=arr[index]-min_so_far;
				if(curr_diff>max_diff_so_far){
					max_diff_so_far=curr_diff;
				}
			}
		}
		return max_diff_so_far;
	}

}
