package com.problems.medium;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumEqualsK_560 {

	// Brute Force
	public int subarraySum(int[] nums, int k) {
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums.length; j++) {
				int sum = 0;
				for (int x = i; x <= j; x++) {
					sum += nums[x];
				}
				if (sum == k)
					count++;
			}
		}
		return count;
	}


	//Not working for use case like [-1,1,0] and k = 0
	public int subarraySum_1(int[] nums, int k) {
		int count = 0;
		Map<Integer, Integer> sumMap = new HashMap<>();
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			sumMap.put(sum, i);
			if (sum == k) {
				count++;
			} else if (sumMap.containsKey(sum - k)) {
				count++;
			}
		}
		return count;
	}
	
	public int subarraySum_2(int[] nums, int k) {
		Map<Integer, Integer> sumfreqMap = new HashMap<>();//This stores the freq of each sum
		sumfreqMap.put(0, 1);
		int sum = 0;
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			
		   if (sumfreqMap.containsKey(sum - k)) {
				count += sumfreqMap.get(sum - k);
			}
		   sumfreqMap.put(sum, sumfreqMap.getOrDefault(sum, 0)  + 1);
		}
		return count;
	}
}
