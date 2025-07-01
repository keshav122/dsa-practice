package com.leetcode_practice.problems.medium;

//Symbol       Value
//I             1
//V             5
//X             10
//L             50
//C             100
//D             500
//M             1000
public class IntegerToRoman {

	public String intToRoman(int num) {
		StringBuilder sb = new StringBuilder();
		if (num >= 999) {
			if (num == 999) {
				return "IM";
			}
			int count = num / 1000;
			String s = "M".repeat(count);
			sb.append(s);
			num = num % 1000;
		}
		return sb.toString();
	}
}
