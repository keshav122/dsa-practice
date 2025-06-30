package com.leetcode_practice.problems.easy;

public class ReversePrefixOfWord_2000 {
	public String reversePrefix(String word, char ch) {
		int index = word.indexOf(ch);
		if (index == -1) {
			return word;
		} else {
			String res = "";
			for (int a = index; a >= 0; a--) {
				res += word.charAt(a);
			}
			res += word.substring(index + 1);
			return res;
		}
	}
}
