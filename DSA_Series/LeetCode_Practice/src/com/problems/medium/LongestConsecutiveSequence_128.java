package com.problems.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence_128 {

	public int longestConsecutive(int[] nums) {
		Set<Integer> set = new HashSet<>();
		for (int n : nums) {
			set.add(n);
		}
		Integer[] resArray = set.toArray(new Integer[set.size()]);
		Arrays.sort(resArray);
		int n = resArray.length;
		int maxLen = 1, sI = 0;
		boolean isContinous = true;
		for (int i = 1; i < n; i++) {
			if (resArray[i] - resArray[i - 1] != 1) {
				sI = i;
				isContinous = false;
			} else {
				maxLen = Math.max(maxLen, i - sI + 1);
			}
		}
		if (isContinous)
			maxLen = n;
		return maxLen;
	}

	public int longestConsecutive_Improved(int[] nums) {
		Set<Integer> set = new HashSet<>();
		for (int a : nums) {
			set.add(a);
		}
		int res = 0;
		for (int i = 0; i < nums.length; i++) {
			if (!set.contains(nums[i] - 1)) {
				int currElem = nums[i];
				while (set.contains(currElem + 1)) {
					currElem++;
				}
				int currLen = currElem - nums[i] + 1;
				res = Math.max(res, currLen);
			}
		}
		return res;
	}

	public int longestConsecutive_Improved1(int[] nums) {
		int n = nums.length;
		if (n == 0)
			return 0;

		int longest = 1;
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < n; i++) {
			set.add(nums[i]);
		}

		for (int i : set) {
			if (!set.contains(i - 1)) {
				// find consecutive numbers
				int cnt = 1;
				int x = i;
				while (set.contains(x + 1)) {
					x = x + 1;
					cnt = cnt + 1;
				}
				longest = Math.max(longest, cnt);
			}
		}
		return longest;
	}

	public static void main(String[] args) {
		int a[] = { -9, -6, 2, -7, 8, 9, 4, -8, 7, -3 };
		LongestConsecutiveSequence_128 obj = new LongestConsecutiveSequence_128();
		System.out.println(obj.longestConsecutive_Improved(a));

	}
}
