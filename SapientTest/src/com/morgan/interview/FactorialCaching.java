package com.morgan.interview;

import java.util.Scanner;

public class FactorialCaching {
	
	public static long[] factorial = new long[21];
	
	 public static int fact = 0;
	 
	 static { 
		  factorial[0] = 1; 
		 }
	
	public static long factorial(int x) {
		 
		  // fact goes from zero to number-1 for which we want to 
		  // calculate the factorial
		
		if(fact==0 && fact<x){
			  while(fact < x) {
			 
			   // applying formula as 3! = 3 * 2!
			   factorial[fact + 1] = factorial[fact] * (fact + 1);
			 
			   // increment the fact for next value
			   fact++;
			  }
			 
			  // return the result
			  return factorial[x];
		}else if(fact!=0){
			
			while(fact<x){
				
				factorial[fact+1]= factorial[fact] * (fact+1);
				fact++;						
			}
			return factorial[x];
		}
		return factorial[x];
	 }

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the number for which you " + "want to calculate factorial -  ");
		System.out.println("Note : \"The number should range " + "from 0 to 20\"");
		int number = scanner.nextInt();
		long result = FactorialCaching.factorial(number);
		 
		 System.out.println("The factorial of "+ number +" : " + result);
		 
		  System.out.println();
		  System.out.println("Enter the another number for which you " + "want to calculate factorial -  ");
		 
		  // prompting the user to enter number between 0 to 20 
		  System.out.println("Note : \"The number should range " + "from 0 to "+number+"\"");
		 
		  // store the number entered into number variable
		 int  newNumber = scanner.nextInt();
		 long newResult=0;
		  if(newNumber>number){
			  newResult=FactorialCaching.factorial(newNumber);
		  }else{
			  newResult=FactorialCaching.factorial[newNumber];
		  }
		  // After first call to factorial method next time 
		  // we just access the factorial by accessing the 
		  // long array through index
		 
		
		 
		  System.out.println("The factorial after caching is done : "
		    +  newResult);
        }

}
