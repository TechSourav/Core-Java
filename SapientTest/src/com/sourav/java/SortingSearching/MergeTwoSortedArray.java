package com.sourav.java.SortingSearching;

public class MergeTwoSortedArray {

	public static void main(String[] args) {
	   int[] arr1= {2,5,9,10,12};
	   int[] arr2= {40,38,32,25,22,18,15};
	   int[] finalArr = new int[arr1.length+arr2.length];
	   mergeArr(arr1,arr2,finalArr);
       
	}
	
	public static void mergeArr(int[] arr1,int[] arr2,int[] finalArr){
		int i=0;
		int j=arr2.length-1;
		int[] temp=new int[finalArr.length];
		int k=0;
		
		while(i<arr1.length && j>=0){
			if(arr1[i]<arr2[j]){
				temp[k]=arr1[i++];
				k++;
			}else{
				temp[k]=arr1[j--];
				k++;
			}
		}
		if(i==arr1.length){
			for(int m=j;m>=0;m--){
				temp[k++]=arr2[m];
			}
		}
		if(j==0){
			for(int x=i;x<arr1.length;x++){
				temp[k++]=arr1[x];
			}
		}
		
		for(int y=0;y<temp.length;y++){
			finalArr[y]=temp[y];
			System.out.print(finalArr[y] + " ");
		}
	}

}
