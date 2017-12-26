package com.sourav.java.Thread;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ForkJoinPool;

public class ForkJoinTest {

	  public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);
	    
	    int totalNumbers = scanner.nextInt();
	    
	    int[] numbers = new int[totalNumbers];
	    
	    for (int i = 0; i < totalNumbers; i++) {
	      numbers[i] = scanner.nextInt();
	    }
	    
	    System.out.println("Unsorted array: " 
	         + Arrays.toString(numbers));

	    DivideTask task = new DivideTask(numbers);
	    ForkJoinPool forkJoinPool = new ForkJoinPool(10);
	    forkJoinPool.invoke(task);
	    
	    System.out.println("Sorted array: " 
	         + Arrays.toString(task.join()));

	  }
	}
