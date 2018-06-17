package com.ravi.ds.java.DP;

public class LongestPalindromeSubString {

	public static void main(String[] args) {
		String str = "EMADAMZ";
		int j = 0;
		char[] arr = str.toCharArray();
		boolean[][] lps = new boolean[str.length()][str.length()];
		for (int i = 0; i < arr.length; i++) {
			lps[i][i] = false;
		}
		for (int ls = 2; ls <= str.length(); ls++) {
			for (int k = 0; k < arr.length - ls + 1; k++) {
				j = k + ls - 1;
				if (arr[k] == arr[j]) {
					lps[k][j] = true;
				} else {
					lps[k][j] = false;
				}
			}
		}
		for (int m = 0; m < arr.length; m++) {
			for(int n = 0; n<arr.length; n++){
				if(lps[m][n]){
					System.out.println(m + " , " + n);
				}	
			}
		}
	}

}
