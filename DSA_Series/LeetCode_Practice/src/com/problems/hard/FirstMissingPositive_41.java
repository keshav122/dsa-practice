package com.problems.hard;

import java.util.Arrays;

public class FirstMissingPositive_41 {

	public int firstMissingPositive_BruteForce(int[] nums) {
		int[] range = new int[100000];
		for (int i = 0; i < range.length; i++) {
			range[i] = i + 1;
		}

		for (int num : nums) {
			if (num > 0 && num <= 100000) {
				range[num - 1] = -1;
			}
		}

		for (int i : range) {
			if (i != -1) {
				return i;
			}
		}
		return 100001;
	}

	public int firstMissingPositive_Sort(int[] nums) {
		Arrays.sort(nums);
		int smallestPositive = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0) {
				if (nums[i] > smallestPositive + 1) {
					return smallestPositive + 1;
				} else if (nums[i] == smallestPositive + 1) {
					smallestPositive++;
				}
			}
		}
		return smallestPositive + 1;
	}

	public int firstMissingPositive_Faster(int[] nums) {
		int[] range = new int[nums.length];
		int positiveCount = 0;
		for (int i = 0; i < nums.length;i++) {
			if (nums[i] > 0 && nums[i] <= nums.length) {
				range[nums[i] - 1] = -1;
				positiveCount++;
			}
		}
		int i = 0;
		while (i< positiveCount) {
			if (range[i] != -1) {
				return i+1;
			}
			i++;
		}
		return ++i;
	}
	
	
	public static void main(String[] args) {
		int[] nums = {7,8,9,11};
		FirstMissingPositive_41 m = new FirstMissingPositive_41();
		System.out.println(m.firstMissingPositive_Faster(nums));
		
	}
}
