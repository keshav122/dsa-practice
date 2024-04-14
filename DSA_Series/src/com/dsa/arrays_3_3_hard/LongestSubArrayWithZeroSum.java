package com.dsa.arrays_3_3_hard;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArrayWithZeroSum {

	public static int getLongestZeroSumSubarrayLength_BruteForce(int[] arr) {
		int maxLen = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j < arr.length; j++) {
				int sum = 0;
				for (int k = i; k <= j; k++) {
					sum += arr[k];
				}
				if (sum == 0) {
					maxLen = Math.max(maxLen, j - i + 1);
				}
			}
		}
		return maxLen;
	}

	public static int getLongestZeroSumSubarrayLength_Better(int[] arr) {
		int maxLen = 0;
		for (int i = 0; i < arr.length; i++) {
			int sum = 0;
			for (int j = i; j < arr.length; j++) {
				sum += arr[j];
				if (sum == 0) {
					maxLen = Math.max(maxLen, j - i + 1);
				}
			}
		}
		return maxLen;
	}

	public static int getLongestZeroSumSubarrayLength_Optimal(int[] arr) {
		int maxLen = 0;
		Map<Integer, Integer> sumMap = new HashMap<>();
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			if (sum == 0) {
				maxLen = Math.max(maxLen, i + 1);
			} else if (sumMap.containsKey(sum)) {
				maxLen = Math.max(maxLen, i - sumMap.get(sum));
			}
			if (!sumMap.containsKey(sum)) {
				sumMap.put(sum, i);
			}
		}
		return maxLen;
	}
}
