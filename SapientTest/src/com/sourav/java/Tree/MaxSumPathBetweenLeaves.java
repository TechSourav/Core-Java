package com.sourav.java.Tree;

import java.util.LinkedList;
import java.util.List;

public class MaxSumPathBetweenLeaves {

	class Res {
		int val;
	}
	
	class Maximum{
		int max_sum;
	}
	
	BTree target_leaf=null;

	public static void main(String[] args) {
		
/*		BTree tree = new BTree(-15);
		tree.setLeft(new BTree(5));
		tree.setRight(new BTree(6));
		tree.getLeft().setLeft(new BTree(-8));
		tree.getLeft().setRight(new BTree(1));
		tree.getLeft().getLeft().setLeft(new BTree(2));
		tree.getLeft().getLeft().setRight(new BTree(6));
		tree.getRight().setLeft(new BTree(3));
		tree.getRight().setRight(new BTree(9));
		tree.getRight().getRight().setRight(new BTree(0));
		tree.getRight().getRight().getRight().setLeft(new BTree(4));
		tree.getRight().getRight().getRight().setLeft(new BTree(-1));
		tree.getRight().getRight().getRight().getLeft().setLeft(new BTree(10));*/
		 

		BTree tree = new BTree(20);
		tree.setLeft(new BTree(8));
		tree.setRight(new BTree(22));
		tree.getLeft().setLeft(new BTree(5));
		tree.getLeft().setRight(new BTree(3));
		tree.getRight().setLeft(new BTree(4));
		tree.getRight().setRight(new BTree(25));
		tree.getLeft().getRight().setLeft(new BTree(10));
		tree.getLeft().getRight().setRight(new BTree(14));
		// tree.getLeft().getRight().getLeft().setLeft(new BTree(9));
		tree.getLeft().getRight().getLeft().setRight(new BTree(11));
		tree.getRight().getRight().setLeft(new BTree(24));
		tree.getRight().getRight().setRight(new BTree(26));
		
		/*BTree tree = new BTree(10);
		tree.setLeft(new BTree(-2));
		tree.setRight(new BTree(7));
		tree.getLeft().setLeft(new BTree(8));
		tree.getLeft().setRight(new BTree(-4));*/

		MaxSumPathBetweenLeaves leaves = new MaxSumPathBetweenLeaves();
		System.out.println("Max pathSum of the given binary tree is " + leaves.maxPathSum(tree));
		System.out.println("\nMax sum root to leaf: "+leaves.maxPathSumFromRootToLeaf(tree));

	}

	int maxPathSumUtil(BTree root, Res res) {

		// Base cases
		if (root == null)
			return 0;
		if (root.getLeft() == null && root.getRight() == null)
			return root.getData();

		// Find maximum sum in left and right subtree. Also
		// find maximum root to leaf sums in left and right
		// subtrees and store them in ls and rs
		int ls = maxPathSumUtil(root.getLeft(), res);
		int rs = maxPathSumUtil(root.getRight(), res);

		// If both left and right children exist
		if (root.getLeft() != null && root.getRight() != null) {

			// Update result if needed
			res.val = Math.max(res.val, ls + rs + root.getData());

			// Return maxium possible value for root being
			// on one side
			return Math.max(ls, rs) + root.getData();
		}

		// If any of the two children is empty, return
		// root sum for root being on one side
		return (root.getLeft() == null) ? rs + root.getData() : ls + root.getData();
	}

	// The main function which returns sum of the maximum
	// sum path between two leaves. This function mainly
	// uses maxPathSumUtil()
	int maxPathSum(BTree root) {
		Res res = new Res();
		res.val = Integer.MIN_VALUE;
		maxPathSumUtil(root, res);
		return res.val;
	}

	private int maxPathSumFromRootToLeaf(BTree root) {
		
		Maximum max = new Maximum();
		max.max_sum=Integer.MIN_VALUE;
		
		// 1. get target leaf
		getTragetLeaf(root,max,0);
		// 2. print root to target leaf path
		printPathToTarget(root,target_leaf);
		// 3. return max sum
		return max.max_sum;
	}

	private void getTragetLeaf(BTree root, Maximum max_sum, int curr){
		int curr_sum=curr;
		if(root==null)
			return ;
		curr_sum= curr_sum+root.getData();
		if(root.getLeft()==null && root.getRight()==null){
			if(curr_sum>max_sum.max_sum){
				max_sum.max_sum= curr_sum;
				target_leaf=root;
				return;
			}
			return;
		}
		getTragetLeaf(root.getLeft(),max_sum,curr_sum);
		getTragetLeaf(root.getRight(),max_sum,curr_sum);
	}
	private boolean printPathToTarget(BTree root, BTree target){
		if(root==null)
			return false;
		if(root.getData()==target.getData() || printPathToTarget(root.getLeft(), target)
                || printPathToTarget(root.getRight(), target)){
			 System.out.print(root.getData() + " ");
	         return true;
		}
		return false;
	}

}
