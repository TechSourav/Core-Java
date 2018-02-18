package com.ravi.ds.java.Greedy;

import java.util.Arrays;

import com.sourav.java.SortingSearching.TestQuickSort;

class Sack{
	int profit;
	int weight;
}

public class KnapSackProblem {

	public static void main(String[] args) {
		int[] p= {2,28,25,18,9};
		int[] w= {1,4,5,3,3};
		int finalSack = 15;
		int n =5;
		int totalProfit=0;
		Sack s[]= new Sack[n];
		for(int i=0;i<n;i++) {
			s[i]=new Sack();
			s[i].profit=p[i];
			s[i].weight=w[i];
		}
		Arrays.sort(s, (x,y)-> -((x.profit/x.weight) - (y.profit/y.weight)));
		System.out.println(".. After Sort..." + Arrays.asList(s));
		for(int i=0;i<n;i++) {
			Sack x= s[i];
			if(finalSack>0 && x.weight<finalSack) {
				finalSack -=x.weight;
				totalProfit= totalProfit+x.profit;
			}else if(finalSack>0) {
				totalProfit= totalProfit+ x.profit*(finalSack/x.weight);
				break;
			}
		}
		System.out.println("Total Profit: " + totalProfit);
	}
	
}
