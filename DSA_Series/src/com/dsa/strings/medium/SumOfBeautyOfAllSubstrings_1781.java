package com.dsa.strings.medium;

import java.util.HashMap;
import java.util.Map;

public class SumOfBeautyOfAllSubstrings_1781 {

	public int beautySum(String s) {
		int ans = 0;
		int n = s.length();
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				String substring = s.substring(i, j + 1);
				int beauty = getBeauty(substring);
				if (beauty != -1) {
					ans += beauty;
				}
			}
		}
		return ans;
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
