package com.sourav.java.Thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestReentrant {

	public static void main(String[] args) {
		ReentrantTest rt = new ReentrantTest();
		Theadxyz tx =  new Theadxyz(rt);
		Theadxyz tx2 =  new Theadxyz(rt);
		System.out.println("Hi");
		tx.start();
		tx2.start();

	}

}

class Theadxyz extends Thread{
	ReentrantTest rt;
	Theadxyz(ReentrantTest r){
		this.rt=r;
	}
	
	
	public void run(){
		rt.outer();
	}
	
}

class ReentrantTest {
	
	Lock l = new ReentrantLock();
	
	public void outer(){
		l.lock();
		System.out.println("Outer");
		inner();
		l.unlock();
	}
	
	public synchronized void inner(){
		l.lock();
		System.out.println("inner");
		l.unlock();
	}
	
}
