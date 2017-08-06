package com.sapient.sourav.thread;

import java.util.concurrent.Exchanger;

public class ExcngrDemo {
	
	public static void main(String[] args){
		Exchanger<String> ex = new Exchanger<String>();
		
		new MakeString(ex);
		new UseString(ex);
	}

}

class MakeString implements Runnable{
	Exchanger<String> ex;
	String str;
	MakeString(Exchanger<String> ex){
		this.ex=ex;
		str=new String();
		new Thread(this).start();
	}

	@Override
	public void run() {
	  char ch='A';
	  for(int i=0;i<3;i++){
		for(int j=0;j<5;j++){
				str+=(char)ch++;
			}
		try {
			ex.exchange(str);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
	}
	
}

class UseString implements Runnable{
	Exchanger<String> ex;
	String str;
	UseString(Exchanger<String> c){
		this.ex=c;
		new Thread(this).start();
	}

	@Override
	public void run() {
	 for(int i=0;i<3;i++){
		 try {
			str=ex.exchange(new String());
			System.out.println("GOT: "+ str);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
		
	}
	
}
