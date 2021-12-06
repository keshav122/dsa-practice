package com.cn.guidedpaths.dsa.strings.mixedproblems;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtmostKDistinctCharacters {

	public static int getLengthofLongestSubstring(String s, int k) {
		int count = 0;
		for (int i = 0; i <= s.length() - k; i++) {
			String st = s.substring(i);
			Map<Character, Integer> map = new HashMap<>();
			for (int j = 0; j < st.length(); j++) {
				char c = st.charAt(j);
				if (map.containsKey(c)) {
					map.put(c, map.get(c) + 1);
				} else {
					map.put(c, 1);
				}
			}
			
			if (map.size() == k && st.length() > count) {
				count = st.length();
			}

		}
        if(count < k){
            return s.length();
        }
		return count;
	}

	public static void main(String[] args) {
		String s = "abccc";
		int k = 1;
		System.out.println(getLengthofLongestSubstring(s, k));
	}
}
