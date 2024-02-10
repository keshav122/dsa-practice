package com.dsa.basic_1_6.basic_hashing;

import java.util.HashMap;
import java.util.Map;

public class Highest_LowestFrequencyElements {

	public static int[] getFrequencies(int[] v) {
		Map<Integer, Integer> map = new HashMap<>();
		int minFreq = Integer.MAX_VALUE;
		int maxFreq = Integer.MIN_VALUE;
		int ans[] = new int[2];
		for (int i : v) {
			map.merge(i, 1, Integer::sum);
		}

		for (Map.Entry<Integer, Integer> e : map.entrySet()) {
			if(e.getValue() > maxFreq || (e.getValue() == maxFreq &&  e.getKey() < ans[0]) ) {
				ans[0] = e.getKey();
				maxFreq = e.getValue();
			}
		}
		
		for (Map.Entry<Integer, Integer> e : map.entrySet()) {
			if(e.getValue() < minFreq || (e.getValue() == minFreq &&  e.getKey() < ans[1]) ) {
				ans[1] = e.getKey();
				minFreq = e.getValue();
			}
		}
		return ans;

	}

	public static void main(String[] args) {
		int[] v = { 1, 2, 3, 1, 1, 4 };
		int ans[] = getFrequencies(v);
		for (int i : ans) {
			System.out.println(i);
		}

	}
}
