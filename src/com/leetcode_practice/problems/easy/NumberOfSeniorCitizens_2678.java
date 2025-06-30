package com.leetcode_practice.problems.easy;

public class NumberOfSeniorCitizens_2678 {

	public int countSeniors(String[] details) {
		int count = 0;
		for (String str : details) {
			if (str.charAt(11) > '6' || (str.charAt(11) == '6' && str.charAt(12) > '0')) {
				count++;
			}
		}
		return count;
	}
}
