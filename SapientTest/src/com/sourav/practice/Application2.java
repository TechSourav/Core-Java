package com.sourav.practice;

public class Application2 {

	public static void main(String[] args) throws InterruptedException {
		/*
		 * Sourav s= new Sourav(); Kundu k = new Kundu(); s.start(); k.start();
		 */

		Sourav s = new Sourav();
		Kundu k = new Kundu();
		Thread t1 = new Thread(s, "Sourav");
		Thread t2 = new Thread(s, "Kundu");
		t1.start();
		t1.join(12000);
		t2.start();
		
	}

}

/*
 * class Sourav extends Thread{
 * 
 * Sourav(){ System.out.println(Thread.currentThread().getName());
 * Thread.currentThread().setName("Sourav"); }
 * 
 * public void run(){ try { Thread.sleep(1000); } catch (InterruptedException e)
 * { // TODO Auto-generated catch block e.printStackTrace(); }
 * System.out.println(Thread.currentThread().getName()); }
 * 
 * }
 * 
 * class Kundu extends Thread{
 * 
 * Kundu(){ System.out.println(Thread.currentThread().getName());
 * Thread.currentThread().setName("Kundu"); }
 * 
 * public void run(){ try { Thread.sleep(1000); } catch (InterruptedException e)
 * { // TODO Auto-generated catch block e.printStackTrace(); }
 * System.out.println(Thread.currentThread().getName()); } }
 */

class Sourav implements Runnable {

	//public static Thread sourav;
	
	public void run() {
		System.out.println(Thread.currentThread().getName());
		for(int i=0;i<5;i++){
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("Value: " +Thread.currentThread().getName() +" : "+i);
		}
	}

}

class Kundu implements Runnable {

	public void run() {
		
		System.out.println(Thread.currentThread().getName());
		//Sourav.sourav=Thread.currentThread();
		
		for(int i=0;i<5;i++){
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Value: " +Thread.currentThread().getName()+" : " +i);
		}
		
	}
}
