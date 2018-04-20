package com.ravikumar.interview.LinkedList;

import com.sun.istack.internal.logging.Logger;

public class MyLinkedList {
	Logger log = Logger.getLogger(MyLinkedList.class);
	
	public ListNode addNodeAtEnd(ListNode root, int v){
		ListNode temp=root;
		while(temp.next!=null){
			temp=temp.next;
		}
		temp.next=ListNode.newNode(v);
		return root;
	}
	
	public void printList(ListNode root){
		while(root!=null){
			log.info(String.format("Node %s printed", root.data));
			root=root.next;
		}
	}
}

class ListNode{
	int data;
	ListNode next;
	public static ListNode newNode(int val){
		ListNode ln= new ListNode();
		ln.data=val;
		ln.next=null;
		return ln;
	}
}
