package com.sourav.custom.DS;

public class MySingleLinkedList {

	public static void main(String[] args) {
		

	}

}

class SLLNode {
	int data;
	SLLNode next;
	
	SLLNode(int val){
		this.data=val;
		this.next=null;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public SLLNode getNext() {
		return next;
	}

	public void setNext(SLLNode next) {
		this.next = next;
	}
	
}

class SingleLinkedList{
	
	SLLNode start;
	SLLNode end;
	int size;
	
	public void insertAtEnd(int val){
	SLLNode node = new SLLNode(val);
	size++;	
	if(start==null){
			start=node;
			end= start;
		}else{
			end.setNext(node);
			end=node;
		}
	
	}
	
	public void insertAtStart(int val){
		SLLNode node = new SLLNode(val);
		size++;
			if(start==null){
				start=node;
				end= start;
			}else{
				node.setNext(start);
				start=node;
			}
		
		}
	
	public void insertAtPosition(int val,int pos){
		SLLNode node = new SLLNode(val);
		pos=pos-1;
		
	}
	
}


