package org.sourav.Multithreading.practice;

import java.util.LinkedHashMap;
import java.util.Map;

public class MyLRUCacheImplementation extends LinkedHashMap<Integer,String>{
	
	
	private static final long serialVersionUID= 1L; 
	private int capacity;
	
	MyLRUCacheImplementation(int capa, float loadfactor){
		super(capa,loadfactor,true);
		this.capacity=capa;
	}
	
	@Override
	protected boolean removeEldestEntry(Map.Entry<Integer, String> eldest){
		return size()>this.capacity;
	}
	
	public static void main(String[] args){
		
		MyLRUCacheImplementation lruCacheImpl= new MyLRUCacheImplementation(3,4.0f);
		
		lruCacheImpl.put(1,"Object1");
		lruCacheImpl.put(3,"Object3");
		lruCacheImpl.put(2,"Object2");
		System.out.println(lruCacheImpl);
		lruCacheImpl.put(4,"Object4");
		lruCacheImpl.get(2);
		lruCacheImpl.put(5,"Object5");
		System.out.println(lruCacheImpl);
		lruCacheImpl.get(4);
		lruCacheImpl.put(6,"Object6");
		System.out.println(lruCacheImpl);
		
		
		
	}

}






