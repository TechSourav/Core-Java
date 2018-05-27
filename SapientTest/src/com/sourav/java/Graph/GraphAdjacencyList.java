package com.sourav.java.Graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class GraphAdjacencyList {
	
	public int V;
	public LinkedList<Integer> adj[];
	
	GraphAdjacencyList(int v){
		V=v;
		adj=new LinkedList[v];
		for(int i=0;i<v;i++) {
			adj[i]=new LinkedList<>();
		}
	}
	
	public void addEdge(int v, int w) {
		adj[v].add(w);
	}
	
	public void BFS(int v) {
		int u=v;
		boolean[] visited= new boolean[V];
		// Create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<Integer>();
        visited[u]=true;
        queue.offer(u);
        while(!queue.isEmpty()) {
        	// Dequeue a vertex from queue and print it
            u = queue.poll();
            System.out.print(u+" ");
            Iterator<Integer> it = adj[u].listIterator();
            while(it.hasNext()) {
            	int n=it.next();
            	if(!visited[n]) {
            		visited[n]=true;
            		queue.offer(n);
            	}
            }
        }
	}
	
	private void DFS(int v) {
		Stack<Integer> s = new Stack<>();
		s.push(v);
		boolean visited[] = new boolean[V];
		//visited[v] = true;
		while (!s.isEmpty()) {
			int n = s.pop();
			if (!visited[n]) {
				System.out.print(n + " ");
				visited[n]=true;
				Iterator<Integer> it = adj[n].listIterator();
				while (it.hasNext()) {
					int x=it.next();
					if (!visited[x])
						s.push(x);
				}
			}
		}
	}

	public static void main(String[] args) {
		GraphAdjacencyList g1 = new GraphAdjacencyList(4);
		g1.addEdge(0, 1);
		g1.addEdge(0, 2);
		g1.addEdge(1, 2);
		g1.addEdge(2, 0);
		g1.addEdge(2, 3);
		g1.addEdge(3, 3);
		
		System.out.println("Following is Breadth First Traversal "+
                "(starting from vertex 2)");

		g1.BFS(2);
		System.out.println("");
		System.out.println("*****************************************************************************************");
		
		GraphAdjacencyList g2 = new GraphAdjacencyList(5);
		g2.addEdge(1, 0);
        g2.addEdge(0, 2);
        g2.addEdge(2, 1);
        g2.addEdge(0, 3);
        g2.addEdge(1, 4);
		
		System.out.println("Following is Depth First Traversal "+
                "(starting from vertex 2)");

		g2.DFS(0);
		
	}

}
