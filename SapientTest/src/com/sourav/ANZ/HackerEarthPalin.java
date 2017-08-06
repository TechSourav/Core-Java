package com.sourav.ANZ;

import java.util.Scanner;

public class HackerEarthPalin {

	public static void main(String[] args) {
		
	Scanner s = new Scanner(System.in);
    char[] arr = new String(s.nextLine()).toCharArray();
	int len=  arr.length;
	int count=0;
    for (int i = 0; i < len; i++) {
        if(arr[i]!=arr[len-1]){
          count++;
          break;
        }
        else if(arr[i]==arr[len-1]){
        	len--;
        }  
    }
    if(count>0)
       System.out.println("NO");
    else
       System.out.println("YES");}

}
