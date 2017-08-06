package com.ANZ.interview;

import java.util.concurrent.ConcurrentHashMap;

public class TestConcurrentHashMap {
	
    public static void main(String[] args){
    	
    	ConcurrentHashMap<Integer, String> chmp= new ConcurrentHashMap<>(10,0.75f,16);
    	
    	for(int i=0;i<16;i++){
    		chmp.put(i, "santosh");
    	}
    	
    }

}
