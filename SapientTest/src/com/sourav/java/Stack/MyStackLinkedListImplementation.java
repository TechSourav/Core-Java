package com.sourav.java.Stack;

public class MyStackLinkedListImplementation {

	public static void main(String[] args) throws Exception {
		LinkedStack st =  new LinkedStack();
		st.push(2);
		st.push(3);
		st.push(4);
		st.push(5);
		System.out.println(st.toString());
		st.pop();
		System.out.println(st.toString());
	}

}

class LinkedStack{
	
	Node top=null;
	int length=0;
	
	public void push(int data) {
		Node nd = new Node(data);
		if(top!=null) {
			nd.next=top;
			top=nd;
			length++;
		}else {
			top=nd;
			length++;
		}
	}
	
	public int pop() throws Exception{
		int val=0;
		if(isEmpty()) {
			throw new Exception("Stack is empty");
		}else {
			val= top.data;
			top=top.next;
			length--;
		}
		return val;
	}
	
	public boolean isEmpty() {
		return (top==null);
	}
	
	public int size() {
		return length;
	}
	
	public String toString() {
		String s ="[";
		Node temp=top;
		if(size()>0) {
			for(int i=0;i<length;i++) {
				s+=" "+temp.data;
				temp=temp.next;
			}
		}
		return s+"]";
	}
	
}

class Node{
	int data;
	Node next;
	Node(int data){
		this.data=data;
		this.next=null;
	}
}
