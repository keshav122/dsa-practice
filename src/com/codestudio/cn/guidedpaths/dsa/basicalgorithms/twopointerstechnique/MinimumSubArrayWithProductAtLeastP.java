package com.codestudio.cn.guidedpaths.dsa.basicalgorithms.twopointerstechnique;

public class MinimumSubArrayWithProductAtLeastP {

	public static int minSubarray(int arr[], int product) {

		int n = arr.length;
		int leftPointer = 0, rightPointer = 0;
		// Product of the current window is stored in the variable
		// currentProduct
		int currentProduct = 1;
		int ans = Integer.MAX_VALUE;
		// move the left pointer rightwards
		while (leftPointer < n){
			/*
			 * Till we reach the required product keep expanding the window
			 */
			while (rightPointer < n && currentProduct < product){
				currentProduct *= arr[rightPointer];
				rightPointer++;
			}
				// we update the answer with the window length
				if (currentProduct >= product){
					ans = Math.min(ans, rightPointer - leftPointer + 1);
				}
				// move the left pointer and update its contribution to the product
				currentProduct /= arr[leftPointer];
				leftPointer++;
					
		}		

		return ans;
	}
	
	 public static int minSubarray1(int arr[],int product) {
	        int n = arr.length;
	        int leftPointer=0,rightPointer=0;
	        int result=Integer.MAX_VALUE;
	        int currProduct = 1;
	        while(leftPointer<n && rightPointer<n)
	        {
	            if(currProduct>product)
	            {
	                result = Math.min(result,rightPointer-leftPointer+1);
	                currProduct/=arr[leftPointer];
	                leftPointer++;
	            }
	            else
	            {
	                rightPointer++;
	                if(rightPointer<n)
	                {
	                    currProduct *=arr[rightPointer];
	                }
	            }
	        }
	        return result;
	    }
	 
	 
	public static void main(String[] args) {
		int a[] = {1,2,3,4,5,6};
		int product = 1609;
		int ans = minSubarray1(a, product);
		System.out.println(ans);
	}

}
