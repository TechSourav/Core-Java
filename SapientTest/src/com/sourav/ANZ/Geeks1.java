package com.sourav.ANZ;

import java.util.Scanner;

public class Geeks1 {

	public static void main(String[] args){
	
		Scanner sc =  new Scanner(System.in);
		int tc=sc.nextInt();
		String[] arr={};
		for(int i=0;i<tc;i++){
			arr[i]=sc.next();
		}
		for(String input: arr){
			calculateOutput(input);	
		}
		
	}	
	private static void calculateOutput(String arr){
		String[] str=arr.split(" ");
		int limit=Integer.valueOf(str[1]);
		int totalUnit=Integer.valueOf(str[0]);
		if(limit!=0){
			--limit;
			totalUnit=totalUnit/2;
			calculateOutput(arr);
		}
	}
}
