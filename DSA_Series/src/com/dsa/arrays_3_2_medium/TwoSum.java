package com.dsa.arrays_3_2_medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public static String read(int n, int[] book, int target) {
		for (int i = 0; i < n; i++) {
			int val = target - book[i];
			for (int j = i + 1; j < n; j++) {
				if (book[j] == val) {
					return "YES";
				}
			}
		}
		return "NO";
	}

	// Better solution - Hashing Approach
	public static String read_1(int n, int[] book, int target) {
		Map<Integer, Integer> valueIndexMap = new HashMap<>();
		for (int i = 0; i < n; i++) {
			int a = book[i];
			int diff = target - a;
			if (valueIndexMap.containsKey(diff)) {
				return "YES";
			}
			valueIndexMap.put(a, i);
		}
		return "NO";
	}

	// Works good for this one but not for the case where we have to return the
	// indices
	// Two pointer approach
	public static String read_2(int n, int[] book, int target) {
		Arrays.sort(book);
		int start = 0, end = n - 1;
		while (start < end) {
			int sum = book[start] + book[end];
			if (sum == target) {
				return "YES";
			} else if (sum > target) {
				end--;
			} else {
				start++;
			}
		}
		return "NO";
	}

	public static void main(String[] args) {
		int book[] = { 4, 1, 2, 3, 1 };
		int target = 5;
		System.out.println(read(book.length, book, target));
	}
}
