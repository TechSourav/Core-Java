package com.sourav;

public class LongestSubarray {

	public static void main(String[] args) {
		int [] arr={5, 6, 3, 5, 7, 8, 9, 1, 2};
		//int [] temp=new int[arr.length];
		int max =1; int len=1;
		for(int i=0; i<arr.length-1;i++){
			if(arr[i]<arr[i+1]){
				len++;
			}else{
				if(max<len)
					max=len;
				len=1;
			}
		}
		System.out.println(max);
	}

}
