package com.sourav.java.Graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSort {

	public static void main(String[] args) {
		Graph g = new Graph(6);
		g.addEdge(5, 2);
		g.addEdge(5, 0);
		g.addEdge(4, 0);
		g.addEdge(4, 1);
		g.addEdge(2, 3);
		g.addEdge(3, 1);
		System.out.println("After Topological sort:");
		TopologicalSort s = new TopologicalSort();
		s.topologicalSort(g);
	}
	
	private void topologicalSort(Graph g) {
		int[] arrIndegree=new int[g.V];
		for(int i=0; i<g.V;i++) {
			Iterator<Integer> it = g.adj[i].listIterator();
			while(it.hasNext()) {
				arrIndegree[it.next()]++;
			}
		}
		Queue<Integer> q = new LinkedList<>();
		for(int j=0;j<g.V;j++) {
			if(arrIndegree[j]==0) {
				q.offer(j);
			}
		}
		while(!q.isEmpty()) {
			int n=q.poll();
			System.out.print(n+ " ");
			Iterator<Integer> it1 = g.adj[n].listIterator();
			while(it1.hasNext()) {
				int x=it1.next();
				if(--arrIndegree[x]==0) {
					q.offer(x);
				}
			}
		}
	}

}
