package com.codestudio.cn.guidedpaths.dsa.arrays.kadanealgorithm;


public class MaximumSumRectangle {

	public static int maxSumRectangle(int[][] arr, int n, int m)
    {
        
		//Calculating the sum of elements between two rows
		int ans = 0;
		for(int c1 =0 ; c1 < m; c1++){
			int rowSum[] = new int[n];
			for(int c2 = c1; c2 < m ; c2++){
				for(int i = 0; i< n;i++){
					rowSum[i] += arr[i][c2];
				}
				ans = Math.max(ans, kadane(rowSum));
			}
		}
		return ans;
    }

	private static int kadane(int[] arr) {
		int sum = arr[0];
		int maxSum = arr[0];
		for(int i = 0; i< arr.length;i++){
			sum = Math.max(sum + arr[i] , arr[i]);
			maxSum = Math.max(sum, maxSum);
		}
		return maxSum;
	}
	

	public static int kadaneAlgorithm(int[] arr, int n)
    {
        int sum = 0;

        int maxSum = Integer.MIN_VALUE;

        // Traverse the array.
        for (int currIndex = 0; currIndex < n; currIndex++)
        {
            sum += arr[currIndex];

            if (maxSum < sum)
            {
                maxSum = sum;
            }

            if (sum < 0)
            {
                sum = 0;
            }
        }

        return maxSum;
    }
	public static int maxSumRectangle_Official(int[][] arr, int n, int m)
    {
		 int maxSum = Integer.MIN_VALUE;

	        // Initialize a 1-D array.
	        int[] temp = new int[n];

	        // heck for all possible left and right boundaries.
	        for (int left = 0; left < m; left++)
	        {
	            for (int i = 0; i < n; i++)
	            {
	                temp[i] = 0;
	            }

	            for (int right = left; right < m; right++)
	            {
	                for (int i = 0; i < n; i++)
	                {
	                    temp[i] += arr[i][right];
	                }

	                // Function to find maximum sum of sub array of array 'temp'.
	                int sum = kadaneAlgorithm(temp, n);

	                // Update 'maxSum'.
	                if (sum > maxSum)
	                {
	                    maxSum = sum;
	                }
	            }
	        }

	        return maxSum;
    }

}
