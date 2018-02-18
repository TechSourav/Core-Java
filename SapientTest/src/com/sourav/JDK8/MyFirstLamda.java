package com.sourav.JDK8;

public class MyFirstLamda {
	
	/*public void m2() {
		ITrade it= (x)->{
			System.out.println(x.getName());
		};
		
	}*/
	
	public static void main(String[] args) {
		MyFirstLamda t2= new MyFirstLamda();
		Person p1 = new Person();
		p1.setName("Sourav");
		ITrade it= (x)->{
			System.out.println(x.getName());
		};
		it.m1(p1);
	}

}


interface ITrade
{

	public void m1(Person p); 
	
	
}

class Person {
	private int id;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
