package com.sourav.java.Tree;

import java.util.Iterator;
import java.util.Stack;

public class PrintPathWithGivenSum {
	
	int sum=0;
	Stack<Integer> st = new Stack<>();

	public static void main(String[] args) {
		BTree tree = new BTree(20);
		tree.setLeft(new BTree(10));
		tree.setRight(new BTree(30));
		tree.getLeft().setLeft(new BTree(3));
		tree.getLeft().setRight(new BTree(15));
		tree.getRight().setLeft(new BTree(25));
		tree.getRight().setRight(new BTree(50));
		
		PrintPathWithGivenSum printPath = new PrintPathWithGivenSum();
		printPath.printPath(tree, 45);

	}
	
	private void printPath(BTree root, int k){
		
		if(root==null)
			return;
		sum=sum+root.getData();
		st.push(root.getData());
		if(sum==k){
			printStack(st);
		}
		printPath(root.getLeft(),k);
		printPath(root.getRight(),k);
		sum=sum-root.getData();
		st.pop();
	}
	
	private void printStack(Stack<Integer> st){
		Iterator<Integer> it = st.iterator();
		while(it.hasNext()){
			System.out.println(it.next()+ " ");
		}
	}

}
