package com.sourav.practice;

import java.util.List;
import java.util.Scanner;

public class PascalTriangle {
	
	public static void main(String[] args) {/*
		List<int[]> l = new ArrayList<>();
		for(int i=1;i<=5; i++) {
			int[] a = new int[i];
			if(i==1) {
				a[i-1]=1;
				//System.out.println(a[i-1]);
				l.add(a);
			}
			if(i==2) {
				a[i-2]=1;
				a[i-1]=1;
				//System.out.println(a[i-1] + " , " + a[i]);
				l.add(a);
			}
			if(i>2) {
				a[0]=1;
				a[i-1]=1;
				for(int k=1;k<=i-2;k++) {
					int[] b=l.get(i-2);
					a[k]=b[k-1]+b[k];
				}
				l.add(a);
			}
				
		}
		printList(l);
	*/
		
	
	// Method -2
		
		int r, i, k, number = 1, j;
		Scanner scan = new Scanner(System.in);

		System.out.print("Enter Number of Rows : " );
		r = scan.nextInt();

		for (i = 0; i < r; i++) {
			for (k = r; k > i; k--) {
				System.out.print(" ");
			}
			number = 1;
			for (j = 0; j <= i; j++) {
				System.out.print(number + " ");
				number = number * (i - j) / (j + 1);
			}
			System.out.println();
		}
		
	
	
	}
	private static void printList(List<int[]> l) {
		for(int[] a: l) {
			System.out.println("\n");
			for(int i:a) {
				System.out.print(i + " ");
			}
		}
	}

}
