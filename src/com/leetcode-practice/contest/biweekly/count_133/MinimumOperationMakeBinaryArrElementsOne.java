package com.leetcode-practice.contest.biweekly.count_133;

/*
 * You are given a 
binary array
 nums.

You can do the following operation on the array any number of times (possibly zero):

Choose any 3 consecutive elements from the array and flip all of them.
Flipping an element means changing its value from 0 to 1, and from 1 to 0.

Return the minimum number of operations required to make all elements in nums equal to 1. If it is impossible, return -1.
 */

//TODO Solve this - Currently unsolved
public class MinimumOperationMakeBinaryArrElementsOne{

	public int minOperations(int[] nums) {
		int n = nums.length;
		int count = 0;
		int i = 0;
		while (i < n - 2) {
			boolean containsZero = nums[i] == 0 || nums[i + 1] == 0 || nums[i + 2] == 0;
			if (containsZero) {
				if (nums[i] == 0)
					nums[i] = 1;
				else
					nums[i] = 0;

				if (nums[i + 1] == 0)
					nums[i + 1] = 1;
				else
					nums[i + 1] = 0;

				if (nums[i + 2] == 0)
					nums[i + 2] = 1;
				else
					nums[i + 2] = 0;

				count++;
				i++;
			} else {
				i += 3;
			}
		}

		for (int num : nums) {
			if (num != 1) {
				return -1;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		MinimumOperationMakeBinaryArrElementsOne obj = new MinimumOperationMakeBinaryArrElementsOne();
		int[] a = { 0, 1, 1, 1, 0, 0 };
		System.out.println(obj.minOperations(a));
	}
}
