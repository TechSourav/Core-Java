package com.ravi.ds.java.Greedy;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class HuffmanTree{
	
    int freq;
	char c;
	HuffmanTree left;
	HuffmanTree right;

}

public class HuffmanCoding {
	
	public static void printCode(HuffmanTree root, String s) {
		if (root.left
                == null
            && root.right
                   == null
            && Character.isLetter(root.c)) {
 
            // c is the character in the node
            System.out.println(root.c + ":" + s);
 
            return;
        }
 
        // if we go to left then add "0" to the code.
        // if we go to the right add"1" to the code.
 
        // recursive calls for left and
        // right sub-tree of the generated tree.
        printCode(root.left, s + "0");
        printCode(root.right, s + "1");
	}

	public static void main(String[] args) {
		
		Character[] c= {'a','b','c','d','e','f'};
		Integer[]  f= {5, 9, 12, 13, 16, 45};
		int n=6;
		List<Character> listOfCharacters= Arrays.asList(c);
		List<Integer> listOfIntegers= Arrays.asList(f);
		
		PriorityQueue<HuffmanTree> q = new PriorityQueue<HuffmanTree>(n,(x,y)-> (x.freq-y.freq));
		
		for(int i=0;i<n;i++) {
			HuffmanTree t= new HuffmanTree();
			t.c=c[i];
			t.freq=f[i];
			t.left=null;
			t.right=null;
			q.add(t);
		}
		HuffmanTree root = null;
		while(q.size()>1) {
			HuffmanTree x=q.poll();
			HuffmanTree y=q.poll();
			HuffmanTree node = new HuffmanTree();
			node.freq=x.freq+y.freq;
			node.c='-';
			node.left=x;
			node.right=y;
			root=node;
			q.add(node);
		}
		printCode(root, "");
	}

}

