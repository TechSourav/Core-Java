package com.ravikumar.interview.Arrays;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class PrintPrimeNumber {

	public static void main(String[] args) {
		int[] a = { -4 ,3, -9, 0, 4, 1 };
		int x = printPrimeNumbers(a, 4);
		System.out.println(x);

	}

	private static int printPrimeNumbers(int[] arr, int xc) {
		DecimalFormat df = new DecimalFormat("#.######");
        df.setRoundingMode(RoundingMode.CEILING);
		double cp=0,cn=0,cz=0;
	    for(int i=0;i<arr.length;i++){
	        if(arr[i]==0)
	            cz++;
	        if(arr[i]>0)
	            cp++;
	        if(arr[i]<0)
	            cn++;
	    } 
	        
	        df.format((cp/arr.length));
	        double n =(cn/arr.length);
	        double z=(cz/arr.length);
	        
	        System.out.println(df.format((cp/arr.length)));
	        System.out.println(df.format((cn/arr.length)));
	        System.out.println(df.format((cz/arr.length)));
	        return 21;
	}

}
