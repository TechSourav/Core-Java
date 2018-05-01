package com.sourav.java.Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeProgram {
	public static void main(String[] args) {

		BTree tree = new BTree(20);
		tree.setLeft(new BTree(10));
		tree.setRight(new BTree(30));
		tree.getLeft().setLeft(new BTree(3));
		tree.getLeft().setRight(new BTree(15));
		tree.getRight().setLeft(new BTree(25));
		tree.getRight().setRight(new BTree(50));

		BinaryTreeProgram test = new BinaryTreeProgram();

		System.out.println("....Binary tree Inorder....");
		test.printInorderBinaryTreeRecursively(tree);
		System.out.println("....Binary tree Preorder....");
		test.printPreorderBinaryTreeRecursively(tree);
		System.out.println("....Binary tree Postorder....");
		test.printPostorderBinaryTreeRecursively(tree);

		System.out.println("....Binary tree Inorder Without Recursion....");
		test.printInorderBinaryTreeWithoutRecursion(tree);
		System.out.println("....Binary tree Preorder Without Recursion....");
		test.printPreorderBinaryTreeWithoutRecursion(tree);
		System.out.println("....Binary tree Postorder Without Recursion....");
		test.printPostorderBinaryTreeWithoutRecursion(tree);
		
		System.out.println("....Binary tree LevelOrder Without Recursion....");
		test.printlevelOrderBinaryTreeWithoutRecursion(tree);
		
		System.out.println("Max Element using recursion: " + test.findMaxElement(tree));
		System.out.println("Max Element using iterative approach: " + test.maxInBTreeLevelOrder(tree));
		System.out.println("Depth of the tree: " + test.minDepth(tree));

	}
	
	private int findMaxElement(BTree tree) {
		int maxVal = Integer.MIN_VALUE;
		if(tree!=null) {
			int leftMax= findMaxElement(tree.getLeft());
			int rightMax= findMaxElement(tree.getRight());
			if(leftMax>rightMax)
				maxVal=leftMax;
			else
				maxVal=rightMax;
			if(tree.getData()>maxVal)
				maxVal=tree.getData();
		}
		return maxVal;
	}
	
	private int maxInBTreeLevelOrder(BTree tree) {
		int maxVal= Integer.MIN_VALUE;
		if(tree==null) {
			return maxVal;
		}
		Queue<BTree> q = new LinkedList<>();
		q.offer(tree);
		while(!q.isEmpty()) {
			BTree temp= q.poll();
			if(temp.getLeft()!=null)
				q.offer(temp.getLeft());
			if(temp.getRight()!=null)
				q.offer(temp.getRight());
			if(temp.getData()>maxVal)
				maxVal=temp.getData();
		}
		return maxVal;
	}
	
	private int minDepth(BTree tree) {
		if(tree==null) {
			return 0;
		}
		int count =1;
		Queue<BTree> q = new LinkedList<>();
		q.offer(tree);
		q.offer(null);
		while(!q.isEmpty()) {
			BTree temp= q.poll();
			if(temp!=null) {
				if(temp.getLeft()==null && temp.getRight()==null) {
					return count;
				}
				if(temp.getLeft()!=null)
					q.offer(temp.getLeft());
				if(temp.getRight()!=null)
					q.offer(temp.getRight());
			}else {
				if(!q.isEmpty()) {
					count++;
					q.offer(null);
				}
			}
		}
		return count;
	}

	private void printInorderBinaryTreeRecursively(BTree tree) {
		if (tree != null) {
			printInorderBinaryTreeRecursively(tree.getLeft());
			System.out.println(tree.getData());
			printInorderBinaryTreeRecursively(tree.getRight());
		}
	}

	private void printPreorderBinaryTreeRecursively(BTree tree) {
		if (tree != null) {
			System.out.println(tree.getData());
			printPreorderBinaryTreeRecursively(tree.getLeft());
			printPreorderBinaryTreeRecursively(tree.getRight());
		}
	}

	private void printPostorderBinaryTreeRecursively(BTree tree) {
		if (tree != null) {
			printPostorderBinaryTreeRecursively(tree.getLeft());
			printPostorderBinaryTreeRecursively(tree.getRight());
			System.out.println(tree.getData());
		}
	}

	private void printInorderBinaryTreeWithoutRecursion(BTree root) {
		Stack<BTree> st = new Stack<BTree>();
		BTree currentnode = root;
		boolean done = false;

		if (root == null) {
			System.out.println("Empty Tree..");
		}

		while (!done) {
			if (currentnode != null) {
				st.push(currentnode);
				currentnode = currentnode.getLeft();
			} else {
				if (st.isEmpty()) {
					done = true;
				} else {
					currentnode = st.pop();
					System.out.println(currentnode.getData());
					currentnode = currentnode.getRight();
				}
			}
		}
	}

	private void printPreorderBinaryTreeWithoutRecursion(BTree root) {
		Stack<BTree> st = new Stack<BTree>();
		BTree temp = root;
		st.push(root);
		while (!st.isEmpty()) {
			if (temp != null) {
				System.out.println(temp.getData());
				temp = temp.getLeft();
				if (temp != null)
					st.push(temp);
			} else {
				temp = st.pop();
				temp = temp.getRight();
				if (temp != null)
					st.push(temp);
			}
		}
	}

	private void printPostorderBinaryTreeWithoutRecursion(BTree root) {
		
		/**
		 *  Method -1 : Using one stack 
		 **/
		
		/*Stack<BinaryTree> st1 = new Stack<BinaryTree>();
		Stack<BinaryTree> st2 = new Stack<BinaryTree>();
		st1.push(root);
		while(!st1.isEmpty()) {
			BinaryTree temp = st1.pop();
			st2.push(temp);
			if(temp.getLeft()!=null)
				st1.push(temp.getLeft());
			if(temp.getRight()!=null)
				st1.push(temp.getRight());
		}
		while(!st2.isEmpty()) {
			System.out.println(st2.pop().getData());
		}*/
		
		
		/**
		 *  Method -2 : Using one stack 
		 **/
		
		/*Stack<BinaryTree> st = new Stack<BinaryTree>();
		st.push(root);
		BinaryTree prev= null;
		while(!st.isEmpty()) {
			BinaryTree curr= st.peek();
			if(prev==null || prev.getLeft()==curr || prev.getRight()== curr) {
				if(curr.getLeft()!=null)
					st.push(curr.getLeft());
				else if(curr.getRight()!=null)
					st.push(curr.getRight());
				else
                {	st.pop();
                    System.out.println(curr.getData());
                }
			}else if(curr.getLeft()==prev){
				if(curr.getRight()!=null)
					st.push(curr.getRight());
				else
                {	st.pop();
                    System.out.println(curr.getData());
                }
			}else {
				System.out.println(curr.getData());
				st.pop();
			}
			prev=curr;
		}*/
		
		/**
		 *  Method -3 : Using one stack 
		 **/
		
		Stack<BTree> st = new Stack<BTree>();
		BTree curr= root;
		while(!st.isEmpty() || curr!=null) {
			if(curr!=null) {
				st.push(curr);
				curr=curr.getLeft();
			}else {
				BTree temp=st.peek();
				if(temp.getRight()==null) {
					temp=st.pop();
					System.out.println(temp.getData());
					while(!st.isEmpty() && temp== st.peek().getRight()) {
					  temp=st.pop();
					  System.out.println(temp.getData());
					}
				}else {
				  //st.push(temp.getRight());
				  curr=temp.getRight();
				}
			}
		   
		}
		
	}
	
	private void printlevelOrderBinaryTreeWithoutRecursion(BTree root) {
		
		LinkedList<BTree> q = new LinkedList<>();
		BTree temp = root;
		q.offer(temp);
		while(!q.isEmpty()) {
			temp = q.poll();
			System.out.println(temp.getData());
			if(temp.getLeft()!=null)
				q.offer(temp.getLeft());
			if(temp.getRight()!=null)
				q.offer(temp.getRight());
		}
		
	}
}

class BTree {

	private int data;
	private int hd;
	
	private BTree left;
	private BTree right;

	BTree() {
	}

	BTree(int data) {
		this.data = data;
		this.hd=Integer.MAX_VALUE;
		this.left = null;
		this.right = null;
	}

	public int getHd() {
		return hd;
	}

	public void setHd(int hd) {
		this.hd = hd;
	}
	
	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public BTree getLeft() {
		return left;
	}

	public void setLeft(BTree left) {
		this.left = left;
	}

	public BTree getRight() {
		return right;
	}

	public void setRight(BTree right) {
		this.right = right;
	}

}
