package com.sourav.java.Tree;

public class PrintRootToLeafPath {

	public static void main(String[] args) {
	
		BTree tree = new BTree(20);
		tree.setLeft(new BTree(10));
		tree.setRight(new BTree(30));
		tree.getLeft().setLeft(new BTree(3));
		tree.getLeft().setRight(new BTree(15));
		tree.getRight().setLeft(new BTree(25));
		tree.getRight().setRight(new BTree(50));
		printPaths(tree, new int[256], 0);

	}
	
	private static void printPaths(BTree root, int[] path, int len){
		if(root!=null){
			path[len++]= root.getData();
		}
		if(root.getLeft()==null && root.getRight()==null){
			printArray(path,len);
			System.out.println();
		}else{
			printPaths(root.getLeft(),path,len);
			printPaths(root.getRight(),path,len);
		}
	}
	
	private static void printArray(int[] path, int len){
		for(int i=0;i<len;i++){
			System.out.print(path[i] + " ");
		}
	}

}
