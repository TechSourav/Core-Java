package com.ravikumar.interview.LinkedList;

import com.sun.istack.internal.logging.Logger;

public class FindMiddleElementOfLL {
	
	static Logger log = Logger.getLogger(FindMiddleElementOfLL.class);
	
	public static void main(String[] args) {
		MyLinkedList mll= new MyLinkedList();
		ListNode root = ListNode.newNode(10);
		root=mll.addNodeAtEnd(root, 12);
		root=mll.addNodeAtEnd(root, 14);
		root=mll.addNodeAtEnd(root, 16);
		root=mll.addNodeAtEnd(root, 18);
		root=mll.addNodeAtEnd(root, 20);
		root=mll.addNodeAtEnd(root, 21);
		root=mll.addNodeAtEnd(root, 22);
		root=mll.addNodeAtEnd(root, 24);
		root=mll.addNodeAtEnd(root, 26);
		root=mll.addNodeAtEnd(root, 28);
		root=mll.addNodeAtEnd(root, 30);
		root=mll.addNodeAtEnd(root, 32);
		root=mll.addNodeAtEnd(root, 34);
		root=mll.addNodeAtEnd(root, 36);
		int i=findMiddleUsingTwoPtr(root);
		int j=findMiddleUsingOnePtr(root);
		log.info("Midle element is: " + i);
		log.info("Midle element is: " + j);
	}
	private static int findMiddleUsingOnePtr(ListNode root){
		int count =0;
		ListNode temp=root;
		while(temp!=null){
			temp=temp.next;
			count++;
		}
		int n=0;
		temp=root;
		while(n!=count/2){
			temp=temp.next;
			n++;
		}
		return temp.data;
	}
	private static int findMiddleUsingTwoPtr(ListNode root){
		ListNode slow=root;
		ListNode fast=root;
		while(fast!=null &&fast.next!=null){
			fast=fast.next.next;
			slow=slow.next;
		}
		
		return slow.data;
	}
}
