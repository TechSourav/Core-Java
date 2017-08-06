package com.pck.thread.exercise;

public class PrintOddEvenNumbers {
	
	public static void main(String[] args){

        String s = new String("");

        EvenThread t1= new EvenThread(s);
        OddThread t2= new OddThread(s);
        Thread th1 = new Thread(t1);
        Thread th2 = new Thread(t2);
        th2.start();
        th1.start();
    }

}

class EvenThread implements Runnable{
    String s;
    EvenThread(String s){
        this.s= s;
    }

    @Override
    public void run() {
        
            for(int i=1;i<=10;i++){
            	synchronized(s){
                if(i%2==0){
                    System.out.println(i);
                    s.notify();
                    try {
						s.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                }
                
            }

        }
    }

}

class OddThread implements Runnable{

    String s;
    OddThread(String s){
        this.s= s;
    }

    @Override
    public void run() {
        
            for(int i=1;i<=10;i++){
                
                synchronized(s){
                if(i%2==1){
                    System.out.println(i);
                    s.notify();
                    try {
						s.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                }
               
            }
        }
    }

}
