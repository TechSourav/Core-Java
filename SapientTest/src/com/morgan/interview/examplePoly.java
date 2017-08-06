package com.morgan.interview;

public class examplePoly {

	public static void main(String[] args) {
		
		Bank b1 = new Bank();
		Bank b2 = new Morgan();
		b1.openAccount();
		b1.openAccount("Stanley");
		b2.openAccount();

	}

}

class Bank{
	
	public void openAccount(){
		System.out.println("Account Opened");
	}
	
	public void openAccount(String bName){
		System.out.println("Account Opened" + bName);
	}
}

class Morgan extends Bank{

	public void openAccount(){
		System.out.println("Account Opened in Morgan.");
	}
	
}


