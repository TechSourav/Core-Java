package com.sourav.java.Thread;

import java.util.List;

public class TestCasting {
	
	static final int x;
	
	static{
		
		x=9;
		System.out.println(x);
	}
	
	public static void main(String[] args){
		//System.out.println(x);
		/*List<Object> obj;
		List<String> strLst;
		obj=strLst;*/
		
	Parent p = new Sourav();
	Child c = (Child)p;
		
		/*Set l = new HashSet();
		l.add(null);
		l.add(null);
		l.add(123);
		
		System.out.println(Arrays.asList(l));*/
	}

}

class Parent{
	
}
class Sourav extends Child{}

class Child extends Parent{
	
}
