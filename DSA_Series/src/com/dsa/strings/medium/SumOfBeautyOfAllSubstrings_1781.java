package com.dsa.strings.medium;

import java.util.HashMap;
import java.util.Map;

public class SumOfBeautyOfAllSubstrings_1781 {

	public int beautySum(String s) {
		int n = s.length();
		int beauty = 0;
		for (int i = 0; i < n; i++) {
			int[] charArray = new int[26];
			int minFreq = 1;
			int maxFreq = 1;
			for (int j = i; j < n; j++) {
				int index = s.charAt(j) - 'a';
				charArray[index]++;
				maxFreq = Math.max(maxFreq, charArray[index]);
				beauty += maxFreq - minFreq;
			}
		}
		return minFreq;
	}

	private int getBeauty(String str) {
		int min = 1;
		int max = 1;
		Map<Character, Integer> charMap = new HashMap<>();
		for (int i = 0; i < str.length(); i++) {
			charMap.merge(str.charAt(i), 1, Integer::sum);
		}
		if (charMap.keySet().size() >= 2) {
			for (Map.Entry<Character, Integer> entry : charMap.entrySet()) {
				if (entry.getValue() > max) {
					max = entry.getValue();
				}
			}
			return max - min;
		}
		return -1;
	}
}
