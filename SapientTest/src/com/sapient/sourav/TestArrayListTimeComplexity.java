package com.sapient.sourav;

public class TestArrayListTimeComplexity {
	
     public static void main(String[] args) {
	              String[] list = new String[100000];
	              for(int i = 0; i < 100000; i ++){
	                     list[i] = "A" + i;
	              }
	             
	              long nanoDiff = 0, nanoAvg = 0;
	             
	             
	              for(int i = 0; i < 100000; i ++){
	                     long starty = System.nanoTime();
	                     nanoDiff = System.nanoTime() - starty;
	                     nanoAvg += nanoDiff;
	              }
	             
	              nanoAvg = nanoAvg/100000;
	              System.out.println("Ave Nano Diff " + nanoAvg);
	              nanoAvg = 0;
	              int times = 0;
	              for(int i = 0; i < 100000; i = i +20){
	                     long starty = System.nanoTime();
	                     nanoDiff = System.nanoTime() - starty;
	                     nanoAvg += nanoDiff;
	                     times++;
	              }
	              nanoAvg = nanoAvg / times;
	             
	              System.out.println("Ave Nano Diff " + nanoAvg);
	       }
	 
	}