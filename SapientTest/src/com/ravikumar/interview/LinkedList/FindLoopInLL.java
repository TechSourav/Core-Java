package com.ravikumar.interview.LinkedList;

public class FindLoopInLL {

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
		ListNode temp= root;
		while(temp.next!=null){
			temp=temp.next;
		}
		temp.next=root.next.next.next.next.next.next;
		System.out.println(temp.next.data);
		System.out.println(findLoop(root));
	}
	
	private static int findLoop(ListNode root){
		ListNode slow=root.next;
		ListNode fast=root.next.next;
		int loopExists=0;
		while(slow!=null && fast!=null && slow!=fast){
			slow=slow.next;
			fast=fast.next.next;
		}
		if(slow==fast){
			loopExists=1;
			System.out.println("Loop Found");
		}
		else
			System.out.println("Loop NOT Found");
		if(loopExists==1){
			slow=root;
			while(slow!=fast){
				slow=slow.next;
				fast=fast.next;
			}
			return slow.data;
		}
		else
			return 0;
	}

}
