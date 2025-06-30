package com.codestudio.cn.guidedpaths.dsa.strings.mixedproblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MatchSpecificPattern {

	public static List<String> matchSpecificPattern(List<String> words, int n, String pattern) {
		List<String> ans = new ArrayList<>();
		for (String str : words) {
			if (str.length() != pattern.length()) {
				continue;
			}
			HashMap<Character, Character> map = new HashMap<>();
			HashMap<Character, Character> reverseMap = new HashMap<>();
			boolean toBeAdded = true;
			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				char p = pattern.charAt(i);
				if (!map.containsKey(c) && !reverseMap.containsKey(p)) {
					map.put(c, p);
					reverseMap.put(p, c);
				} else {
					if ((map.containsKey(c) && map.get(c) != p)
							|| (reverseMap.containsKey(p) && reverseMap.get(p) != c)) {
						toBeAdded = false;
						break;
					}
				}

			}
			if (toBeAdded) {
				ans.add(str);
			}

		}
		return ans;

	}
}
