package com.sourav.java.Graph;

import java.util.LinkedList;
import java.util.Queue;

public class Graph2 {
	
	int maxVertices= 20;
	boolean visited[]= new boolean[maxVertices];
	int adj[][];
	//int verticesList[]= new int[maxVertices];

	Graph2() {
		adj = new int[maxVertices][maxVertices];
		
		for(int i=0;i<maxVertices;i++) {
			visited[i]=false;
			for(int j=0;j<maxVertices;j++)
				adj[i][j]=0;
		}
	}
	
	public void addEdge(int start, int end) {
		adj[start][end]=1;
		adj[end][start]=1;
	}
	
	private int getUnvisitedvertex(int u) {
		for(int i=0;i<maxVertices;i++) {
			if(adj[u][i]==1 && !visited[i]) {
				return i;
			}
		}
		return -1;
	}
	
	public void BFS(Graph2 g, int x) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(x);
		visited[x]=true;
		while (!q.isEmpty()) {
			int v = q.poll();
			System.out.println(v);
			int w;
			while ((w = getUnvisitedvertex(v)) != -1) {
				visited[w] = true;
				q.offer(w);
			}
		}
	}
	
	public static void main(String[] args) {
		Graph2 g1 = new Graph2();
		g1.addEdge(0, 1);
		g1.addEdge(0, 2);
		g1.addEdge(1, 2);
		g1.addEdge(2, 0);
		g1.addEdge(2, 3);
		g1.addEdge(3, 3);
		g1.BFS(g1, 2);
	}
}
