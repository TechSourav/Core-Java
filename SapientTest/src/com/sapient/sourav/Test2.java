package com.sapient.sourav;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class Test2 {

	public static void main(String[] args){
		/*List<Integer> lst = new LinkedList<Integer>();
		lst.add(1);
		lst.add(1);
		lst.add(4);
		lst.add(3);
		lst.add(9);
		System.out.println(Arrays.asList(lst));*/
		Customer c1= new Customer("Sourav",29,"122925");
		Customer c2= new Customer("Ashish",29,"122925");
		Customer c3= new Customer("Vubrata",29,"122925");
		//Set<Customer> st = new HashSet<Customer>();
		/*Set<Customer> st = new TreeSet<Customer>(new Comparator<Customer>(){
			public int compare(Customer c1, Customer c2){
				return c1.name.compareTo(c2.name);
			}
		});*/
		Set<Customer> st = new LinkedHashSet<Customer>();
		st.add(c1);
		st.add(c2);
		st.add(c3);
		Iterator it=st.iterator();
		while(it.hasNext()){
			Customer c= (Customer)it.next();
			System.out.println(c.getName());
		}
	}
}

class Customer{
	public String name;
	private int age;
	private String code;
	
	Customer(){
		System.out.println("Inside Default constructor..");
	}
	
	Customer(String n,int a, String c){
		this.name=n;
		this.age=a;
		this.code=c;
	}
	
	@Override
	public int hashCode(){
	
		return this.name.hashCode();
	}
	
	@Override
	public boolean equals(Object o){
		Customer c= (Customer)o;
		if(this.hashCode()==c.hashCode()){
			if(this.name.equals(c.name))
			     return true;
			 else 
				 return false;
		}
		return false;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getCode() {
		return code;
	}
}