package com.leetcode-practice.problems.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SortThePeople_2418 {

	public String[] sortPeople(String[] names, int[] heights) {
		int n = heights.length;
		Map<Integer, String> heightNameMap = new HashMap<>();
		for (int i = 0; i < n; i++) {
			heightNameMap.put(heights[i], names[i]);
		}
		Arrays.sort(heights);
		for (int j = n - 1; j >= 0; j--) {
			names[(n - 1) - j] = heightNameMap.get(heights[j]);
		}
		return names;
	}
}
