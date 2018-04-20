package com.ravikumar.interview.Arrays;

import java.util.HashSet;

public class FindSum {

	public static void main(String[] args) {
		int[] arr = {1, 5, 7, -1, 5, 6, 8};
		
		int temp = 0;
		int target = 6;
		HashSet<Integer> s = new HashSet<>();
		for(int i=0; i<arr.length;i++){
			temp= target- arr[i];
			if(temp > 0 && s.contains(temp)){
				System.out.println("pair: " + arr[i]+","+ temp);
			}else{
				s.add(arr[i]);
			}
		}
	}

}
