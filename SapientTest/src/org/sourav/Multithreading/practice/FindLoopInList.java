package org.sourav.Multithreading.practice;

import java.util.LinkedList;

public class FindLoopInList {
	
	public static void main(String[] args){
		
		FindLoopInList list = new FindLoopInList();
        list.head = new NodeLoop(50);
        list.head.next = new NodeLoop(20);
        list.head.next.next = new NodeLoop(15);
        list.head.next.next.next = new NodeLoop(4);
        list.head.next.next.next.next = new NodeLoop(10);
 
        // Creating a loop for testing 
        head.next.next.next.next.next = head.next.next;
        //list.printList(head);
        list.detectAndRemoveLoop(head);
        System.out.println("Linked List after removing loop : ");
        list.printList(head);
		
	}

	static NodeLoop head;
	
	static class NodeLoop{
		
		int data;
		NodeLoop next;
		NodeLoop(int data){
			this.data=data;
			this.next=null;
		}
		
	}


	public void detectAndRemoveLoop(NodeLoop node){
		NodeLoop slow=node;
		NodeLoop fast=node.next;
		
		while(fast!=null && fast.next!=null){
			if(slow==fast){
				break;
			}
			slow=slow.next;
			fast=fast.next.next;
		}
		
		/*If loop exists*/
		if(slow==fast){
			slow=node;
			while(slow!=fast.next){
				slow=slow.next;	
				fast=fast.next;
			}
			fast.next=null; // removing the looping point;
		}
		
	}
	// Function to print the linked list
    void printList(NodeLoop node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }


}


