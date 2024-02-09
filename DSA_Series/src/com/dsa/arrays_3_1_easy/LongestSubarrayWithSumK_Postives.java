package com.dsa.arrays_3_1_easy;

public class LongestSubarrayWithSumK_Postives {

	 public static int longestSubarrayWithSumK(int []nums, long k) {
		 int maxLen = 1;
         for(int i = 0; i < nums.length;i++) {
        	int j = i;
        	long sum = 0;
        	while(sum <= k && j < nums.length) {
        		sum += nums[j];
        		if(sum == k) {
        			maxLen = Math.max(maxLen, j-i+1);
                    j++;
        		}else if(sum > k) {
        			break;
        		}else {
        			j++;
        		}
        	}
         }
         return maxLen;

	    }
}
