package com.dsa.arrays_3_1_easy;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayWithSumK_Positives {

	// Close to O(n^3)
	public static int longestSubarrayWithSumK_BruteForce(int[] nums, long k) {
		int maxLen = 0;
		for (int i = 0; i < nums.length; i++) {
			for (int j = i; j < nums.length; j++) {
				long sum = 0;
				for (int x = i; x <= j; x++) {
					sum += nums[x];
				}
				if (sum == k)
					maxLen = Math.max(maxLen, j - i + 1);
			}
		}
		return maxLen;
	}

	// O(n^2)
	public static int longestSubarrayWithSumK_BruteForceOptimised(int[] nums, long k) {
		int maxLen = 0;
		for (int i = 0; i < nums.length; i++) {
			long sum = 0;
			for (int j = i; j < nums.length; j++) {
				sum += nums[j];
				if (sum == k)
					maxLen = Math.max(maxLen, j - i + 1);
			}
		}
		return maxLen;
	}
	
	public static int longestSubarrayWithSumK(int[] nums, long k) {
		int maxLen = 1;
		for (int i = 0; i < nums.length; i++) {
			int j = i;
			long sum = 0;
			while (sum <= k && j < nums.length) {
				sum += nums[j];
				if (sum == k) {
					maxLen = Math.max(maxLen, j - i + 1);
					j++;
				} else if (sum > k) {
					break;
				} else {
					j++;
				}
			}
		}
		return maxLen;

	}

	// Concept : If at any point the prefixSum is x so if we find a point where
	// the sum was x-k so from there to current position the sum will be k
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
	
	public static int longestSubarrayWithSumK_revision(int []a, long k) {
		Map<Long,Integer> map = new HashMap<>();
		long sum = 0;
		int maxLen = 0;
		for(int i = 0; i< a.length; i++){
			sum += a[i];
			if(!map.containsKey(sum)){
				map.put(sum,i);
			}
			
			if(sum ==k){
				maxLen = Math.max(maxLen,i+1);
			}else if(map.size() > 0 &&  map.containsKey(sum-k)){
				maxLen = Math.max(maxLen,i - map.get(sum-k));
			}
		}
		return maxLen;
    }

	//Most Optimal - two pointer with shifting if sum > k
	//Why cannot we initialize  the sum to 0
	public static int longestSubarrayWithSumK_TwoPointer(int []a, long k) {
        int left = 0 ,right = 0;
		int maxLen = 0;
		long sum = a[0];
		int n = a.length;
		while(right < n) {
			while(left <= right && sum > k) {
				sum -= a[left];
				left++;
			}
			
			if(sum == k) {
				maxLen = Math.max(maxLen, right-left + 1);
			
			}
			right++;
			if(right < n) {
				sum += a[right];
			}
		}
		return maxLen;
    }
}
