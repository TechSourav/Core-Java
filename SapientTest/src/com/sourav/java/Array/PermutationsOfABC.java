package com.sourav.java.Array;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PermutationsOfABC {
	static int count=2;
public static void main(String[] args) {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter Number of Socks");
    int x= sc.nextInt();
    //List<Integer> socks = new ArrayList<Integer>();
    Map<Integer,Integer> pair= new HashMap<Integer,Integer>();
    int[] arr=new int[x];
    for(int i=0;i<x;i++){
        //socks.add(sc.nextInt());
        arr[i]=sc.nextInt();
        if(pair.containsKey(arr[i])){
            pair.put(arr[i],pair.get(arr[i])+1);
           // count++;
        }else{
            pair.put(arr[i],1);
        }
    }
    
    for(Map.Entry<Integer, Integer> map: pair.entrySet()){
    	
    	if(map.getValue()>=2)
    	  count += map.getValue();
    	
		/*if(map.getValue()>=2){
            count++;
        }
		if(map.getValue()>=4){
			count++;
        }
		if(map.getValue()>=6){
			count++;
        }
		if(map.getValue()>=8){
			count++;
        }*/
	}
    System.out.println("Number of pairs are: " + (count/2));
}}
