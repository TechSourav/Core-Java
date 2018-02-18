package com.sourav.JDK8;

public class MyFirstMethodRef {
	
	MyFirstMethodRef(){
		System.out.println("inside constructor");	
	}
	
	public static void m2() {
		System.out.println("Using Method reference");
	}

	public static void main(String[] args) {
		IInterf i =()-> System.out.println("Using lamda");
		i.m1();
		IInterf j = MyFirstMethodRef :: m2;
		j.m1();
		IInterf k = MyFirstMethodRef :: new;
		k.m1();
	}

}

@FunctionalInterface
interface IInterf{
	public void m1();
}
