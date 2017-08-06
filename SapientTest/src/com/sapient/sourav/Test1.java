package com.sapient.sourav;

public class Test1 {
	
	public static void main(String[] args){
		Employee e1= new Employee("S");
		Employee e2= new Employee("K");
		Department dpt = new Department("EcE");
		System.out.println(e1.equals(e2));
		System.out.println(e1.equals(dpt));
	}

}
class Employee {
private String name;	
	Employee(String n){
		this.name=n;
	}
}

class Department{
	private String name;	
	Department(String n){
		this.name=n;
	}	
}
