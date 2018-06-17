package com.ravi.ds.java.DP;

public class FibonacciNumber {

	 static int fibWithoutExtraSpace(int n)
	    {
	        int a = 0, b = 1, c;
	        if (n == 0)
	            return a;
	        for (int i = 2; i <= n; i++)
	        {
	            c = a + b;
	            a = b;
	            b = c;
	        }
	        return b;
	    }
	 
	 static int fibWithExtraSpace(int n){
		 if(n==0)
			 return 0;
		 if(n==1)
			 return 1;
		 int[] memo= new int[n];
		 memo[0]=0;
		 memo[1]=1;
		 for(int i=2; i<n;i++){
			 memo[i]=memo[i-1]+memo[i-2];
		 }
		 return memo[n-1]+ memo[n-2];
	 }
	 
	    public static void main (String args[])
	    {
	        int n = 9;
	        System.out.println(fibWithoutExtraSpace(n));
	        System.out.println(fibWithExtraSpace(n));
	    }

}
