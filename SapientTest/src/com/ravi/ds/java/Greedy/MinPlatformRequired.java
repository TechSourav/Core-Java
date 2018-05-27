package com.ravi.ds.java.Greedy;

import java.util.Arrays;

public class MinPlatformRequired {

	public static void main(String[] args) {
		
		int arr[] = {900, 940, 950, 1100, 1500, 1800};
	    int dep[] = {910, 1200, 1120, 1130, 1900, 2000};
	    
	    System.out.println("Min platform required is : "+ findMinPlatform(arr,dep));

	}
	
	private static int findMinPlatform(int[] arr, int[] dep){
		Arrays.sort(arr);
		Arrays.sort(dep);
		int max = 1;
		int platform_needed=1;
		int n = arr.length;
		int i=1,j=0;
		while(i<n && j<n){
			if(arr[i]<dep[j]){
				platform_needed++;
				i++;
				if(max<platform_needed){
					max=platform_needed;
				}
			}else{
				platform_needed--;
				j++;
			}
		}
		return max;
	}

}
