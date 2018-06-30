package com.ravi.ds.java.DivideAndConqure;

public class MedianOfTwoSortedArrays 
{
	    private static final int ERROR_INVALID_INPUT = -1;  
	    
	    public int max(int a, int b)
	    {
	        if (a > b) return a;
	        return b;
	    }
	     
	    public int min(int a, int b)
	    {
	        if (a < b) return a;
	        return b;
	    }
	     
	    private double findMedian(int[] array, int startIndex, int endIndex)
	    {
	        int indexDiff = (endIndex - startIndex);
	        if (indexDiff % 2 == 0)  
	        {
	            return array[startIndex + (indexDiff/2)];
	        }
	        else
	        {
	            return (array[startIndex + (indexDiff/2)] + array[startIndex + (indexDiff/2) + 1])/2;
	        }
	    }
	    
	     
	    public double findMedianSortedArrays(int[] a, int[] b, int startIndexA, int endIndexA, int startIndexB, int endIndexB)
	    {
	       
	        if ((endIndexA - startIndexA < 0) || ((endIndexB - startIndexB < 0)))
	        {
	            System.out.println("Invalid Input." );
	            return ERROR_INVALID_INPUT;
	        }
	
	        if ((endIndexA - startIndexA == 0) && ((endIndexB - startIndexB == 0)))
	        {
	            return (a[0] + b[0])/2;
	        }
	        
	        if ((endIndexA - startIndexA == 1) && ((endIndexB - startIndexB == 1)))
	        {
	            return (max(a[startIndexA], b[startIndexB]) + min(a[endIndexA], b[endIndexB]))/2;
	        }
	         
	        double m1 = findMedian(a, startIndexA, endIndexA);
	        double m2 = findMedian(b, startIndexB, endIndexB);
	         
	        if (m2 == m1)
	        {
	            return m2;
	        }
	         
	         
	        if (m1 < m2)
	        {
	            if ((endIndexA - startIndexA) % 2 == 0)  
	            {
	                startIndexA = startIndexA + (endIndexA - startIndexA) / 2;
	                endIndexB = startIndexB + (endIndexB - startIndexB) / 2;
	            }
	            else
	            {
	                startIndexA = startIndexA + (endIndexA - startIndexA) / 2;
	                endIndexB = startIndexB + (endIndexB - startIndexB) / 2 + 1;                
	            }
	        }
	         
	         
	        else  
	        {
	            if ((endIndexB - startIndexB) % 2 == 0)  
	            {
	                startIndexB = startIndexB + (endIndexB - startIndexB) / 2;
	                endIndexA = startIndexA + (endIndexA - startIndexA) / 2;
	            }
	            else
	            {
	                startIndexB = startIndexB + (endIndexB - startIndexB) / 2;
	                endIndexA = startIndexA + (endIndexA - startIndexA) / 2 + 1;                
	            }
	        }
	        return findMedianSortedArrays(a, b, startIndexA, endIndexA, startIndexB, endIndexB);
	    }
	     
	    public static void main(String[] args)
	    {
	     
	        MedianOfTwoSortedArrays solution = new MedianOfTwoSortedArrays();
	       
	        System.out.println("Case 1: When arrays have odd number of elements in them." );
	        //int [] a = {1,2,3,4,5};
	        //int [] b = {6,7,8,9,10};
	        int [] a = {1,7,10,12,17,20,25};
	        int [] b = {4,6,9,11,15,21,24};
	        System.out.println("Median: "  + solution.findMedianSortedArrays(a, b, 0, a.length-1, 0, b.length-1));
	        
	        System.out.println("-----------------" );
	        
	        System.out.println("Case 2: When arrays have even number of elements in them." );
	        int[] c = {1,2,99, 100};
	        int[] d = {4,5,101, 102};
	         
	        System.out.println("Median: "  + solution.findMedianSortedArrays(c, d, 0, c.length-1, 0, d.length-1));
	    }
	}
