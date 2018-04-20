package com.ravikumar.interview.Arrays;

import java.util.HashMap;

public class CountPairs {

	public static void main(String[] args) {
		int[] arr = {1, 5, 7, -1, 5, 6, 8};
		int target = 6;
		System.out.println("No of pairs: " + countPairs(arr, target));

	}
	
	private static int countPairs(int[] a, int x){
		int t =0;
		HashMap<Integer,Integer> m = new HashMap<>();
		for(int i=0;i<a.length;i++){
			t= x-a[i];
			if(m.containsKey(t)){
				
			}
		}
		return x;
		
	}

}
