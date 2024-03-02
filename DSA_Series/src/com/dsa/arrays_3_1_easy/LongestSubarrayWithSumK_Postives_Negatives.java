package com.dsa.arrays_3_1_easy;

import java.util.HashMap;
import java.util.Map;

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
	 
	 public static int longestSubarrayWithSumK_Hashing(int[] nums, long k) {
			Map<Long, Integer> map = new HashMap<>();
			int i = 0;
			long sum = 0;
			int maxLen = 0;
			while (i < nums.length) {
				sum += nums[i];
				// If the sum already exists we should not update it as we want to look for the
				// leftmost value possible
				// and there can be 0's present in the array
				if (!map.containsKey(sum))
					map.put(sum, i);
				if (sum == k)
					maxLen = Math.max(maxLen, i + 1);
				else if (map.containsKey(sum - k))
					maxLen = Math.max(maxLen, i - map.get(sum - k));
				i++;
			}
			return maxLen;

		}
	 
	 public static void main(String[] args) {
		int[] nums = {-1,1,1};
		int k = 1;
		int ans = longestSubarrayWithSumK_Hashing(nums, k);
		System.out.println(ans);
	}
}
