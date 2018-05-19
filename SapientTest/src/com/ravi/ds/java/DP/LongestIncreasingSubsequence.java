package com.ravi.ds.java.DP;

public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		int[] arr = { 2, 3, 1, 5, 12, 10, 11 };
		findLongestIncreasingSubSeq(arr);
		findLongestDecreasingSubSeq(arr);
	}

	private static void findLongestIncreasingSubSeq(int[] arr) {
		int[] lis = new int[arr.length];
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			lis[i] = 1;
		}
		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j] && lis[i] < lis[j] + 1) {
					lis[i] = lis[j] + 1;
				}
			}
		}
		for (int k = 0; k < arr.length; k++) {
			if (max < lis[k]) {
				max = lis[k];
			}
		}
		System.out.println("LongestIncreasingSubSeq length: " + max);
	}

	private static void findLongestDecreasingSubSeq(int[] arr1) {
		int[] arr = { 10, 8, 12, 7, 20, 13, 5, 21 };
		int[] lis = new int[arr.length];
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			lis[i] = 1;
		}
		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] < arr[j] && lis[i] < lis[j] + 1) {
					lis[i] = lis[j] + 1;
				}
			}
		}
		for (int k = 0; k < arr.length; k++) {
			if (max < lis[k]) {
				max = lis[k];
			}
		}
		System.out.println("LongestIncreasingSubSeq length: " + max);
	}

}
