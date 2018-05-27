package com.sourav.java.LinkedList;

import java.util.HashMap;
import java.util.Map;

public class FindInterssectionInList {
	
	static Node head1, head2;

	static class Node {

		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}
	
	public static void main(String[] args) {
		FindInterssectionInList list = new FindInterssectionInList();

		// creating first linked list
		list.head1 = new Node(3);
		list.head1.next = new Node(6);
		list.head1.next.next = new Node(9);
		list.head1.next.next.next = new Node(15);
		list.head1.next.next.next.next = new Node(30);

		// creating second linked list
		list.head2 = new Node(10);
		list.head2.next = new Node(15);
		list.head2.next.next = new Node(30);

		System.out.println("The node of intersection is " + ((list.getNode() < 0) ? "False": list.getNode()));

	}
	
	private int getNode(){
		Node temp=head1;
		Map<Integer, Integer> map = new HashMap<>();
		
		while(temp!=null){
			map.put(temp.data,temp.data);
			temp=temp.next;
		}
		while(this.head2!=null){
			if(map.containsKey(head2.data)){
				return head2.data;
			}else{
				head2=head2.next;
			}
		}
		return -1;
		
	}

}
