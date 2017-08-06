package com.sapient.sourav;

import java.util.concurrent.Exchanger;

public class PracticeExchanger {

	public static void main(String[] args) {
		
		Exchanger<String> exchngr = new Exchanger<String>();
		
		MakeString ms = new MakeString(exchngr);
		UseString us = new UseString(exchngr);
		ms.start();
		us.start();

	}

}

class UseString extends Thread{
	
	Exchanger<String> ex;
	String str;
	
	UseString(Exchanger<String> c){
		this.ex=c;
		str= new String();
	}
	
	public void run(){
		
		for(int i=0;i<3;i++){
			
			try {
				str=ex.exchange(new String());
				System.out.println("Got: " + str);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}

class MakeString extends Thread{
	
	Exchanger<String> ex;
	String str;
	
	MakeString(Exchanger<String> c){
		this.ex=c;
		str= new String();
	}
	
	public void run(){
		
		char ch ='A';
		
		for(int i =0;i<3;i++){
			
			// Fill the buffer..
			
			for(int j=0;j<5;j++){
				str+= (char)ch++;
				
			}
			
			try{System.out.println("Put: " + str);
				str=ex.exchange(str);
				
			}catch(InterruptedException excp){
				excp.printStackTrace();
			}
		}
		
	}
	
}


