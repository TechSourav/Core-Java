package com.ravikumar.interview.LinkedList;

import com.sun.istack.internal.logging.Logger;

public class ReverseLinkedList {
	static Logger log = Logger.getLogger(ReverseLinkedList.class);
	
	public static void main(String[] args) {
		MyLinkedList mll= new MyLinkedList();
		ListNode root = ListNode.newNode(10);
		root=mll.addNodeAtEnd(root, 12);
		root=mll.addNodeAtEnd(root, 14);
		root=mll.addNodeAtEnd(root, 16);
		root=mll.addNodeAtEnd(root, 18);
		root=mll.addNodeAtEnd(root, 20);
		log.info("Before reversal");
		mll.printList(root);
		root=reverseList(root);
		log.info("After reversal");
		mll.printList(root);
	}
	private static ListNode reverseList(ListNode root){
		ListNode prev=null;
		ListNode curr=root;
		ListNode temp;
		while(curr!=null){
			temp=curr.next;
			curr.next=prev;
			prev=curr;
			curr=temp;
		}
		return prev;
	}

}
