package com.ravikumar.interview.Trees;

import java.util.Stack;

public class CompareTwoTrees {
	
	public static void main(String [] args){
		BinaryTree btree1 = new BinaryTree();
		BTNode node1=null;
		node1=btree1.addElement(5, node1);
		node1=btree1.addElement(1, node1);
		node1=btree1.addElement(8, node1);
		node1=btree1.addElement(-2, node1);
		node1=btree1.addElement(3, node1);
		node1=btree1.addElement(6, node1);
		node1=btree1.addElement(9, node1);
		node1=btree1.addElement(-3, node1);
		node1=btree1.addElement(-1, node1);
		node1=btree1.addElement(-4, node1);
		
		BinaryTree btree2 = new BinaryTree();
		BTNode node2=null;
		node2=btree2.addElement(5, node2);
		node2=btree2.addElement(1, node2);
		node2=btree2.addElement(8, node2);
		node2=btree2.addElement(-2, node2);
		node2=btree2.addElement(3, node2);
		node2=btree2.addElement(6, node2);
		node2=btree2.addElement(9, node2);
		node2=btree2.addElement(-3, node2);
		node2=btree2.addElement(-1, node2);
		node2=btree2.addElement(-4, node2);
		
		if(identicalTrees(node1, node2)){
			System.out.println("Identical");
		}else{
			System.out.println("Not Identical");
		}
	}
	
	private static boolean identicalTrees(BTNode root1, BTNode root2){
		return (preorderData(root1).equals(preorderData(root2)));
	}
	
	private static String preorderData(BTNode root){
		Stack<BTNode> st = new Stack<BTNode>();
		String str="";
		BTNode temp = root;
		st.push(root);
		while (!st.isEmpty()) {
			if (temp != null) {
				str=str+temp.data;
				temp = temp.left;
				if (temp != null)
					st.push(temp);
			} else {
				temp = st.pop();
				temp = temp.right;
				if (temp != null)
					st.push(temp);
			}
		}
		return str;
	}

}
