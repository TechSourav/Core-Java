package com.sourav.java.Array;

import java.util.ArrayList;

public class FindCombinaiton {

	public static void main(String[] args) {
		ArrayList<String> outputList =   findCombinations("abc");
		System.out.println(outputList);

	}
	public static ArrayList<String>   findCombinations(String inut){
		ArrayList<String> combinations = new ArrayList<>();
		if(inut.length()<=0) return null;
		if(inut.length()==1) {
			combinations.add(inut);
			return combinations;
		}
		
		for(int i =0;i<inut.length();i++){
			char ch  = inut.charAt(i);
			String firstPart =  inut.substring(0,i) ;  
			String secondPart = inut.substring(i+1);
			//System.out.println("i="+i+" firstPart="+firstPart + " secondPart="+secondPart);
			ArrayList<String> tempList= findCombinations(firstPart+secondPart);
			for(String s:tempList){
				combinations.add(ch+s);
			}
		}
		return combinations;
	}
}