package com.sourav.java.Array;

import java.util.HashMap;
import java.util.Map;

public class ProgramforMemoryLeak {

	static class Key{
		
		Integer id;
		
		Key(Integer i){
			this.id=i;
		}
		
		@Override
		public int hashCode(){
			return id.hashCode();
		}
		@Override
		public boolean equals(Object o){
			if(o instanceof Key){
				if(((Key)o).id.equals(this.id))
					return true;
				else 
					return false;
			}
			return false;
		}
	}
	
	public static void main(String[] args) {
		String str="Sourav";
		String s=new String("Sourav");
		String s1=s.intern();
		System.out.println(s1==s);
		System.out.println(s1);
		System.out.println(s==str);
		Map m = new HashMap();
		while(true){
			for(int i=0;i<20;i++){
				if(!m.containsKey(new Key(i))){
					m.put(new Key(i), i);
				}
			}
		}

	}

}
