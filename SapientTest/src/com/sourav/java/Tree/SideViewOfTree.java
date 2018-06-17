package com.sourav.java.Tree;

public class SideViewOfTree {
	
	static int  max_level = 0;
	
	public static void main(String[] args) {
		BTree tree = new BTree(20);
		tree.setLeft(new BTree(8));
		tree.setRight(new BTree(22));
		tree.getLeft().setLeft(new BTree(5));
		tree.getLeft().setRight(new BTree(3));
		tree.getRight().setLeft(new BTree(4));
		tree.getRight().setRight(new BTree(25));
		tree.getLeft().getRight().setLeft(new BTree(10));
		tree.getLeft().getRight().setRight(new BTree(14));
		
		System.out.println("Left side view: ");
		leftSideView(tree,1);
		System.out.println("Right Side View: ");
		max_level=0;
		rightSideView(tree,1);
	}
	
	private static void leftSideView(BTree root,int level) {
		int max = max_level;
		int curr_level = level;
		if (root != null) {
			if (max < curr_level) {
				System.out.println(root.getData());
				max_level = curr_level;
			}
			leftSideView(root.getLeft(), curr_level + 1);
			leftSideView(root.getRight(), curr_level + 1);
		}
	}
	
	private static void rightSideView(BTree root, int level)
	{
		int max = max_level;
		int curr_level = level;
		if (root != null) {
			if (max < curr_level) {
				System.out.println(root.getData());
				max_level = curr_level;
			}
			rightSideView(root.getRight(), curr_level + 1);
			rightSideView(root.getLeft(), curr_level + 1);
			
		}
	}

}
