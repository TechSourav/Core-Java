package com.morgan.interview;

public class PrintStringReverse {

	public static void main(String[] args) {
		
		String str= "The Morgan Stanley Interview has been scheduled.";
		
		String[] st= str.split(" ");
		for(int i=st.length-1;i>=0;i--){
			System.out.print(st[i] + " ");
		}

	}

}
