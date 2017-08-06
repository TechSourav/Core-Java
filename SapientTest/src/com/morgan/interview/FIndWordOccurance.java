package com.morgan.interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class FIndWordOccurance {
     int maxSize=3;
	public static HashMap<String,Integer> getCount(String str){
		
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		
		StringTokenizer stk = new StringTokenizer(str," ");
		while(stk.hasMoreTokens()){
			String token=stk.nextToken();
			System.out.print(token+ " ");
			if(map.containsKey(token)){
				map.put(token, map.get(token)+1);
			}else{
				map.put(token, 1);
			}
		}
		return map;
	}
	
	public static void main(String[] args){
		
		String str1 = "Hi Sourav How are you How is your wife are you working in sapient you are a very generous person";
		Set<Entry<String,Integer>> wordMap= getCount(str1).entrySet(); 
		for(Map.Entry<String, Integer> m: wordMap){
			System.out.println(m.getKey() + " : "+ m.getValue());
		}
		
        List<Entry<String,Integer>> lst= new ArrayList<Entry<String,Integer>>(wordMap);
		Collections.sort(lst,new Comparator<Map.Entry<String,Integer>>(){
			public int compare(Map.Entry<String,Integer> o1,Map.Entry<String,Integer>o2){
				return (o2.getValue().compareTo(o1.getValue()));
			}
		});
		System.out.println("========================= AFTER  SORT =================================");
		for(Map.Entry<String, Integer> m: lst){
			System.out.println(m.getKey() + " : "+ m.getValue());
		}	
			
		
		
	
	}
	
	

}
