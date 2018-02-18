package com.ravi.ds.java.Greedy;

import java.util.PriorityQueue;

public class KruskalAlgo {

	public static void main(String[] args) {
		int cost[][] = new int[][] {{0, 2, 0, 6, 0},
									{2, 0, 3, 8, 5},
									{0, 3, 0, 0, 7},
									{6, 8, 0, 0, 9},
									{0, 5, 7, 9, 0},
			   					   };
	    KruskalAlgo k = new KruskalAlgo();
	    k.kruskalMst(cost);
			   					   
	}
	
	private void kruskalMst(int[][] cost) {
		PriorityQueue<Integer> q=new PriorityQueue<>((x,y)-> (x-y));
		for(int i=0;i<Integer.MAX_VALUE; i++) {
			q.
		}
	}

}
