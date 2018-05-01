package com.ravikumar.interview.LinkedList;

import java.util.HashSet;
import java.util.Set;

public class FindKthNodeFromEndOfLL {

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
		createLoop(root);
		
		//System.out.println(findKthNodeFromEnd(root, 5));
		System.out.println(detectLoop(root)? "Loop Found": "Loop not found");
	}
	
	private static void createLoop(ListNode root){
		ListNode temp= root;
		while(temp.next!=null){
			temp=temp.next;
		}
		temp.next=root.next.next.next.next.next.next;
	}
	
	private static boolean detectLoop(ListNode node){
		Set<ListNode> set = new HashSet<>();
		ListNode temp=node;
		while(temp!=null){
			if(set.contains(temp)){
				return true;
			}else{
				set.add(temp);
				temp=temp.next;
			}
			
		}
		return false;
	}
	
	private static int findKthNodeFromEnd(ListNode node, int k){
		ListNode fast=node;
		ListNode slow=node;
		int count=0;
		while(count!=k){
			fast=fast.next;
			count++;
		}
		while(fast.next!=null){
			slow=slow.next;
			fast=fast.next;
		}
		
		return slow.next.data;
	}

}
