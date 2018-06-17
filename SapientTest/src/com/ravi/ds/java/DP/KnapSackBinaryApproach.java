package com.ravi.ds.java.DP;

public class KnapSackBinaryApproach {

	public static void main(String[] args) {
		int[] w = {1,2,4};
		int[] p = {10,12,28};
		int n=p.length;
		int capa =6;
		int[][] T = new int[n+1][capa+1];
		for(int i=0; i<=n;i++){
			for(int j=0;j<=capa;j++){
				if(i==0 || j==0){
					T[i][j]=0;
				}else if(w[i-1]<=j){
					T[i][j]=Math.max((p[i-1]+T[i-1][j-w[i-1]]), T[i-1][j]);
				}else{
					T[i][j]= T[i-1][j];
				}	
			}
		}
		System.out.println("Capa - "+ T[n][capa]);
	}

}
