package com.sapient.sourav;

import java.io.Serializable;

/**
 * 1. Multithreaded.
   2. Lazy loading.
   3. Support serialization and cloning.
   4. Not access through Reflection API.
   5. Should support all version of JAVA
 * 
 * **/

public class Singleton implements Cloneable, Serializable{
	
	// Lazy Initialization
	
	/*private static Singleton instance;
	
	private Singleton(){
		
		if(instance!=null){
			throw new IllegalStateException("Only one instance may be created.");
		}
		System.out.println("Object may be created..");
		
	}
	
	public static Singleton getInstance(){
		if(instance==null){
			synchronized(Singleton.class){
				if(instance==null){
					instance= new Singleton();
				}
			}
		}
		return instance;
	}
	
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}*/
	

	// Early initialization
	
	private static final Singleton instance = new Singleton();
	
	private Singleton(){
		if(instance!=null){
			throw new IllegalStateException("Instance Already created");
		}
		System.out.println("Singleton instacne is being created.");
	}
	
	public static final Singleton getInstance(){
		return instance;
	}
	// immediately after deserialization this will get called..
	protected Object readResolve(){
		return instance;
	}
}

