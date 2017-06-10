package com.sourav;

import java.text.DateFormat;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(propOrder={"name","age","doj","salary"})
public class Employee {
	
	private int id;
	private String name;
	private int age;
	//private Address address;
	private double salary;
	private Date doj;
	
	
	public static final String
	ID="id",		
	EMP_NAME="name",
	EMP_AGE="age",
	EMP_SALARY="salary",
	EMP_DOJ="doj";
	
	public Employee(){
		
	}
	
	@XmlAttribute
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setId(Number id) {
		this.id = id.intValue();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setAge(Number age) {
		this.age = age.intValue();
	}
	/*public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}*/
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public void setSalary(Number salary) {
		this.salary = salary.doubleValue();
	}
	public Date getDoj() {
		return doj;
	}
	public void setDoj(Date doj) {
		this.doj = doj;
	}

	@Override
	public String toString(){
		DateFormat df = DateFormat.getDateInstance(DateFormat.LONG);
		return this.id+ ":" + this.getName() + ":" + this.getDoj();
				}
}
