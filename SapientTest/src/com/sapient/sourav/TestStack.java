package com.sapient.sourav;

public class TestStack {
	
 public static void main(String[] args){
      
	 Stack st =new Stack();
	 st.pop();
	 st.push('{');
	 st.push('}');
	 st.push('[');
	 st.push(']');
	 st.push(')');
	 st.push('(');
	 
	 st.printStack();
	 st.pop();
	 st.printStack();
	 
	}

}

class Stack{

	char[] items;
	int top ;
	int capacity=10;
	
	Stack(){
		top=-1;
		items=new char[capacity];
	}
	
	Stack(int capa){
		top=-1;
		this.items=new char[capa];
	}
	
	public void push(char data){
		if(isFull()){
			System.out.println("Stack is Full!!");
		}else{
	    top++;
	    items[top]=data;
		}
	}
	public int pop(){
		int x=0;
		if(isEmpty()){
			System.out.println("Stack is empty!!");
		}else{
			x = items[top];
			top--;
			
		}
		return x;
	}
	public char peek(){
		return items[top];
	}
	public boolean isFull(){
		if(top==items.length-1){
			return true;
		}else
			return false;
		
	}
	public boolean isEmpty(){
		if(top==-1){
			return true;
		}else
			return false;
		
	}
	void printStack(){
		System.out.println("Printing the stack:");
		
		for(int j =top; j>=0;j--){
			System.out.println(items[j]);
		}
	}
}





