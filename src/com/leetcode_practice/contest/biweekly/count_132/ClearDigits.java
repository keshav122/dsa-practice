package com.leetcode_practice.contest.biweekly.count_132;

public class ClearDigits {

	public String clearDigits(String s) {
		int n = s.length();
		int[] splitted = new int[n];
		int i = 0;
		while (i < n) {
			char c = s.charAt(i);
			boolean isDigit = c >= '0' && c <= '9';
			if (isDigit) {
				splitted[i] = -1;
				if (i != 0) {
					if (splitted[i - 1] != -1) {
						splitted[i - 1] = -1;
					} else {
						int temp =i;
						while (temp > 1 && splitted[temp - 1] == -1) {
							temp--;
						}
						splitted[--temp] = -1;
					}
				}
			}

			i++;
		}

		String ans = "";
		for (int k = 0; k < n; k++) {
			if (splitted[k] != -1) {
				ans += s.charAt(k);
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		ClearDigits obj = new ClearDigits();
		String s = "abc34";
		System.out.println(obj.clearDigits(s));
	}
}
