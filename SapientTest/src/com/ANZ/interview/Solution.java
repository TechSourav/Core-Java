package com.ANZ.interview;

import java.util.Scanner;

public class Solution {

    public static int[] arrayLeftRotation(int[] a, int n, int k) {
    	int[] arr=a;
        while(k>0){
        int firstElement = arr[0];
        int prev;
            for(int i=0;i<n-1;i++){
             arr[i]=arr[i+1];
            }
            arr[n-1]=firstElement;
            k--;
        }
        a=arr;
      return a;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
      
        int[] output = new int[n];
        output = arrayLeftRotation(a, n, k);
        for(int i = 0; i < n; i++)
            System.out.print(output[i] + " ");
      
        System.out.println();
      
    }
}