package com.sourav.java.Array;

public class TrappingRainWater {

	public static void main(String[] args) {
		int arr[] = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
		int x=findWater(arr);
		System.out.println(x);
	}
	
	private static int findWater(int[] arr){
		int water= 0;
		int[] left= new int[arr.length];
		int[] right= new int[arr.length];
		left[0]=arr[0];
		for(int i=1;i<arr.length;i++){
			left[i]= Math.max(left[i-1],arr[i]);
		}
		right[arr.length-1]=arr[arr.length-1];
		for(int i=arr.length-2;i>=0;i--){
			right[i]= Math.max(right[i+1],arr[i]);
		}
		for(int j=0;j<arr.length;j++){
			water+=Math.min(left[j], right[j])-arr[j];
		}
		return water;
	}

}
