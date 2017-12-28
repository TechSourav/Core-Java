package com.ravi.ds.java.DP;

class MatrixChainMultiplication
{
	/**
	 *BOTTOM- UP APPROACH 
	 **/
	
	/*static int MatrixChainOrder(int p[])
    {
        int n = p.length;
        int m[][] = new int[n][n];
        int s[][] = new int[n][n];
 
        int i, j, k, L, q;
 
        for (i = 1; i < n; i++)
            m[i][i] = 0;
 
        for (L=2; L<n; L++)
        {
            for (i=1; i<n-L+1; i++)
            {
                j = i+L-1;
                if(j == n) 
                	continue;
                m[i][j] = Integer.MAX_VALUE;
                for (k=i; k<=j-1; k++)
                {
                    q = m[i][k] + m[k+1][j] + p[i-1]*p[k]*p[j];
                    if (q < m[i][j])
                        m[i][j] = q;
                    	s[i][j]=k;
                }
            }
        }
 
        return m[1][n-1];
    }
 
    public static void main(String args[])
    {
        int arr[] = new int[] {1, 2, 1, 4, 1};
        System.out.println("Minimum number of multiplications is "+
                           MatrixChainOrder(arr));
    }*/
	
	
	/**
	 *TOP-DOWN APPROACH
	 * 
	 **/
	
	public static void main(String args[])
    {
        int arr[] = new int[] {1, 2, 1, 4, 1};
        int n = arr.length;
        System.out.println("Minimum number of multiplications is "+ MEMOIZED_MATRIX_CHAIN(arr));
        
    }
	
	static int MEMOIZED_MATRIX_CHAIN(int[] p) {
		int n= p.length;
		int[][] m = new int[n][n];
		for(int i=1;i<n;i++) {
			for(int j=1;j<n;j++) {
				m[i][j]=Integer.MAX_VALUE;
			}
		}
		return LOOKUP_CHAIN(m,p,1,n-1);
	}
	
	static int LOOKUP_CHAIN(int[][] m, int[] p, int i, int j) {
		
		if(m[i][j]<Integer.MAX_VALUE) {
			return m[i][j];
		}
		if(i==j) {
			m[i][j]=0;
		}else {
			for (int k = i; k < j; k++) {
				int count = LOOKUP_CHAIN(m,p, i, k) + LOOKUP_CHAIN(m,p, (k + 1), j) + p[i - 1] * p[k] * p[j];
				if(count<m[i][j]) {
					m[i][j]=count;
				}
			
			}
		}
		
		return m[i][j];
		
	}
	
}