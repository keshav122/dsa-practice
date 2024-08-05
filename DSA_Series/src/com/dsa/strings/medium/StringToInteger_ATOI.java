package com.dsa.strings.medium;

//Good Question in terms of Edge Cases
public class StringToInteger_ATOI {
	public int myAtoi(String s) {
		long val = 0;
		int mult = 1;
		int digits = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (val >= Integer.MAX_VALUE || val <= Integer.MIN_VALUE) {
				return getVal(val, mult);
			}
			if (c >= '0' && c <= '9') {
				int digit = c - '0';
				if (digits == 0) {
					val += digit;
					digits++;
				} else {
					val = val * 10 + digit;
				}

			} else if (c == ' ') {
				if (digits == 0)
					continue;
				else
					return getVal(val, mult);
			} else if (c == '-' || c == '+') {
				if (digits == 0 && c == '-') {
					mult = -1;
					digits++;
				} else if (digits == 0 && c == '+') {
					mult = 1;
					digits++;
				} else
					return getVal(val, mult);
			} else {
				return getVal(val, mult);
			}
		}
		return getVal(val, mult);
	}

	private int getVal(long val, int mult) {
		long value = mult * val;
		if (mult == 1 && (value > Integer.MAX_VALUE || value < Integer.MIN_VALUE)) {
			return Integer.MAX_VALUE;
		} else if (mult == -1 && (value > Integer.MAX_VALUE || value < Integer.MIN_VALUE))
			return Integer.MIN_VALUE;
		return (int) (val * mult);
	}

	public static void main(String[] args) {
		String s = "1337c0d3";
		StringToInteger_ATOI obj = new StringToInteger_ATOI();
		System.out.println(obj.myAtoi(s));
	}

}
