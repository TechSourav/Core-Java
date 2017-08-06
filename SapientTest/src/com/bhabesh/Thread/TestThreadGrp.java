package com.bhabesh.Thread;

public class TestThreadGrp {
	
	public static void main(String[] rags){
		System.out.println(Thread.currentThread().getThreadGroup().getName());
		System.out.println(Thread.currentThread().getThreadGroup().getParent());
	}

}
