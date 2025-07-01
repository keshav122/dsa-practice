package com.leetcode_practice.problems.medium;

import java.util.HashMap;
import java.util.Map;

public class MinimumIncrementToMakeArrayUnique_945 {

	public int minIncrementForUnique(int[] nums) {
		Map<Integer, Integer> freqMap = new HashMap<>();
		for (int i : nums) {
			freqMap.merge(i, 1, Integer::sum);
		}
		int count = 0;
		for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
			int value = entry.getValue();
			if (value > 1) {
				int key = entry.getKey();
				int temp = key;
				while (freqMap.containsKey(temp)) {
					temp++;
				}
				freqMap.put(key, value - 1);

			}
		}

		// TODO Implement the logic
		return 0;
	}
}
