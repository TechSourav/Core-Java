	package com.ANZ.interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CompareEmployee {

	public static void main(String[] args) {
		Employee e1 = new Employee(1, "Sourav",123456);
		Employee e2 = new Employee(2, "Santosh",13456);
		Employee e3 = new Employee(3, "Aman",1345);
		Employee e4 = new Employee(4, "Somanth",134);
		Employee e5 = new Employee(5, "Thulasi",13);
		List<Employee> list = new ArrayList<Employee>();
		list.add(e1);
		list.add(e2);
		list.add(e3);
		list.add(e4);
		list.add(e5);
		System.out.println("Before sort \n");
		printList(list);
		Collections.sort(list, new EmployeeSalaryComparator());
		System.out.println("\n After sort \n");
		printList(list);
	}
	
	private static void printList(List<Employee> empList){
		for(Employee e: empList){
			System.out.println("\n"+ e.getId() + ","+ e.getName()+ "," + e.getSalary());
		}
	}

}

class Employee{
	
	private int id;
	private String name;
	private int salary;
	
	Employee(int id, String n, int sal){
		this.id=id;
		this.name=n;
		this.salary=sal;
	}
	
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
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
}


class EmployeeSalaryComparator implements Comparator<Employee>{

	@Override
	public int compare(Employee e1, Employee e2) {
		return e1.getSalary()-e2.getSalary();
	}
	
}

