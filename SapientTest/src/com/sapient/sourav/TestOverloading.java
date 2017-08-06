package com.sapient.sourav;

public class TestOverloading {
	
	public static void main(String[] args){
		State st1 = new State();
		st1.adminstration();
		st1.m(10);
		st1.m('a');
		//st1.m(10.5); // The method m(int) in the type State is not applicable for the arguments (double)
		st1.m(10l);
		st1.m(10f);
		st1.m1("SOu");
		st1.m1(new StringBuffer("Kund"));
		//st1.m1(null);// The method m1(StringBuffer) is ambiguous for the type State
		//st1.m1(10, 10);
		st1.m1(10, 10.5f);
		st1.m1(10.5f, 10);
		//st1.m1(10.5f, 10.5f);
	
	}

}

class State{
	
	public void adminstration(){
		System.out.println("I am from State Ministry");
	}
	
	public void police(){
		System.out.println("I am from State Police");
	}
	
	public void m(int i){
		System.out.println("I am from int m");
	}
	public void m(float i){
		System.out.println("I am from float m");
	}
	public void m1(StringBuffer i){
		System.out.println("I am from StringBuffer m");
	}
	public void m1(String i){
		System.out.println("I am from String m");
	}
	
	public void m1(int i, float f){
		System.out.println("I am from int-float m");
	}
	public void m1(float i, int f){
		System.out.println("I am from float-int m");
	}
}

/*class City extends State{
  
	public void adminstration(){
		System.out.println("I am from City Ministry");
	}
	
	public void police(){
		System.out.println("I am from City Police");
	}
	
	
	
}*/


