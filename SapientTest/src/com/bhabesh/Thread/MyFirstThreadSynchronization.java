package com.bhabesh.Thread;

public class MyFirstThreadSynchronization extends Thread{
	
	Display dis;
	String name;
	
	MyFirstThreadSynchronization(Display d, String n){
		this.dis=d;
		this.name=n;
	}
	
	public void run(){
		dis.show(name);
	}

}
