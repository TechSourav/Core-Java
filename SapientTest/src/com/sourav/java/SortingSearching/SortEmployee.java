package com.sourav.java.SortingSearching;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

class Person {
	private int id;
	public String name;
	public Date dob;
	
	Person(int i,String n, Date dob){
		this.id=i;
		this.name=n;
		this.dob=dob;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Date getDob() {
		return dob;
	}

}

class EmployeeComparator implements Comparator<Person>{

	@Override
	public int compare(Person o1, Person o2) {
		// TODO Auto-generated method stub
		return o1.getId()-o2.getId();
	}
	
}

public class SortEmployee {

	public static void main(String[] args) {
           Person p1 = new Person(1,"Sourav",new Date(2011,12,12));
           Person p2 = new Person(5,"Aman",new Date("13-Mar-2017"));
           Person p3 = new Person(9,"Santosh",new Date("14-Mar-2017"));
           Person p4 = new Person(4,"Koka",new Date("15-Mar-2017"));
           Person p5 = new Person(3,"Kundu",new Date("16-Mar-2017"));
           List<Person> pList = new ArrayList<>();
           pList.add(p1);
           pList.add(p2);
           pList.add(p3);
           pList.add(p4);
           pList.add(p5);
           System.out.println("Before sort");
           for(Person p: pList){
        	   System.out.println(p.getName());
           }
           Collections.sort(pList, new Comparator<Person>(){
        	   public int compare(Person o1, Person o2) {
        			// TODO Auto-generated method stub
        			return o2.getId()-o1.getId();
        		} 
           });
           System.out.println("After sort");
           for(Person p: pList){
        	   System.out.println(p.getName());
           }
	}

}
