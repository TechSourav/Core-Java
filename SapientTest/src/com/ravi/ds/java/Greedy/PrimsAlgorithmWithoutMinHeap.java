package com.ravi.ds.java.Greedy;

public class PrimsAlgorithmWithoutMinHeap {
	private static final int  V =5;   						   
    
	public static void main(String[] args) {
		int cost[][] = new int[][] {{0, 2, 0, 6, 0},
									{2, 0, 3, 8, 5},
									{0, 3, 0, 0, 7},
									{6, 8, 0, 0, 9},
									{0, 5, 7, 9, 0},
           						   };
        
        PrimsAlgorithmWithoutMinHeap algo = new PrimsAlgorithmWithoutMinHeap();
        algo.primMST(cost);

	}
	
	private void primMST(int graph[][])
    {
        // Array to store constructed MST
        int parent[] = new int[V];
 
        // Key values used to pick minimum weight edge in cut
        int key[] = new int [V];
 
        // To represent set of vertices not yet included in MST
        Boolean mstSet[] = new Boolean[V];
 
        // Initialize all keys as INFINITE
        for (int i = 0; i < V; i++)
        {
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }
 
        // Always include first 1st vertex in MST.
        key[0] = 0;     // Make key 0 so that this vertex is
                        // picked as first vertex
        parent[0] = -1; // First node is always root of MST
 
        // The MST will have V vertices
        for (int count = 0; count < V-1; count++)
        {
            // Pick thd minimum key vertex from the set of vertices
            // not yet included in MST
            int u = minKey(key, mstSet);
 
            // Add the picked vertex to the MST Set
            mstSet[u] = true;
 
            // Update key value and parent index of the adjacent
            // vertices of the picked vertex. Consider only those
            // vertices which are not yet included in MST
            for (int v = 0; v < V; v++)
 
                // graph[u][v] is non zero only for adjacent vertices of m
                // mstSet[v] is false for vertices not yet included in MST
                // Update the key only if graph[u][v] is smaller than key[v]
                if (graph[u][v]!=0 && mstSet[v] == false &&
                    graph[u][v] <  key[v])
                {
                    parent[v]  = u;
                    key[v] = graph[u][v];
                }
        }
 
        // print the constructed MST
        printMST(parent, V, graph);
    }
	
	
	int minKey(int key[], Boolean mstSet[])
    {
        // Initialize min value
        int min = Integer.MAX_VALUE, min_index=-1;
 
        for (int v = 0; v < V; v++)
            if (mstSet[v] == false && key[v] < min)
            {
                min = key[v];
                min_index = v;
            }
 
        return min_index;
    }
	
	void printMST(int parent[], int n, int graph[][])
    {
        System.out.println("Edge   Weight");
        for (int i = 1; i < n; i++)
            System.out.println(parent[i]+" - "+ i+"    "+
                               graph[i][parent[i]]);
    }
	
	private int getMinCostAdjacencyVertices(int cost[][], int[] arr, int[] mstSet, boolean b[], int x) {
		int minCostindex = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if (cost[x][i] > 0 && !b[i] && cost[x][i] < arr[i]) {
				arr[i] = cost[x][i];
				if(minCostindex>arr[i])
					minCostindex = i;
				mstSet[i] = x;
			}
		}
		return minCostindex;
	}	

}
