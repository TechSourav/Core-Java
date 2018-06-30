package com.ravi.ds.java.DivideAndConqure;

import java.util.Arrays;

public class ShuffleArray {

	public static void main(String[] args) {
		int[] arr = { 1, 3, 5, 7, 2, 4, 6, 8 };
		// ShuffleArray s = new ShuffleArray();
		suffleArray(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}

	private static void suffleArray(int[] arr, int left, int right) {

		if (right - left == 1)
			return;

		int mid = (left + right) / 2;

		int temp = mid + 1;

		int left_mid = (left + mid) / 2;

		for (int i = left_mid + 1; i <= mid; i++) {
			int temp1 = arr[i];
			arr[i] = arr[temp];
			arr[temp++] = temp1;
		}

		suffleArray(arr, left, mid);

		suffleArray(arr, mid + 1, right);
	}

}
