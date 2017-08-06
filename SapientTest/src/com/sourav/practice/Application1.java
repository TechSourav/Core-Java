package com.sourav.practice;

public class Application1 {

	public static void main(String[] args) {
		Animal a1= new Animal();
		Animal a2= new Dog(); 
		Dog d= new Dog();
		
		a1.voice();
		a2.voice();
		d.voice();
	}

}

class Animal{
	public void voice(){
		System.out.println("Every Animal talks");
	}
	public void food(){
		System.out.println("Every Animal eats");
	}
}

class Dog extends Animal{
	public void voice(){
		System.out.println("Every Dog barks");
	}
	public void food(){
		System.out.println("Every Dog eats meat");
	}
}
