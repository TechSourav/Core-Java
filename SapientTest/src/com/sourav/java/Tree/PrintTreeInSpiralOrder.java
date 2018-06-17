package com.sourav.java.Tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;



/**
 * Date 06/16/2018
 * @author souravK
 *
 * Video link - https://youtu.be/vjt5Y6-1KsQ
 *
 * Given a root of binary tree, print in spiral order. 
 * e.g               1 
 *             2           3 
 *        4       5     6      7
 *      8   9  10    11 
 * should print 1 3 2 4 5 6 7 8 9 10 11
 *
 * Solution 1 : Use two stack. Put root in stack1. While stack1 is not
 * empty take items from stack1 and put its child left,right in stack2.
 * Then once stack1 is empty pop from stack2 and put its child right,
 * left into stack1.
 * 
 * Solution 2 : Use one dequeue. Technique is like above but instead of
 * using two stack use dequeue. Also keep count till which point you read
 * in the dequeue.
 * 
 * Solution 3: Use one dequeue. Use a delimiter to separate between one 
 * stack growing from top and another one growing from bottom.
 *         
 * Time complexity is O(n) 
 * Space complexity is O(n)
 *
 * Reference
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 */


public class PrintTreeInSpiralOrder {

	public static void main(String[] args) {
		BTree tree = new BTree(20);
		tree.setLeft(new BTree(10));
		tree.setRight(new BTree(30));
		tree.getLeft().setLeft(new BTree(3));
		tree.getLeft().setRight(new BTree(15));
		tree.getRight().setLeft(new BTree(25));
		tree.getRight().setRight(new BTree(50));
		
		spiralWithTwoStack(tree);
		System.out.println();
		spiralWithOneDequeDelimiter(tree);

	}
	
	/**
     * One deque with delimiter to print tree in spiral order
     */
    public static void spiralWithOneDequeDelimiter(BTree root)
    {
        if(root == null){
            return;
        }
        Deque<BTree> q = new LinkedList<>();
        q.offer(null);
        q.offerFirst(root);
        //if only delimiter(in this case null) is left in queue then break
        while(q.size() > 1){
            root = q.peekFirst();
            while(root != null){
                root = q.pollFirst();
                System.out.print(root.getData() + " ");
                if(root.getLeft() != null){
                    q.offerLast(root.getLeft());
                }
                if(root.getRight() != null){
                    q.offerLast(root.getRight());
                }
                root = q.peekFirst();
            }
            root = q.peekLast();
            while(root != null){
                System.out.print(root.getData() + " ");
                root = q.pollLast();
                if(root.getRight() != null){
                    q.offerFirst(root.getRight());
                }
                if(root.getLeft() != null){
                    q.offerFirst(root.getLeft());
                }
                root = q.peekLast();
            }
        }
    }
	
	private static void spiralWithTwoStack(BTree root){
		Stack<BTree> s1 = new Stack<>();
		Stack<BTree> s2 = new Stack<>();
		s1.push(root);
		while(!s1.isEmpty() || !s2.isEmpty()){
			while(!s1.isEmpty()){
				root=s1.pop();
				System.out.print(root.getData()+ " ");
				if(root.getLeft()!=null)
					s2.push(root.getLeft());
				if(root.getRight()!=null)
					s2.push(root.getRight());
			}
			while(!s2.isEmpty()){
				root=s2.pop();
				System.out.print(root.getData()+ " ");
				if(root.getRight()!=null)
					s1.push(root.getRight());
				if(root.getLeft()!=null)
					s1.push(root.getLeft());
			}
		}
	}

}
