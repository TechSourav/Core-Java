package org.sourav.Multithreading.practice;

import java.util.HashMap;

public class FirstNoRepeatingChar {

	public static void main(String[] args) {
		String str = "zzzzccccddddethhhkiiii";
		HashMap<Character,Integer> map = new HashMap<Character,Integer>();
		char c;
		
		for(int i=0;i<str.length();i++){
			c = str.charAt(i);
			if(map.containsKey(c)){
				map.put(c, map.get(c)+1);
			}else{
				map.put(c, 1);
			}
		}
		
		for(int i=0;i<str.length();i++){
			c=str.charAt(i);
			if(map.get(c)==1){
				System.out.println(c);
			}
			//return null;
		}
	}

}
