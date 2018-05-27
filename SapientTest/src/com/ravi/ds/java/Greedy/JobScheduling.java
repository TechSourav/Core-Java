package com.ravi.ds.java.Greedy;

import java.util.Arrays;

class Job{
	int deadline;
	int profit;
	char id;
}

public class JobScheduling {

	public static void main(String[] args) {
		
		char[] ch= {'1','2','3','4','5','6'};
		int[] dead={5,3,3,2,4,2};
		int[] profit={200,180,190,300,120,100};
		int n=6;
		Job[] job = new Job[n];
		for(int i=0;i<n;i++){
			job[i]= new Job();
			job[i].id=ch[i];
			job[i].deadline=dead[i];
			job[i].profit=profit[i];
		}
        boolean[] b = new boolean[n];
        char[] res= new char[n];
        Arrays.sort(job, (x,y)-> -(x.profit - y.profit));
        printArray(job);
        for(int i=0;i<n;i++){
        	for(int j=(n-1);j>=0;j--){
        		if(!(job[i].deadline<j)){
        			if(!b[j]){
        			    b[j]=true;
        				res[j]=job[i].id;
        				break;
        			}
        		}
        	}
        }
        printArray(res);
	}
	
	private static void printArray(Job[] job){
		for(Job j: job){
			System.out.print(j.profit+ " ");
		}	
	}
	
	private static void printArray(char[] id){
		System.out.println("Job Sequence: ");
		for(char j: id){
			System.out.print(j+ " ");
		}	
	}

}
