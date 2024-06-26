package com.contest.weekly.count_403;

import java.util.Arrays;

/*
You have an array of floating point numbers averages
 which is initially empty. You are given an array nums of n integers where n is even.

You repeat the following procedure n / 2 times:

Remove the smallest element, minElement, and the largest element maxElement, from nums.
Add (minElement + maxElement) / 2 to averages.
Return the minimum element in averages.
*/
public class MinAvgOfSmallest_LargestElements
{

	public double minimumAverage(int[] nums) {
		int n = nums.length;
		double[] averages = new double[n / 2];
		Arrays.sort(nums);
		int i = 0;
		int j = n - 1;
		while (i < j) {
			averages[i] = (nums[i] + nums[j]) / 2.0;
			i++;
			j--;
		}
		Arrays.sort(averages);
		return averages[0];
	}

	public static void main(String[] args) {
		MinAvgOfSmallest_LargestElements obj = new MinAvgOfSmallest_LargestElements();
		int[] a = { 1, 9, 8, 3, 10, 5 };
		System.out.println(obj.minimumAverage(a));
	}
}
