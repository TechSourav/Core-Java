package com.sourav.java.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class PrintNodesInAlternateOrder {

	public static void main(String[] args) {
		
		BTree tree = new BTree(20);
		tree.setLeft(new BTree(10));
		tree.setRight(new BTree(30));
		tree.getLeft().setLeft(new BTree(3));
		tree.getLeft().setRight(new BTree(15));
		tree.getRight().setLeft(new BTree(25));
		tree.getRight().setRight(new BTree(50));
		
		PrintNodesInAlternateOrder pn = new PrintNodesInAlternateOrder();
		pn.printAlternateOrder(tree);
	}
	
	private void printAlternateOrder(BTree root){
		Queue<BTree> q = new LinkedList<>();
		boolean flag = false;
		q.offer(root);
		while(!q.isEmpty()){
			int nodecount= q.size();
			int n = nodecount;
			while(n>0){
				
				BTree temp = q.poll();
				if(temp.getLeft()!=null)
					q.offer(temp.getLeft());
				if(temp.getRight()!=null)
					q.offer(temp.getRight());
				if(!flag && n==nodecount){
					System.out.println(temp.getData());
				}
				if(flag && n==1){
					System.out.println(temp.getData());
				}
			    n--;
			    
			}
			
			flag=!flag;
		}
	}

}
