package com.ravi.ds.java.DivideAndConqure;

public class NutsAndBoltsProblem {

	public static void main(String[] args) {
		char[] nuts = { '@', '#', '$', '%', '&' };
		char[] bolts = { '$', '#', '@', '&', '%' };
		NutsAndBoltsProblem nbp = new NutsAndBoltsProblem();
		nbp.matchNutsAndBolts(nuts, bolts, 0, nuts.length - 1);
		nbp.printArray(nuts, 5);
		nbp.printArray(bolts, 5);
	}

	private void matchNutsAndBolts(char[] nuts, char[] bolts, int start, int end) {
		if (start < end) {
			int pivot = partition(nuts, start, end, bolts[end]);
			partition(bolts, start, end, nuts[pivot]);
			matchNutsAndBolts(nuts, bolts, start, pivot - 1);
			matchNutsAndBolts(nuts, bolts, pivot + 1, end);
		}
	}

	private int partition(char[] nuts, int start, int end, char pivot) {
       while(start<end){
    	   while(nuts[start]<pivot){
    		   start++;
    	   }
    	   while(nuts[end]>pivot){
    		   end--;
    	   }
    	   if(start<end){
    		   char temp = nuts[start];
    		   nuts[start]=nuts[end];
    		   nuts[end]=temp;
    	   }
       }
       nuts[start]=nuts[end];
       nuts[end]=pivot;
       return end;
	}
	
	private void printArray(char[] arr, int n){
		System.out.println();
		for(int index = 0; index < arr.length; index++)
			System.out.print(arr[index]+" ");
	}

}
