package com.sourav.java.Queue;

public class RottenOranges {
	
	public static void main(String[] args) {
		int arr[][] =  {{2, 1, 0, 2, 1},
                		{1, 0, 1, 2, 1},
                		{1, 0, 0, 2, 1}};
			/*{{2, 1, 0, 2, 1},
			 {0, 0, 1, 2, 1},
			 {1, 0, 0, 2, 1} };*/
		RottenOranges rt = new RottenOranges();
		int i=rt.findRottenmangoes(arr, 3,5);
		if(i>0){
			System.out.println("All mangoes got rotten in: " + i);
		}else{
			System.out.println("All mangoes are fresh");
		}
		
	}
	
	private static int findRottenmangoes(int[][] arr, int m, int n){
		 int curr_time=0;	
		MyQueue q = new MyQueue();
		
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(arr[i][j]==Mango.ROTTEN.getStatus())
					q.enQueue(new MyNode(new NodeElement(i,j,curr_time)));
			}
		}
		
		while(!q.isEmpty()){
			MyNode nd= q.deQueue();
		    NodeElement e = nd.data;
		    curr_time=e.time;
		    if(e.i-1>=0 && arr[e.i-1][e.j]==Mango.FRESH.getStatus()){
		    	arr[e.i-1][e.j]=Mango.ROTTEN.getStatus();
		    	q.enQueue(new MyNode(new NodeElement((e.i-1),e.j,curr_time+1)));
		    }
		    if(e.i+1<m && arr[e.i+1][e.j]==Mango.FRESH.getStatus()){
		    	arr[e.i+1][e.j]=Mango.ROTTEN.getStatus();
		    	q.enQueue(new MyNode(new NodeElement((e.i+1),e.j,curr_time+1)));
		    }
		    if(e.j-1>=0 && arr[e.i][e.j-1]==Mango.FRESH.getStatus()){
		    	arr[e.i][e.j-1]=Mango.ROTTEN.getStatus();
		    	q.enQueue(new MyNode(new NodeElement(e.i,(e.j-1),curr_time+1)));
		    }
		    if(e.j+1<n && arr[e.i][e.j+1]==Mango.FRESH.getStatus()){
		    	arr[e.i][e.j+1]=Mango.ROTTEN.getStatus();
		    	q.enQueue(new MyNode(new NodeElement(e.i,(e.j+1),curr_time+1)));
		    }
		}
		
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(arr[i][j]==Mango.FRESH.getStatus())
					return -1;
			}
		}
		
		return curr_time;
	}

}

enum Mango{
	ROTTEN(2),
	FRESH(1);
	private int status;
	Mango(int i){
	  this.status=i;	
	}
	public int getStatus(){
	return this.status;	
	}
}

class NodeElement{
	int i;
	int j;
	int time;
	NodeElement(int i, int j , int time){
		this.i=i;this.j=j;this.time=time;
	}
	NodeElement(){
		this.i=-1;
		this.j=-1;
		this.time=-1;
	}
}

class MyQueue{
	MyNode front;
	MyNode end;
	MyQueue(){
		this.front=null;
		this.end=null;
	}
	
	public void enQueue(MyNode n){
		if(this.front==null){
			this.front=n;
			this.end=n;
		}else{
			this.end.next=n;
			this.end=n;
		}
	}
	
	public MyNode deQueue(){
		MyNode temp= null;
		if(!this.isEmpty()){
			temp=this.front;
			this.front=this.front.next;
			if(this.front==null)
				this.end=null;
		}
		return temp;
	}
	
	public boolean isEmpty(){
		if(this.front==null && this.end==null){
			return true;
		}
		return false;
	}

}

class MyNode{
	NodeElement data;
	MyNode next;
	MyNode(NodeElement v){
		this.data=v;
		this.next=null;
	}
}
