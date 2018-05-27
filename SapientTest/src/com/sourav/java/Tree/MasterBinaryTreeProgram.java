package com.sourav.java.Tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;

public class MasterBinaryTreeProgram {
	public static void main(String[] args) {

		BTree tree = new BTree(20);
		tree.setLeft(new BTree(10));
		tree.setRight(new BTree(30));
		tree.getLeft().setLeft(new BTree(3));
		tree.getLeft().setRight(new BTree(15));
		tree.getRight().setLeft(new BTree(25));
		tree.getRight().setRight(new BTree(50));

		MasterBinaryTreeProgram test = new MasterBinaryTreeProgram();

		System.out.println(test.findMaxSumAtLevel(tree));

		System.out.println("Print vertical sum : ");
		test.verticalSum(tree);

		System.out.println("Pring all posible paths : ");
		test.printPaths(tree);

		System.out.println("....Binary tree Depth...." + test.heightOfBinaryTree(tree));

		System.out.println("....Print level by level....");
		test.printLevelByLevel(tree);

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

		System.out.println("....Binary tree LevelOrder in reverse Without Recursion....");
		test.printlevelOrderTraversalReverseWithoutRecursion(tree);

		System.out.println("Max Element using recursion: " + test.findMaxElement(tree));
		System.out.println("Max Element using iterative approach: " + test.maxInBTreeLevelOrder(tree));
		System.out.println("Depth of the tree: " + test.minDepth(tree));

	}

	private int findMaxElement(BTree tree) {
		int maxVal = Integer.MIN_VALUE;
		if (tree != null) {
			int leftMax = findMaxElement(tree.getLeft());
			int rightMax = findMaxElement(tree.getRight());
			if (leftMax > rightMax)
				maxVal = leftMax;
			else
				maxVal = rightMax;
			if (tree.getData() > maxVal)
				maxVal = tree.getData();
		}
		return maxVal;
	}

	private int maxInBTreeLevelOrder(BTree tree) {
		int maxVal = Integer.MIN_VALUE;
		if (tree == null) {
			return maxVal;
		}
		Queue<BTree> q = new LinkedList<>();
		q.offer(tree);
		while (!q.isEmpty()) {
			BTree temp = q.poll();
			if (temp.getLeft() != null)
				q.offer(temp.getLeft());
			if (temp.getRight() != null)
				q.offer(temp.getRight());
			if (temp.getData() > maxVal)
				maxVal = temp.getData();
		}
		return maxVal;
	}

	private int minDepth(BTree tree) {
		if (tree == null) {
			return 0;
		}
		int count = 1;
		Queue<BTree> q = new LinkedList<>();
		q.offer(tree);
		q.offer(null);
		while (!q.isEmpty()) {
			BTree temp = q.poll();
			if (temp != null) {
				if (temp.getLeft() == null && temp.getRight() == null) {
					return count;
				}
				if (temp.getLeft() != null)
					q.offer(temp.getLeft());
				if (temp.getRight() != null)
					q.offer(temp.getRight());
			} else {
				if (!q.isEmpty()) {
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
		 * Method -1 : Using two stack
		 **/

		/*
		 * Stack<BinaryTree> st1 = new Stack<BinaryTree>(); Stack<BinaryTree>
		 * st2 = new Stack<BinaryTree>(); st1.push(root); while(!st1.isEmpty())
		 * { BinaryTree temp = st1.pop(); st2.push(temp);
		 * if(temp.getLeft()!=null) st1.push(temp.getLeft());
		 * if(temp.getRight()!=null) st1.push(temp.getRight()); }
		 * while(!st2.isEmpty()) { System.out.println(st2.pop().getData()); }
		 */

		/**
		 * Method -2 : Using one stack
		 **/

		/*
		 * Stack<BinaryTree> st = new Stack<BinaryTree>(); st.push(root);
		 * BinaryTree prev= null; while(!st.isEmpty()) { BinaryTree curr=
		 * st.peek(); if(prev==null || prev.getLeft()==curr || prev.getRight()==
		 * curr) { if(curr.getLeft()!=null) st.push(curr.getLeft()); else
		 * if(curr.getRight()!=null) st.push(curr.getRight()); else { st.pop();
		 * System.out.println(curr.getData()); } }else if(curr.getLeft()==prev){
		 * if(curr.getRight()!=null) st.push(curr.getRight()); else { st.pop();
		 * System.out.println(curr.getData()); } }else {
		 * System.out.println(curr.getData()); st.pop(); } prev=curr; }
		 */

		/**
		 * Method -3 : Using one stack
		 **/

		Stack<BTree> st = new Stack<BTree>();
		BTree curr = root;
		while (!st.isEmpty() || curr != null) {
			if (curr != null) {
				st.push(curr);
				curr = curr.getLeft();
			} else {
				BTree temp = st.peek();
				if (temp.getRight() == null) {
					temp = st.pop();
					System.out.println(temp.getData());
					while (!st.isEmpty() && temp == st.peek().getRight()) {
						temp = st.pop();
						System.out.println(temp.getData());
					}
				} else {
					// st.push(temp.getRight());
					curr = temp.getRight();
				}
			}

		}

	}

	private void printlevelOrderBinaryTreeWithoutRecursion(BTree root) {

		LinkedList<BTree> q = new LinkedList<>();
		BTree temp = root;
		q.offer(temp);
		while (!q.isEmpty()) {
			temp = q.poll();
			System.out.println(temp.getData());
			if (temp.getLeft() != null)
				q.offer(temp.getLeft());
			if (temp.getRight() != null)
				q.offer(temp.getRight());
		}

	}

	private void printlevelOrderTraversalReverseWithoutRecursion(BTree root) {

		LinkedList<BTree> q = new LinkedList<>();
		Stack<BTree> s = new Stack<>();
		BTree temp = root;
		q.offer(temp);
		while (!q.isEmpty()) {
			temp = q.poll();
			if (temp.getRight() != null)
				q.offer(temp.getRight());
			if (temp.getLeft() != null)
				q.offer(temp.getLeft());
			s.push(temp);
		}
		while (!s.isEmpty()) {
			System.out.print(s.pop().getData() + " ");
		}
		System.out.println("\n");
	}

	private int heightOfBinaryTree(BTree root) {
		if (root == null) {
			return 0;
		}
		Queue<BTree> q = new LinkedList<>();
		q.offer(root);
		q.offer(null);
		int count = 1;
		while (!q.isEmpty()) {
			BTree currentNode = q.poll();
			if (currentNode != null) {
				if (currentNode.getLeft() == null && currentNode.getRight() == null)
					return count;
				if (currentNode.getLeft() != null)
					q.offer(currentNode.getLeft());
				if (currentNode.getRight() != null)
					q.offer(currentNode.getRight());
			} else {
				if (!q.isEmpty()) {
					count++;
					q.offer(null);
				}
			}
		}
		return count;
	}

	private void printLevelByLevel(BTree root) {

		// Approach -1

		/*
		 * Queue<BTree> q = new LinkedList<>(); Stack<BTree> s = new Stack<>();
		 * q.offer(root); q.offer(null); System.out.println(root.getData() + " "
		 * ); System.out.print("\n"); while (!q.isEmpty()) { BTree currentNode =
		 * q.poll(); if (currentNode != null) { if (currentNode.getRight() !=
		 * null) { q.offer(currentNode.getRight());
		 * s.push(currentNode.getRight()); } if (currentNode.getLeft() != null)
		 * { q.offer(currentNode.getLeft()); s.push(currentNode.getLeft()); } }
		 * else { if (!q.isEmpty()) { while (!s.isEmpty()) {
		 * System.out.print(s.pop().getData() + " "); } System.out.print("\n");
		 * q.offer(null); } }
		 */

		// Approach -2

		if (root == null)
			return;

		// Create an empty queue for level order tarversal
		Queue<BTree> q = new LinkedList<BTree>();

		// Enqueue Root and initialize height
		q.add(root);

		while (true) {

			// nodeCount (queue size) indicates number of nodes
			// at current level.
			int nodeCount = q.size();
			System.out.println("Width at current level: " + nodeCount);
			if (nodeCount == 0)
				break;

			// Dequeue all nodes of current level and Enqueue all
			// nodes of next level
			while (nodeCount > 0) {
				BTree node = q.peek();
				System.out.print(node.getData() + " ");
				q.remove();
				if (node.getLeft() != null)
					q.add(node.getLeft());
				if (node.getRight() != null)
					q.add(node.getRight());
				nodeCount--;
			}
			System.out.println();
		}
	}

	private int findMaxSumAtLevel(BTree root) {
		int maxsum = 0, currentsum = 0;
		int count = 1;
		BTree temp = null;
		Queue<BTree> q = new LinkedList<>();
		q.offer(root);
		q.offer(null);
		maxsum = root.getData();
		while (!q.isEmpty()) {
			temp = q.poll();
			if (temp != null) {
				if (temp.getLeft() != null) {
					q.offer(temp.getLeft());
					currentsum = currentsum + temp.getLeft().getData();
				}
				if (temp.getRight() != null) {
					q.offer(temp.getRight());
					currentsum = currentsum + temp.getRight().getData();
				}
			} else {
				if (!q.isEmpty()) {
					if (currentsum > maxsum) {
						maxsum = currentsum;
						currentsum = 0;
						count++;
					}
					q.offer(null);
				}
			}
		}
		System.out.println("Max sum at level " + count);
		return maxsum;

	}

	private void printPaths(BTree root, int[] path, int pathLen) {
		if (root == null)
			return;
		path[pathLen++] = root.getData();
		if (root.getLeft() == null && root.getRight() == null) {
			printArray(path, pathLen);
			System.out.println();
		} else {
			printPaths(root.getLeft(), path, pathLen);
			printPaths(root.getRight(), path, pathLen);
		}

	}

	private void printPaths(BTree root) {
		int[] path = new int[256];
		printPaths(root, path, 0);
	}

	private void printArray(int[] arr, int len) {
		for (int i = 0; i < len; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	private void verticalSum(BTree root) {
		int sum = 0;
		Queue<BTree> q = new LinkedList<>();
		Map<Integer, List<Integer>> map = new TreeMap<>();
		List<Integer> lst = new ArrayList<>();
		lst.add(root.getData());
		root.setHd(0);
		q.offer(root);
		map.put(root.getHd(), lst);
		while (!q.isEmpty()) {
			BTree temp = q.poll();
			if (temp.getLeft() != null) {
				lst = new ArrayList<>();
				temp.getLeft().setHd(temp.getHd() - 1);
				q.offer(temp.getLeft());
				if (map.containsKey(temp.getLeft().getHd())) {
					lst = map.get(temp.getLeft().getHd());
					lst.add(temp.getLeft().getData());
					map.put(temp.getLeft().getHd(), lst);
				} else {
					lst.add(temp.getLeft().getData());
					map.put(temp.getLeft().getHd(), lst);
				}
			}
			if (temp.getRight() != null) {
				lst = new ArrayList<>();
				temp.getRight().setHd(temp.getHd() + 1);
				q.offer(temp.getRight());
				if (map.containsKey(temp.getRight().getHd())) {
					lst = map.get(temp.getRight().getHd());
					lst.add(temp.getRight().getData());
					map.put(temp.getRight().getHd(), lst);
				} else {
					lst.add(temp.getRight().getData());
					map.put(temp.getRight().getHd(), lst);
				}
			}
		}
		Set<Map.Entry<Integer, List<Integer>>> st = map.entrySet();
		Iterator<Map.Entry<Integer, List<Integer>>> it = st.iterator();
		while (it.hasNext()) {
			List<Integer> l = map.get(it.next().getKey());
			for (Integer i : l) {
				sum += i;
			}
			System.out.print(sum + " ");
			sum = 0;
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
		this.hd = Integer.MAX_VALUE;
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
