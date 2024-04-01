package com.dsa.arrays_3_3_hard;

import java.util.HashMap;
import java.util.Map;

public class SubArraysWithXORK {

	public static int subarraysWithSumK_bruteForce(int[] a, int b) {
		int n = a.length;
		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				int xorVal = a[i];
				for (int k = i + 1; k <= j; k++) {
					xorVal ^= a[k];
				}
				if (xorVal == b) {
					count++;
				}
			}
		}
		return count;

	}

	public static int subarraysWithSumK_better(int[] a, int b) {
		int n = a.length;
		int count = 0;
		for (int i = 0; i < n; i++) {
			int xorVal = 0;
			for (int j = i; j < n; j++) {
				xorVal ^= a[j];
				if (xorVal == b) {
					count++;
				}
			}
		}
		return count;

	}

	public static int subarraysWithSumK_Optimal(int[] a, int b) {
		Map<Integer, Integer> xorFreqMap = new HashMap<>();
		xorFreqMap.put(0, 1);
		int n = a.length;
		int count = 0;
		int xor = 0;
		for (int i = 0; i < n; i++) {
			xor ^= a[i];
		    if (xorFreqMap.containsKey(xor ^ b)) {
				count += xorFreqMap.get(xor ^ b);
			}

			xorFreqMap.put(xor, xorFreqMap.getOrDefault(xor, 0) + 1);

		}
		return count;

	}

	public static void main(String[] args) {

	}

}
