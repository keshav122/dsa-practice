package com.cn.guidedpaths.dsa.strings.mixedproblems;

import java.util.Arrays;
public class LongestSubstringWithAtmostKDistinctCharacters {
	private static boolean isValid(int count[], int k) {
		int val = 0;
		for (int i = 0; i < 26; i++) {
			if (count[i] > 0) {
				val++;
			}
		}

		// Return true if k is greater than or equal to val
		return (k >= val);
	}

	public static int getLengthofLongestSubstring(String s, int k) {
		int u = 0;
		int n = s.length();

		// Associative array to store the count of characters
		int count[] = new int[26];
		// Traverse the string, Fills the associative array count[] and count
		// number of unique characters
		for (int i = 0; i < n; i++) {
			if (count[s.charAt(i) - 'a'] == 0) {
				u++;
			}
			count[s.charAt(i) - 'a']++;
		}

		if (u < k) {
			return s.length();
		}

		// Otherwise take a window with first element in it. start and end
		// variables.
		int current_start = 0, current_end = 0;

		// Initializing values for result longest window
		int max_window_size = 1;
		int max_window_start = 0;

		// Initialize associative array count[] with zero
		Arrays.fill(count, 0);

		// put the first character
		count[s.charAt(0) - 'a']++;

		// Start from the second character and add characters in window according to above explanation
		for (int i = 1; i < n; i++) {
			// Add the character 's[i]' to current window
			count[s.charAt(i) - 'a']++;
			current_end++;

			// If there are more than k unique characters in current window, remove from left side
			while (!isValid(count, k)) {
				count[s.charAt(current_start) - 'a']--;
				current_start++;
			}

			// Update the max window size if required
			if (current_end - current_start + 1 > max_window_size) {
				max_window_size = current_end - current_start + 1;
				max_window_start = current_start;
			}
		}

	    return max_window_size;
	}

	public static void main(String[] args) {
		String s = "iccjr";
		int k = 2;
		System.out.println(getLengthofLongestSubstring(s, k));
	}

}
