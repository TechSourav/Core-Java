package com.sourav.custom.DS;

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
