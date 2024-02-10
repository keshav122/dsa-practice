package com.dsa.arrays_3_1_easy;

public class LongestSubarrayWithSumK_Postives_Negatives {

	//O(N^2) solution - partially accepted
	 public static int longestSubarrayWithSumK(int []nums, int k) {
		 int maxLen = 0;
         for(int i = 0; i < nums.length;i++) {
        	int j = i;
        	int sum = 0;
        	while(j < nums.length) {
        		sum += nums[j];
        		if(sum == k) {
        			maxLen = Math.max(maxLen, j-i+1);
        		}
				j++;
        	}
         }
         return maxLen;

	    }
	 
	 public static int longestSubarrayWithSumK(int []nums, int k) {
		 //TODO store the sums for subarray and then check
		 return -1;
	 }
}
