package com.ravikumar.interview.LinkedList;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class  LRUCache2<K,V> {
	
	private  ConcurrentLinkedQueue<K> concurrentLinkedQueue = new ConcurrentLinkedQueue<K>();
	
	private  ConcurrentHashMap<K,V> concurrentHashMap = new ConcurrentHashMap<K, V>();
	
	private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
	
	private Lock readLock = readWriteLock.readLock();
	
	private Lock writeLock = readWriteLock.writeLock();
	
	int maxSize=0;
	
	public LRUCache2(final int MAX_SIZE){
		this.maxSize=MAX_SIZE;
	}
	
	public V getElement(K key){
		
		readLock.lock();
		try {
		V v=null;
		  if(concurrentHashMap.contains(key)){
			  concurrentLinkedQueue.remove(key);
			  v= concurrentHashMap.get(key);
				concurrentLinkedQueue.add(key);
		  }
		  
		
		return v;
		}finally{
			readLock.unlock();
		}
	}
	
	public V removeElement(K key){
		 writeLock.lock();
		 try {
		V v=null;
		if(concurrentHashMap.contains(key)){
		v=concurrentHashMap.remove(key);
			concurrentLinkedQueue.remove(key);
		}
		
		return v;
		 } finally {
			 writeLock.unlock();
		 }
	}
	
	public V addElement(K key,V value){
		writeLock.lock();
		try {
		if(concurrentHashMap.contains(key)){
			 concurrentLinkedQueue.remove(key);
		}
		while(concurrentLinkedQueue.size() >=maxSize){
			 K queueKey=concurrentLinkedQueue.poll();
			 concurrentHashMap.remove(queueKey);
		}
		concurrentLinkedQueue.add(key);
		concurrentHashMap.put(key, value);
		
		return value;
		} finally{
			writeLock.unlock();
		}
	}
}