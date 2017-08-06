package com.sourav.mock.Thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankaccountForLiveLock {
	
	public static void main(String[] args){
		
		final BAccount souceAccount = new BAccount(1,500d);
		final BAccount destinationAccount = new BAccount(2,500d);
		
		new Thread(new TransferableAmount(souceAccount,destinationAccount,10d),"Thread - 1").start();
		new Thread(new TransferableAmount(destinationAccount,souceAccount,10d),"Thread - 2").start();
		
	}

}

class TransferableAmount implements  Runnable{

	private BAccount sourceAccount, destinationAccount;
    private double amount;
 
    TransferableAmount(BAccount sourceAccount, BAccount destinationAccount, double amount) {
        this.sourceAccount = sourceAccount;
        this.destinationAccount = destinationAccount;
        this.amount = amount;
    }
	
	@Override
	public void run() {
	 
		while(!sourceAccount.transfer(destinationAccount, amount))
			  continue;
		System.out.printf("%s completed ", Thread.currentThread().getName());
	}
	
}

class BAccount{
	private double balance;
	private int id;
	Lock lock = new ReentrantLock();
	
	BAccount(int id, double val){
		this.id = id;
        this.balance = balance;
	}
	
	public boolean withdraw(double amount){
		if(this.lock.tryLock()){
			try {
				Thread.sleep(2000);
				balance -=amount;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
		}
		System.out.println("Withdraw in " + Thread.currentThread().getName());
	return false;
		
	}
	
	public boolean deposit(double amount){
		if(this.lock.tryLock()){
			try {
				Thread.sleep(2000);
				balance +=amount;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
		}
		System.out.println("Deposit in " + Thread.currentThread().getName()+ "due to unsuccessful withdrawal attempt");
	return false;
		
	}
	
	public boolean transfer(BAccount destinationAcc, double amt){
		if(this.withdraw(amt)){
			if(destinationAcc.deposit(amt)){
				System.out.println("Disposal successful");
				return true;
			}else{
				this.deposit(amt);
				System.out.println("WithDraw Unsuccessful");
			}
		}
		
		return false;
	}
	
}