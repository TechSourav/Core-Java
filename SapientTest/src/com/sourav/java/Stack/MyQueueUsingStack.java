package com.sourav.java.Stack;

public class MyQueueUsingStack {

	public static void main(String[] args) {
		QueueUsingStack queue = new QueueUsingStack();
		queue.enQueue(10);
		queue.enQueue(30);
		queue.enQueue(40);
		queue.enQueue(50);
		System.out.println("..... Before Removal .....");
		queue.display1();
		int item=queue.deQueue();
		System.out.println("..... After Removal ....."+ item + " has been removed.");
		queue.display2();
	}

}

class QueueUsingStack extends StackUsingList{
	
	StackUsingList stack1 = new StackUsingList();
	StackUsingList stack2 = new StackUsingList();
	int size;

	  public void enQueue(int val){
		stack1.push(val);  
		size++;
	  }
	  public int deQueue(){
		  if(stack2.isEmpty() && !stack1.isEmpty()){
			  for(int i=0;i<size;i++){
				  stack2.push(stack1.pop());
			  }
		  }
		  int data=stack2.pop();
		  return data;
	  }
	  public void display1(){
		  stack1.display();
	  }
	  public void display2(){
		  stack2.display();
	  }

}


class StackNode{
	int data;
	StackNode link;
	
	StackNode(int val){
		this.data=val;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public StackNode getLink() {
		return link;
	}
	public void setLink(StackNode link) {
		this.link = link;
	}
	
}

class StackUsingList{
	StackNode top;
	int size;
	public void push(int val){
		StackNode newNode= new StackNode(val);
		if(top==null){
			top=newNode;
		}else{
			newNode.setLink(top);
			top=newNode;
		}
		size++;
		
	}
	
	public int pop(){
		StackNode ptr = top;
		top=ptr.getLink();
		size--;
		return ptr.getData();
	}
	
	public int peek(){
		return top.getData();
	}
	public boolean isEmpty(){
		if(top==null){
			return true;
		}else
			return false;
	}
	
	public void display(){
	 System.out.println("Stack Elements: ");
	 StackNode nd=top;	
	 while(nd!=null){
			System.out.println(nd.data);
			nd=nd.getLink();
		}
		
	}
	
}