package com.sourav.java.Tree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;

public class BottomAndTopViewOfTree {
	
	private BTree tree;
	
	BottomAndTopViewOfTree(BTree tree){
		this.tree=tree;
	}
	
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
		BottomAndTopViewOfTree t= new BottomAndTopViewOfTree(tree);
		System.out.println("Bottom view of the given binary tree:");
        t.bottomView();
        System.out.println("Top view of the given binary tree:");
        t.topView();
	}
	
	private void topView(){
		int hd=0;
		Map<Integer,Integer> map = new TreeMap<>();
		Queue<BTree> q = new LinkedList<>();
		q.add(this.tree);
		while(!q.isEmpty()){
			BTree temp = q.poll();
			hd = temp.getHd();
			System.out.println("Map put : " + temp.getData() + " : "+ temp.getHd());
			if(!map.containsKey(hd)){
				map.put(hd, temp.getData());	
			}
			
			if(temp.getLeft()!=null){
				temp.getLeft().setHd(hd-1);
				q.add(temp.getLeft());
			}
			if(temp.getRight()!=null){
				temp.getRight().setHd(hd+1);
				q.add(temp.getRight());
			}
		}
		Set<Entry<Integer,Integer>> set = map.entrySet();
		Iterator<Entry<Integer,Integer>> it = set.iterator();
		while(it.hasNext()){
			System.out.println(" " + it.next().getValue());
		}
	}
	
	private void bottomView(){
		int hd=0;
		Map<Integer,Integer> map = new TreeMap<>();
		Queue<BTree> q = new LinkedList<>();
		q.add(this.tree);
		while(!q.isEmpty()){
			BTree temp = q.poll();
			hd = temp.getHd();
			System.out.println("Map put : " + temp.getData() + " : "+ temp.getHd());
			map.put(hd, temp.getData());
			if(temp.getLeft()!=null){
				temp.getLeft().setHd(hd-1);
				q.add(temp.getLeft());
			}
			if(temp.getRight()!=null){
				temp.getRight().setHd(hd+1);
				q.add(temp.getRight());
			}
		}
		Set<Entry<Integer,Integer>> set = map.entrySet();
		Iterator<Entry<Integer,Integer>> it = set.iterator();
		while(it.hasNext()){
			System.out.println(" " + it.next().getValue());
		}
	} 

}



