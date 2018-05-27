package com.sourav.java.SortingSearching;

public class TestBinarySearch {

	public static void main(String[] args) {
		int[] arr= {2,3,4,5,7,9,10,12};
		int target= 4;
		int n =arr.length;
		func(arr,n,target);
		System.out.println("With Recursion: ");
		int x=binarySearchWithRecusrion(arr,0,arr.length-1,target);
		System.out.print(x);
	}
	
	private static int binarySearchWithRecusrion(int[] arr, int l,int r,int target){
		int x=0;
		if(l>r){
			return -1;
		}
		int mid = (l+r)/2;
		if(arr[mid]==target){
			return mid;
		}else{
			if(target<arr[mid])
				x=binarySearchWithRecusrion(arr,l,mid-1,target);
			else
				x=binarySearchWithRecusrion(arr,mid+1,r,target);
		}
		return x;
	}

	public static void func(int[] arr,int n, int target){
		int l=0;
		int r=n-1;
		System.out.println(findtarget(arr,l,r,target));
	}
	
	private static int findtarget(int[] arr, int l,int r,int target){
		if(l<=r){
			int m=l+(r-l)/2;
			
			if(arr[m]==target){
				return m;
			}else if(arr[m]>target){
				return findtarget(arr, l, (m-1), target);
			}else{
				return findtarget(arr, (m+1), r, target);
			}
		}
		return -1;
	}
}
