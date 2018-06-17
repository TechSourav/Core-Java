package com.ravi.ds.java.DP;

public class LongestPalindromeSubSeq {

	public static void main(String[] args) {
		String str = "RAUDRAR";
		int j = 0;
		char[] arr = str.toCharArray();
		int[][] lps = new int[str.length()][str.length()];
		for (int i = 0; i < arr.length; i++) {
			lps[i][i] = 1;
		}
		for (int ls = 2; ls <= str.length(); ls++) {
			for (int k = 0; k < arr.length - ls + 1; k++) {
				j = k + ls - 1;
				if (arr[k] == arr[j] && ls == 2) {
					lps[k][j] = 2;
				} else if (arr[k] == arr[j]) {
					lps[k][j] = lps[k + 1][j - 1] + 2;
				} else {
					lps[k][j] = Math.max(lps[k][j - 1], lps[k + 1][j]);
				}
			}
		}
		System.out.println("LPS is  : " + lps[0][arr.length - 1]);
	}

}
