package com.sapient.sourav;

public class ThreadGroup1 {
	
	public static void main(String[] args) {
		
		ThreadGroup system = Thread.currentThread().getThreadGroup().getParent();
		Thread[] th1= new Thread[system.activeCount()];
		system.enumerate(th1);
		for(Thread th: th1){
			System.out.println(th.getName()+ " .... "+ th.isDaemon());
		}
		
	}

}
