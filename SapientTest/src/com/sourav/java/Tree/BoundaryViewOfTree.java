package com.sourav.java.Tree;

public class BoundaryViewOfTree {

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
		
		printLeftBoundary(tree);
		printLeaves(tree);
		printRightBoundary(tree);

	}
	
	private static void printLeaves(BTree root){
		if(root!=null){
			if(root.getLeft()==null && root.getRight()==null){
				System.out.print(root.getData()+" ");
			}
			printLeaves(root.getLeft());
			printLeaves(root.getRight());
		}
	}
	
	private static void printLeftBoundary(BTree root){
		if(root!=null){
			if(root.getLeft()!=null){
				System.out.print(root.getData()+" ");
				printLeftBoundary(root.getLeft());
			}else if(root.getRight()!=null){
				System.out.print(root.getData()+" ");
				printLeftBoundary(root.getRight());
			}
		}	
	}
	
	private static void printRightBoundary(BTree root){
		if(root!=null){
			if(root.getRight()!=null){
				printRightBoundary(root.getRight());
				System.out.print(root.getRight().getData()+ " ");
			}else if(root.getLeft()!=null){
				printRightBoundary(root.getLeft());
				System.out.print(root.getLeft().getData()+ " ");
			}
		}
	}

}
