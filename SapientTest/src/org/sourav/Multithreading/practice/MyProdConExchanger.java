package org.sourav.Multithreading.practice;

import java.util.concurrent.Exchanger;

public class MyProdConExchanger {

	public static void main(String[] args) {
	
		Exchanger<String> exchg = new Exchanger<String>();
		
		ProdExchanger pex = new ProdExchanger(exchg);
		ConExchanger cex = new ConExchanger(exchg);
		
		pex.start();
		cex.start();

	}

}

class ProdExchanger extends Thread{
	
	Exchanger<String> exchg;
	String nt;
	
	ProdExchanger(Exchanger<String> e){
		this.exchg=e;
		nt = new String();
	}
	
	
	public void run(){
		for(int i=0;i<5;i++){
			nt+=i;
			System.out.println("Produced: "+ nt);
			try {
				nt = exchg.exchange(nt);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
}

class ConExchanger extends Thread{
	
	Exchanger<String> exchg;
	String str;
	
	ConExchanger(Exchanger<String> e){
		this.exchg=e;
	}
	
	public void run(){
		for(int i=0;i<5;i++){
			
			try {
				str = exchg.exchange(new String());
				System.out.println("Consumed: "+ str);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
	}
}



