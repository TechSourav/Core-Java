package com.sapient.sourav;

public class TestGame {
	
	public static void main(String[] args){
		
		Player pl1 = new Player(11,12);
		Player pl2 = new Player(21,22);
		
		Player pl = new Footballer(10,15);
		
		Footballer ft = new Footballer(4,8);
       
		pl.chnage();
		ft.chnage();
		
		
		
		/*System.out.println("Pl1: "+ pl1);
		System.out.println("Pl2: "+ pl2);
		
		pl1.move();
		System.out.println("Pl1: "+ pl1);
		System.out.println("Pl2: "+ pl2);
		
		pl2.chnage();
		
		System.out.println("Pl1: "+ pl1);
		System.out.println("Pl2: "+ pl2);*/
	
	}

}
