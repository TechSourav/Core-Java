package com.sourav;

import java.math.BigDecimal;
import java.util.Scanner;

public class ArrayFrequency {

	public static void main(String[] args) {
		int[] arr= {1,3,2,4,1,4,4,4,5,7,9,3};
		findFrequency(arr);
		for(int i:arr){
			System.out.print(i+",");
		}

	}
	
	/*static long aVeryBigSum(int n, long[] ar) {
       BigDecimal num= new BigDecimal(0);
		for(int i=0;i<n;i++){
    	   num.add ar[i];
       }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long[] ar = new long[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextLong();
        }
        long result = aVeryBigSum(n, ar);
        System.out.println(result);
    }*/
	
	
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
