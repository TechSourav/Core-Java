package org.sourav.Multithreading.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class MyThreeThreadSequence {
	
	public static void main(String[] args){
		
		Scanner scan = new Scanner(	System.in);	
		System.out.println("How many you want to insert for first Array?");
		int noOfElementsForFirstArray=scan.nextInt();
		List array1 = new ArrayList(noOfElementsForFirstArray);
		System.out.println("How many you want to insert for second Array?");
		int noOfElementsForSecondArray=scan.nextInt();
		List array2 = new ArrayList(noOfElementsForSecondArray);
		System.out.println("How many you want to insert for third Array?");
		int noOfElementsForThirdArray=scan.nextInt();
		List array3 = new ArrayList(noOfElementsForThirdArray);
		
		//System.out.println("Enter how many elements for first Array?");
		
		System.out.println("Enter elements for first Array");
		for(int i=0;i<noOfElementsForFirstArray;i++){
			array1.add(scan.nextInt());
		}
		
		//System.out.println("Enter how many elements for second Array?");
		
		System.out.println("Enter elements for second Array");
		for(int i=0;i<noOfElementsForSecondArray;i++){
			array2.add(scan.nextInt());
		}
		
		//System.out.println("Enter how many elements for third Array?");
		
		System.out.println("Enter elements for thiird Array");
		for(int i=0;i<noOfElementsForThirdArray;i++){
			array3.add(scan.nextInt());
		}
		
		Semaphore secTH3 = new Semaphore(0);
		Semaphore secTH2 = new Semaphore(0);
		Semaphore secTH1 = new Semaphore(1);
		
		SharedQ sq = new SharedQ();
		
		
		SeqThread th1 = new SeqThread(sq,array1,secTH1,secTH2);
		SeqThread th2 = new SeqThread(sq,array2,secTH2,secTH3);
		SeqThread th3 = new SeqThread(sq,array3,secTH3,secTH1);
		
		th1.start();
		th2.start();
		th3.start();
		
	}

}

class SharedQ{
	
	public void runThread1(List num,Semaphore semThX,Semaphore semThY){

		for(int i=0;i<num.size();i++){
		try {
			semThX.acquire();
			Thread.sleep(50);
			System.out.println("Thread "+ Thread.currentThread().getName()   + " ---- >> "+ num.get(i) );
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		semThY.release();
		}
		
	}
	
}


class SeqThread extends Thread{
	
	SharedQ q;
	List arr;
	Semaphore semThX;
	Semaphore semThY;
	
	SeqThread(SharedQ q, List arr,Semaphore semThX,Semaphore semThY){
		this.q=q;
		this.arr=arr;
		this.semThX=semThX;
		this.semThY=semThY;
	}
	
	public void run(){
		
		q.runThread1(arr,semThX,semThY);
			
	}
	
}