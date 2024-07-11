package com.dsa.strings.easy;

import java.util.ArrayList;
import java.util.List;

public class RotateString {

	public boolean rotateString(String s, String goal) {
		List<String> permutations = new ArrayList<>();
		permutations.add(s);
		for (int i = 1; i < s.length(); i++) {
			String temp = permutations.get(i - 1);
			String tobeAdded = temp.substring(1) + temp.charAt(0);
			permutations.add(tobeAdded);
		}
		return permutations.contains(goal);
	}

	public boolean rotateString_SpaceOptimized(String s, String goal) {
		if (s.equals(goal))
			return true;
		String currStr = s;
		for (int i = 1; i < s.length(); i++) {
			String rotatedString = currStr.substring(1) + currStr.charAt(0);
			currStr = rotatedString;
			if (rotatedString.equals(goal))
				return true;
		}
		return false;
	}

	// TODO - Understanding of Knutt Moris Pratt Algorithm
	public static boolean rotateString_KMP(String s, String goal) {
		if (s.length() != goal.length()) {
			return false; // Strings must have the same length to be rotations
		}

		// Combine s and goal to create a search string for KMP
		String searchString = s + s;

		// Preprocess goal string to create KMP lookup table
		int[] lps = computeLPS(goal);

		int i = 0; // index for searchString
		int j = 0; // index for goal

		while (i < searchString.length()) {
			if (searchString.charAt(i) == goal.charAt(j)) {
				i++;
				j++;
			} else {
				// Mismatch
				if (j > 0) {
					j = lps[j - 1]; // Use lookup table to jump back in goal
				} else {
					i++;
				}
			}

			if (j == goal.length()) { // Pattern found (goal is a substring)
				return true;
			}
		}

		return false;
	}

	private static int[] computeLPS(String pattern) {
		// Create a lookup table (longest prefix suffix)
		int[] lps = new int[pattern.length()];
		int i = 1;
		int length = 0;

		while (i < pattern.length()) {
			if (pattern.charAt(i) == pattern.charAt(length)) {
				length++;
				lps[i] = length;
				i++;
			} else {
				if (length != 0) {
					length = lps[length - 1];
				} else {
					lps[i] = 0;
					i++;
				}
			}
		}

		return lps;
	}

	public boolean rotateString_Better(String s, String goal) {
		if (s.length() != goal.length())
			return false;
		String str = s + s;
		return (str.indexOf(goal) != -1);
	}

	public static void main(String[] args) {
		String s = "abcde";
		String goal = "cdeab";
		RotateString obj = new RotateString();
		System.out.println(obj.rotateString(s, goal));
	}
}
