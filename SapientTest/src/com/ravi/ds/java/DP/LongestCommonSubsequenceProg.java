package com.ravi.ds.java.DP;

public class LongestCommonSubsequenceProg {

	public static void main(String[] args) {
		LongestCommonSubsequenceProg c = new LongestCommonSubsequenceProg();
		String str1 = "ABCBDAB";
        String str2 = "BDCABA";
        int i=c.computeLongestSubsequence(str1.toCharArray(),str2.toCharArray());
        System.out.println("LCS : "+ i);
	}
	
	private int computeLongestSubsequence(char[] c1, char[] c2){
		int m=c1.length;
		int n=c2.length;
		int max=0;
		int[][] temp = new int[m+1][n+1];
		
		for(int i=1;i<=m;i++){
			
			for(int j=1;j<=n;j++){
				
				if(c1[i-1]==c2[j-1]){
					temp[i][j]= 1+ temp[i-1] [j-1];
				}
				else{
					temp[i][j]= Math.max( temp[i-1][j], temp[i][j-1] );
				}
				
				if(temp[i][j]>max){
					max=temp[i][j];
				}
			}
		}
		return max;
	}

}
