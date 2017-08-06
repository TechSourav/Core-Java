package com.bhabesh.Thread;


public class ThreadExample2 {

    public static void main(String[] args) throws InterruptedException{

        ThreadChild2 lockingObj = new ThreadChild2();
        lockingObj .start();
        synchronized(lockingObj ){
            for(int i=1;i<10;i++){
                System.out.println("Main "+i);
            }
            while(!lockingObj.iWasNotified){
            	lockingObj.wait();
            }
            System.out.println("Main got notified");

        }

    }

}

class ThreadChild2 extends Thread{
	public boolean iWasNotified=false;
    public void run(){
        synchronized(this){
            for(int i=1;i<10;i++){
                System.out.println("Child "+i);
            }
            iWasNotified=true;
            this.notify();
         }
    }
}