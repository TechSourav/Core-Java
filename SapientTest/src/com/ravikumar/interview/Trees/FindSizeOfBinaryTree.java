package com.ravikumar.interview.Trees;

public class FindSizeOfBinaryTree {

	public static void main(String[] args) {
		BinaryTree btree = new BinaryTree();
		BTNode node=null;
		node=btree.addElement(5, node);
		node=btree.addElement(1, node);
		node=btree.addElement(8, node);
		node=btree.addElement(-2, node);
		node=btree.addElement(3, node);
		node=btree.addElement(6, node);
		node=btree.addElement(9, node);
		node=btree.addElement(-3, node);
		node=btree.addElement(-1, node);
		node=btree.addElement(-4, node);
		System.out.println("Size of Binary Tree: "+findSize(node));
	}
	
	private static int findSize(BTNode root){
		if(root==null){
			return 0;
		}
		int leftSubTree= findSize(root.left);
		int rightSubTree= findSize(root.right);
		return (leftSubTree+rightSubTree+1);
	}

}

class BTNode{
	
	BTNode left;
	BTNode right;
	int data;
	
	BTNode(int val){
		this.data=val;
		this.left=null;
		this.right=null;
	}
	
}

class BinaryTree{
	
	public BTNode addElement(int val, BTNode root){
		BTNode newNode= new BTNode(val);
		BTNode tempNode;
		BTNode previous=null;
		if(root==null){
			return newNode;
		}
		tempNode=root;
		while(root!=null){
			previous=root;
			if(root.data<val){
				root=root.right;
			}else if(root.data> val){
				root=root.left;
			}
		}
		if(previous.data<val){
			previous.right=newNode;
		}else{
			previous.left=newNode;
		}
		return tempNode;
	}
}
