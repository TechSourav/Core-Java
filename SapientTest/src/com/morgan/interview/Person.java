package com.morgan.interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Person {

	private int priority;
	private String objName;

	Person(String name, int value) {
		this.objName = name;
		this.priority = value;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public String getObjName() {
		return objName;
	}

	public void setObjName(String objName) {
		this.objName = objName;
	}

	public static void main(String[] args) {

		Person M1 = new Person("M1", 1);
		Person M2 = new Person("M2", 1);
		Person M3 = new Person("M3", 1);
		Person M4 = new Person("M4", 1);
		Person M5 = new Person("M5", 1);
		Person W1 = new Person("W1", 1);
		Person W2 = new Person("W2", 1);
		Person W3 = new Person("W3", 1);
		Person W4 = new Person("W4", 1);
		Person C1 = new Person("C1", 1);
		Person C2 = new Person("C2", 1);

		Person[] arr = { M1, M3, C1, W1, W3, M2, M4, W2, C2, W4, M5 };

		rearrange(arr, Priority.ONE, Priority.TWO, Priority.THREE);

	}

	public static void rearrange(Person[] arr, Priority p1, Priority p2,
			Priority p3) {

		List<Person> list = new ArrayList<Person>();

		for (int i = 0; i < arr.length; i++) {
			if (arr[i].getObjName().equals("M1")
					|| arr[i].getObjName().equals("M2")
					|| arr[i].getObjName().equals("M3")
					|| arr[i].getObjName().equals("M4")
					|| arr[i].getObjName().equals("M5")) {
				arr[i].setPriority(p1.getValue());
			} else if (arr[i].getObjName().equals("W1")
					|| arr[i].getObjName().equals("W2")
					|| arr[i].getObjName().equals("W3")
					|| arr[i].getObjName().equals("W4")) {
				arr[i].setPriority(p2.getValue());
			} else if (arr[i].getObjName().equals("C1")
					|| arr[i].getObjName().equals("C2")) {
				arr[i].setPriority(p3.getValue());
			}
			list.add(arr[i]);
		}

		System.out.println("Before sort...");
		for (Person p : list) {
			System.out.print(p.getObjName() + " ");
		}

		Collections.sort(list, new PersonComparator<Person>());
		System.out.println();
		System.out.println("After sort...");
		for (Person p : list) {
			System.out.print(p.getObjName() + " ");
		}

	}

}

enum Priority {
	ONE(1), TWO(2), THREE(3);

	private int value;

	public int getValue() {
		return value;
	}

	Priority(int v) {
		this.value = v;
	}
}

class PersonComparator<T> implements Comparator<Person> {
	public int compare(Person p1, Person p2) {
		// Sorting based on priority
		int v1 = p1.getPriority();
		int v2 = p2.getPriority();
		;
		if (v1 - v2 == 0) {
			// Sorting based on object name
			int i1 = Integer.parseInt(p1.getObjName().substring(1, 2));
			int i2 = Integer.parseInt(p2.getObjName().substring(1, 2));
			return i1 - i2;
		}
		return v1 - v2;
	}
}
