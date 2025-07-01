package com.leetcode_practice.problems.medium;

/*Author: keshav122 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HandOfStraights_846 {

	// Incorrect Solution
	public static boolean isNStraightHand_MySolution(int[] hand, int groupSize) {
		int n = hand.length;
		if (n % groupSize != 0)
			return false;
		Map<Integer, Integer> freqMap = new HashMap<>();
		int minInMap = Integer.MAX_VALUE;
		for (int i : hand) {
			minInMap = Math.min(i, minInMap);
			freqMap.merge(i, 1, Integer::sum);
		}
		int i = 0;
		while (i < n) {
			int k = minInMap;
			int q = 0;
			while (q < groupSize) {
				if (!freqMap.containsKey(k + 1)) {
					return false;
				} else {

					freqMap.put(k, freqMap.get(k) - 1);
					freqMap.put(k + 1, freqMap.get(k + 1) - 1);
					k += 2;
				}
				q += 2;
			}
			Set<Integer> keysSet = freqMap.keySet();
			ArrayList<Integer> keysList = new ArrayList<>();
			keysList.addAll(keysSet);
			for (Integer a : keysSet) {
				if (freqMap.get(a) == 0)
					keysList.remove(a);
			}
			minInMap = Collections.min(keysList);
			i += groupSize;
		}

		return true;
	}

	public static boolean isNStraightHand_GeminiSol(int[] hand, int groupSize) {
		int n = hand.length;
		if (n % groupSize != 0)
			return false;
		Map<Integer, Integer> freqMap = new HashMap<>();
		int minInMap = Integer.MAX_VALUE;
		for (int i : hand) {
			minInMap = Math.min(i, minInMap);
			freqMap.merge(i, 1, Integer::sum);
		}
		int i = 0;
		while (i < n) {
			int k = minInMap;
			int q = 0;
			while (q < groupSize) {
				if (!freqMap.containsKey(k))
					return false;
				freqMap.put(k, freqMap.get(k) - 1);
				if (freqMap.get(k) == 0)
					freqMap.remove(k);
				k++;
				q++;
			}
			minInMap = freqMap.keySet().stream().min(Integer::compareTo).orElse(Integer.MAX_VALUE);
			i += groupSize;
		}

		return true;
	}

	public static void main(String[] args) {
		int[] a = { 9, 13, 15, 23, 22, 25, 4, 4, 29, 15, 8, 23, 12, 19, 24, 17, 18, 11, 22, 24, 17, 17, 10, 23, 21, 18,
				14, 18, 7, 6, 3, 6, 19, 11, 16, 11, 12, 13, 8, 26, 17, 20, 13, 19, 22, 21, 27, 9, 20, 15, 20, 27, 8, 13,
				25, 23, 22, 15, 9, 14, 20, 10, 6, 5, 14, 12, 7, 16, 21, 18, 21, 24, 23, 10, 21, 16, 18, 16, 18, 5, 20,
				19, 20, 10, 14, 26, 2, 9, 19, 12, 28, 17, 5, 7, 25, 22, 16, 17, 21, 11 };
		int groupSize = 10;
		System.out.println(isNStraightHand_GeminiSol(a, groupSize));
	}

}
