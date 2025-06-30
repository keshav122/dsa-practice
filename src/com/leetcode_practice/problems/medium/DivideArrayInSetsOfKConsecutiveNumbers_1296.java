package com.leetcode_practice.problems.medium;

import java.util.HashMap;
import java.util.Map;

//Same as problem HandOfStraights_846
public class DivideArrayInSetsOfKConsecutiveNumbers_1296 {

	public boolean isPossibleDivide(int[] nums, int k) {
		int n = nums.length;
		if (n % k != 0)
			return false;
		Map<Integer, Integer> freqMap = new HashMap<>();
		int minInMap = Integer.MAX_VALUE;
		for (int i : nums) {
			minInMap = Math.min(i, minInMap);
			freqMap.merge(i, 1, Integer::sum);
		}
		int i = 0;
		while (i < n) {
			int value = minInMap;
			int q = 0;
			while (q < k) {
				if (!freqMap.containsKey(value))
					return false;
				freqMap.put(value, freqMap.get(value) - 1);
				if (freqMap.get(value) == 0)
					freqMap.remove(value);
				value++;
				q++;
			}
			minInMap = freqMap.keySet().stream().min(Integer::compareTo).orElse(Integer.MAX_VALUE);
			i += k;
		}

		return true;
	}
}
