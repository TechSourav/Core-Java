package com.morgan.interview;

import java.util.HashSet;
import java.util.Set;

public class Test7 {

	public static void main(String[] args){
		
		Customer c1= new Customer("Sourav", 12,"29");
		Customer c2= new Customer("Sourav", 12,"29");
		Customer c3= new Customer("Sourav", 12,"29");
		
		Set<Customer> st = new HashSet<Customer>();
		st.add(c1);
		st.add(c2);
		st.add(c3);
		
		System.out.println(c1.getClass().getClassLoader().getParent().getSystemClassLoader());
		
	}
	
}

class Customer {
	
	private String name;
	private int id;
	private String age;
	
	Customer(String s, int n, String a){
		this.name=s;
		this.id=n;
		this.age=a;
	}
	
}
