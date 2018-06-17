package com.sourav.java.Tree;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class DiagonalViewOfTree {

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
		DiagonalViewOfTree d = new DiagonalViewOfTree();
		HashMap<Integer,Vector<Integer>> map = new HashMap<>();
		d.printDiagonal(tree,map,0);
		for(Map.Entry<Integer, Vector<Integer>> m: map.entrySet()){
			System.out.println(m.getValue());
		}
	}
	
	private void printDiagonal(BTree root, HashMap<Integer,Vector<Integer>> map, int d){
		if(root==null)
			return;
		Vector<Integer> k = map.get(d);
		if(k==null){
			k= new Vector<>();
			k.add(root.getData());
		}else{
			k.add(root.getData());
		}
		map.put(d,k);
		printDiagonal(root.getLeft(),map,d+1);
		printDiagonal(root.getRight(),map,d);
	}

}
