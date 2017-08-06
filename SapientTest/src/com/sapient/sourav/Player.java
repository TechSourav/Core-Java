package com.sapient.sourav;

public class Player {
	
	private static String changegame ="Sourav ganguly is a cricketer";
	
	private int X;
	private int Y;
	
	Player(int x, int y){
		this.X=x;
		this.Y=y;
	}
	
	public void move(){
		X++;
		Y++;
	}
	
	public static void chnage(){
		System.out.println("Sachin");
	}

	public String toString(){
		return String.format("Game: %s, X : %d, Y: %d ", changegame, X, Y);
	}
}

class Footballer extends Player{

	private static String changegame="inside Footballer";
	
	Footballer(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	
	public static void chnage(){
		System.out.println("SOurav");
	}
	
	public String toString(){
		return String.format("Game:", changegame);
	}
	
}
