package com.leetcode_practice.problems.easy;

public class LongestCommonPrefix_14 {

	public String longestCommonPrefix(String[] strs) {

		StringBuilder sb = new StringBuilder();
		int minLen = Integer.MAX_VALUE;
		for (String str : strs) {
			minLen = Math.min(minLen, str.length());
		}
		int i = 0;
		while (i < minLen) {
			char c = strs[0].charAt(i);
			for (int j = 1; j < strs.length; j++) {
				if (strs[j].charAt(i) != c) {
					return sb.toString();
				}

			}
			sb.append(c);
			i++;
		}
		return sb.toString();

	}
}
