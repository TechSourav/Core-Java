package com.sourav.java.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TestComparator {

	public static void main(String[] args) {
		Employee e1 = new Employee(123,"Sourav",36);
		Employee e2 = new Employee(124,"Santosh",32);
		Employee e3 = new Employee(125,"Somnath",34);
		
		List<Employee> e = new ArrayList<>();
		e.add(e1);
		e.add(e3);
		e.add(e2);
		System.out.println("Before sort : "+Arrays.asList(e));
		
		Comparator<Employee> ageComparator = Comparator.comparing(Employee::getName);
		Collections.sort(e,ageComparator);
		System.out.println("\n Age Sort"+Arrays.asList(e));
		Comparator<Employee> idComparator = Comparator.comparing(Employee::getId);
		Collections.sort(e,idComparator);
		System.out.println("\n Id sort: "+Arrays.asList(e));
		
		/*Collections.sort(e);
		System.out.println("After sort: "+Arrays.asList(e));
		Collections.sort(e, new EmployeeIDComparator());
		System.out.println("\n Id sort: "+Arrays.asList(e));
		Collections.sort(e, new EmployeeAgeComparator());
		System.out.println("\n Age Sort"+Arrays.asList(e));*/
	}

}

class EmployeeIDComparator implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		
		return o1.getId()-o2.getId();
	}
	
}

class EmployeeAgeComparator implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		
		return o1.getAge()-o2.getAge();
	}
	
}

class Employee /*implements Comparable<Employee>*/{
	private int id;
	private String name;
	private int age;
	Employee(int i, String n, int a){
		this.id=i;
		this.name=n;
		this.age=a;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	@Override
	public String toString(){
		return "Employee Name: " + this.name + " Employee Id: " + this.id + " Employee Age: " + this.age ;
		
	}
	/*@Override
	public int compareTo(Employee o) {
		return -(this.id -o.id);
	}*/
}
