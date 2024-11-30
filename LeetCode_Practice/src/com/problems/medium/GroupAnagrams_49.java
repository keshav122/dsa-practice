package com.problems.medium;

import java.util.*;

public class GroupAnagrams_49 {

	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> result = new ArrayList<>();
		int i = 0;
		int placeToStartNextIteration = i;
		// TODO Implement/Attempt the logic/solution
		while (placeToStartNextIteration < strs.length) {

		}
		return result;
	}

	private boolean areEqualStrings(String str1, String str2) {
		if (str1.length() != str2.length()) {
			return false;
		}
		int[] charArray = new int[26];
		for (int i = 0; i < str1.length(); i++) {
			charArray[str1.charAt(i) - 'a']++;
			charArray[str2.charAt(i) - 'a']--;
		}
		for (int i = 0; i < 26; i++) {
			if (charArray[i] != 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
		GroupAnagrams_49 obj = new GroupAnagrams_49();
		List<List<String>> ans = obj.groupAnagrams(strs);
		for (List<String> li : ans) {
			System.out.println(li.toString() + " ABD");
		}
	}
}