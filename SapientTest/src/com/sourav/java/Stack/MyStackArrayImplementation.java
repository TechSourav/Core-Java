package com.sourav.java.Stack;

public class MyStackArrayImplementation {
	
	public static void main(String[] args) throws Exception{
		CustomStack cs = new CustomStack(5);
		cs.push(5);
		cs.push(4);
		cs.push(3);
		cs.push(2);
		cs.push(1);
		System.out.println(cs.toString());
		System.out.println(cs.pop());
		System.out.println(cs.pop());
		System.out.println(cs.toString());
		cs.push(6);
		cs.push(7);
		System.out.println(cs.toString());
	}
}

class CustomStack{
	public static final int MAX=10;
	protected int capacity;
	int top=-1;
	int[] arr;
	
	CustomStack() {
		this(MAX);
	}
	
	CustomStack(int capa){
		this.capacity=capa;
		arr= new int[capacity];
	}
	
	public int size() {
		return top+1;
	}
	
	public boolean push(int n) throws Exception{
		if(size()==MAX){
			System.out.println("Stack Overflow");
			throw new Exception("Stack is full");
		}else{
			arr[++top]=n;
			return true;
		}
	}
	
	public int pop() throws Exception{
		if(isEmpty()){
			System.out.println("Stack Empty!!");
			throw new Exception("Stack is empty.");
		}else{
			int data =arr[top];
			arr[top--]=Integer.MIN_VALUE;
			return data;
		}
	}
	
	public int peek() throws Exception{
		if(isEmpty()){
			System.out.println("Stack Empty!!");
			throw new Exception("Stack is empty.");
		}else{
			return arr[top];
		}
	}
	
	public boolean isEmpty(){
		return (top<0);
	}
	
	public String toString() {
		String s="[";
		if(size()>0) {
			for(int i=0;i<arr.length;i++) {
				s+=","+arr[i];
			}
		}
		return s+"]";
	}
	
}
