package com.leetcode-practice.problems.easy;

public class LengthOfLastWord_58 {
	public int lengthOfLastWord(String s) {
		String[] ans = s.split(" ");
		return ans[ans.length - 1].length();
	}

	public int lengthOfLastWordOptimal(String s) {
		int i = s.length() - 1;
		int count = 0;
		int flag = 0;
		while (i >= 0 && (flag == 0 || s.charAt(i) != ' ')) {
			char c = s.charAt(i);
			if (c != ' ') {
				flag = 1;
				count++;
			} else if (flag == 1 && c == ' ') {
				break;
			}
			i--;
		}
		return count;
	}
}
