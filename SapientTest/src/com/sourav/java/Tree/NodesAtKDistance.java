package com.sourav.java.Tree;

public class NodesAtKDistance {

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
		tree.getLeft().getRight().getLeft().setLeft(new BTree(9));
		tree.getLeft().getRight().getLeft().setRight(new BTree(15));
		tree.getRight().getRight().setLeft(new BTree(24));
		tree.getRight().getRight().setRight(new BTree(26));
		NodesAtKDistance ndk= new NodesAtKDistance();
		// Pring all nodes at K=3 from target = 4(leaf node)
		ndk.printNodesAtKDistance(tree,tree.getLeft().getRight().getLeft(),4);

	}
	
	private int printNodesAtKDistance(BTree root, BTree target, int k){
		if(root==null)
			return -1;
		if(root==target){
			printNodesAtKDistanceDown(root,k);
			return 0;
		}
		int dleft=printNodesAtKDistance(root.getLeft(),target,k);
		if(dleft!=-1){
			if(dleft+1==k){
				System.out.print(root.getData()+" ");
			}else{
				printNodesAtKDistanceDown(root.getRight(),(k-dleft-2));
			}
			return dleft+1;
		}
		int dright=printNodesAtKDistance(root.getRight(),target,k);
		if(dright!=-1){
			if(dright+1==k){
				System.out.print(root.getData()+" ");
			}else{
				printNodesAtKDistanceDown(root.getLeft(),(k-dright-2));
			}
			return dright+1;
		}
		return -1;
	}
	
	private void printNodesAtKDistanceDown(BTree root, int k){
		if(root==null || k < 0)
			return;
		if(k==0){
			System.out.print(root.getData()+" ");
			return;
		}
		printNodesAtKDistanceDown(root.getLeft(),k-1);
		printNodesAtKDistanceDown(root.getRight(),k-1);
	}

}
