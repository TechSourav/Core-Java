package com.sourav.java.Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TestBinaryTree {
	
	public static void main(String[] args){
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
		System.out.println("Height"+ btree.height(node));
		System.out.println("Size"+ btree.size(node));
		btree.printNode(node); // Call for Approach #1
		//btree.printLevelWise(node); // Call for Approach #2
		
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
	
	
	public int height(BTNode root){
		if(root==null){
			return 0;
		}
		int leftHeight =  height(root.left);
		int rightHeight =  height(root.right);
		return 1+ Math.max(leftHeight,rightHeight);
	}
	
	public int size(BTNode root){
		if(root==null){
			return 0;
		}
		int leftSize  = size(root.left);
		int rightSize = size(root.right);
		return (leftSize+rightSize+1);
		
	}
	
	// Approach 1 to Print List of nodes in Level Order Traversal..
	
	public void printNode(BTNode root){
		
		Queue<BTNode> nodes = new LinkedList<>();
		
		List<BTNode> listOfNodes = new ArrayList<BTNode>();
		// add root to the list.
		traverseLevels(root,listOfNodes,nodes);
		//printing in a straight line
	    for(int i=0;i<listOfNodes.size();i++){
		  System.out.print(" "+listOfNodes.get(i).data);
	    }
		// printing level wise
		int count = 0,level=0;
		
		while(count<listOfNodes.size()){
			int printLen= (int) Math.pow(2, level++);
			
			for (int i=count; i < printLen -1 && i < listOfNodes.size();++i){
	            System.out.print(listOfNodes.get(i).data +" ");
	        }
	            System.out.println();
	            count = printLen-1;
		}
		
		
	}
	
	public void traverseLevels(BTNode root, List<BTNode> listOfNodes, Queue<BTNode> nodes){
		
		if(root!=null){
			nodes.add(root);
			listOfNodes.add(root);
			while(!nodes.isEmpty()){
				root=nodes.poll();
				if(root.left!=null){
					listOfNodes.add(root.left);
					nodes.add(root.left);
				}
				if(root.right!=null){
					listOfNodes.add(root.right);
					nodes.add(root.right);
				}
				
			}
			
		}
		
	}	
	
	
	// Approach 2 to print Level Order traversal..
	
	
	/*public void printLevelWise(BTNode root) {
	    List<List<BTNode>> levels = traverseLevels(root);

	    for (List<BTNode> level : levels) {
	        for (BTNode node : level) {
	            System.out.print(node.data + " ");
	        }
	        System.out.println();
	    }
	}
	
	private List<List<BTNode>> traverseLevels(BTNode root) {
	    if (root == null) {
	        return Collections.emptyList();
	    }
	    List<List<BTNode>> levels = new LinkedList<>();

	    Queue<BTNode> nodes = new LinkedList<>();
	    nodes.add(root);

	    while (!nodes.isEmpty()) {
	        List<BTNode> level = new ArrayList<>(nodes.size());
	        levels.add(level);

	        for (BTNode node : new ArrayList<>(nodes)) {
	            level.add(node);
	            if (node.left != null) {
	                nodes.add(node.left);
	            }
	            if (node.right != null) {
	                nodes.add(node.right);
	            }
	            nodes.poll();
	        }
	    }
	    return levels;
	}*/
	
}





