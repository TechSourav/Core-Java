package com.sourav.custom.DS;

import java.util.Scanner;

public class MyStackUsingList {

	public static void main(String[] args) {
		
	        Scanner scan = new Scanner(System.in);   
	        /* Creating object of class linkedStack */   
	        StackUsingList ls = new StackUsingList();          
	        /* Perform Stack Operations */  
	        System.out.println("Linked Stack Test\n");  
	        char ch;     
	        do 
	        {
	            System.out.println("\nLinked Stack Operations");
	            System.out.println("1. push");
	            System.out.println("2. pop");
	            System.out.println("3. peek");
	            //System.out.println("4. check empty");
	            //System.out.println("5. size");            
	            int choice = scan.nextInt();
	            switch (choice) 
	            {
	            case 1 :
	                System.out.println("Enter integer element to push");
	                ls.push( scan.nextInt() ); 
	                break;                         
	            case 2 : 
	                try
	                {
	                    System.out.println("Popped Element = "+ ls.pop());
	                }
	                catch (Exception e)
	                {
	                    System.out.println("Error : " + e.getMessage());
	                }    
	                break;                         
	            case 3 : 
	                try
	                {
	                    System.out.println("Peek Element = "+ ls.peek());
	                }
	                catch (Exception e)
	                {
	                    System.out.println("Error : " + e.getMessage());
	                }
	                break;                         
	            /*case 4 : 
	                System.out.println("Empty status = "+ ls.isEmpty());
	                break;                
	            case 5 : 
	                System.out.println("Size = "+ ls.getSize()); 
	                break; */               
	            case 6 : 
	                System.out.println("Stack = "); 
	                ls.display();
	                break;                        
	            default : 
	                System.out.println("Wrong Entry \n ");
	                break;
	            }           
	            /* display stack */    
	            ls.display();            
	            System.out.println("\nDo you want to continue (Type y or n) \n");
	            ch = scan.next().charAt(0);       
	 
	        } while (ch == 'Y'|| ch == 'y');                 
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


