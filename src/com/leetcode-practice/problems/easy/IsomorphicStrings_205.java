package com.leetcode-practice.problems.easy;

/*Author: keshav122 */
package com.problems.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IsomorphicStrings_205 {

	public boolean isIsomorphic(String s, String t) {
		Map<Character, Character> map = new HashMap<>();
		Map<Character, Character> reverseMap = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char temp = s.charAt(i);
			char temp1 = t.charAt(i);

			if (map.containsKey(temp) || reverseMap.containsKey(temp1)) {
				if (map.containsKey(temp) && map.get(temp) != temp1) {
					return false;
				}
				if (reverseMap.containsKey(temp1) && reverseMap.get(temp1) != temp) {
					return false;
				}
			} else {
				map.put(temp, temp1);
				reverseMap.put(temp1, temp);
			}
		}

		return true;
	}

	public boolean isIsomorphic_1(String s, String t) {
		Map<Character, Character> map = new HashMap<>();
		StringBuilder sb = new StringBuilder();
		Set<Character> valueSet = new HashSet<>();
		for (int i = 0; i < s.length(); i++) {
			if (!map.containsKey(s.charAt(i)) && valueSet.contains(t.charAt(i))) {
				return false;
			} else if (!map.containsKey(s.charAt(i)) && !valueSet.contains(t.charAt(i))) {
				map.put(s.charAt(i), t.charAt(i));
				valueSet.add(t.charAt(i));
			}
			sb.append(map.get(s.charAt(i)));
		}
		return sb.toString().contentEquals(t);
	}

	public boolean isIsomorphic_2(String s, String t) {
		//TODO Write the optimal code for  this
		 return false;
	}
	public static void main(String[] args) {
		String s = "badc";
		String t = "baba";
		IsomorphicStrings_205 a = new IsomorphicStrings_205();
		System.out.println(a.isIsomorphic_2(s, t));
	}
}
