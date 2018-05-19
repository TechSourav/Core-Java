package com.ravikumar.interview.Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class FindMaxNumber {

	public static void main(String[] args) {
		int [] arr1 = {9,29};
		
		ArrayList<String> arr  = new ArrayList<>();
		for(int a:arr1){
			arr.add(String.valueOf(a));
		}
		printLargest(arr);
	}
	
	private static void printLargest(List<String> arr){
		Collections.sort(arr, new Comparator<String>(){
			@Override
	        public int compare(String X, String Y){
				String XY= X+Y;
				String YX = Y+X;
				return XY.compareTo(YX)>0?-1:1;
			}
		});
		Iterator it = arr.iterator();
		 
	    while(it.hasNext())
	        System.out.print(it.next());
	}

}
