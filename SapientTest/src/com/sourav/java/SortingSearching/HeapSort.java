package com.sourav.java.SortingSearching;

import java.util.Arrays;

public class HeapSort {

	public static void main(String[] args) {

		int arr[] = { 12, 11, 13, 5, 6, 7 };
		int n = arr.length;
		HeapSort heap = new HeapSort();
		System.out.println("before Sort: " + Arrays.toString(arr));
		heap.sort(arr);
		System.out.println("After sort: " + Arrays.toString(arr));
		
		System.out.println("Insert key into heap");
		heap.insertKey(8);
	}

	private void sort(int[] arr) {
		System.out.println("Before Heapify: " + Arrays.toString(arr));
		// 1. build max heap
		buildMaxHeap(arr);
		// 2. exchange and recursively call heapify
		for (int j = arr.length - 1; j >= 0; j--) {
			int swap = arr[j];
			arr[j] = arr[0];
			arr[0] = swap;
			heapify(arr, j, 0);
		}
		System.out.println("After Heapify: " + Arrays.toString(arr));
	}
	
	private void insertKey(int key) {
		
	}

	private void buildMaxHeap(int[] arr) {
		for (int i = arr.length / 2 - 1; i >= 0; i--) {
			heapify(arr, arr.length, i);
		}
	}

	private void heapify(int[] arr, int n, int i) {
		int l = 2 * i + 1;
		int r = 2 * i + 2;
		int largest = i;
		if (l < n && arr[l] > arr[largest]) {
			largest = l;
		}
		if (r < n && arr[r] > arr[largest]) {
			largest = r;
		}

		if (largest != i) {
			int temp = arr[largest];
			arr[largest] = arr[i];
			arr[i] = temp;
			heapify(arr, n, largest);
		}

	}

}
