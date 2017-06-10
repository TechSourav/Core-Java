package com.sourav;

public class SumOfRange {

	public static void main(String[] args) {
	
		int[] arr= {1,2,3,5,7,10,9};
		int totElements=7;
		int upperRange=5;
		int lowerRange=1;
		
		int sum=getSum(arr,upperRange, lowerRange);
		System.out.println(sum);

	}
	
	private static int getSum(int[] arr, int upperRange, int lowerRange){
		int sum=0;
		for(int i=lowerRange; i<=upperRange;i++){
			sum+=arr[i];
		}
		
		return sum;
	}

}
