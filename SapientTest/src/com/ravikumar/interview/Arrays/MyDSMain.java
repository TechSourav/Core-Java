package com.ravikumar.interview.Arrays;

public class MyDSMain {
	public static void main(String[] args) {
		MyDS ds = new MyDS();
		ds.add(10);
		ds.add(20);
		ds.add(30);
		ds.add(40);
		System.out.println(ds.search(30));
		ds.remove(20);
		ds.add(50);
		System.out.println(ds.search(50));
		System.out.println(ds.getRandom());
	}
}
