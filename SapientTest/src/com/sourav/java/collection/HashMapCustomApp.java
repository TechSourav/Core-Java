package com.sourav.java.collection;

class HashMapCustomApp<K,V> {
	
	private int capacity=4;
	private Entry<K,V>[] table;
	
	static class Entry<K,V>{
		 K key;
		 V value;
		 Entry<K,V> next;
		 
		 Entry(K key,V value, Entry<K,V> next){
			 this.key=key;
			 this.value=value;
			 this.next=next;
		 }
	}

	@SuppressWarnings("unchecked")
	HashMapCustomApp(){
		table= new Entry[capacity];
	}
	
	private int hash(K key){
		return Math.abs(key.hashCode())%capacity;
	}
	
	public void put(K newKey, V newValue){
		if(newKey==null){
			return;
		}
		// creates a new Entry
		Entry<K,V> newEntry = new Entry<K,V>(newKey,newValue,null); 
		// calculates hashvalue
		int index= hash(newKey);
		
		if(table[index]==null){
			table[index]= newEntry;
		}else{
			Entry<K,V> previous =null;
			Entry<K,V> current = table[index];
			while(current!=null){
				if(current.key.equals(newKey)){
					// Override with new value
					if(previous==null){
						newEntry.next=current.next;
						table[index]=newEntry;
	                    return;
					}else{
		                   newEntry.next=current.next;
		                   previous.next=newEntry;
		                   return;
		            }
				}
				
				previous = current;
				current=current.next;
				
			}
			previous.next=newEntry;
			
		}
		
		
		
	}
	
}
