package com.problems.medium;

import java.util.Arrays;

public class SortColors_75 {

	// BruteForceBasic
	public void sortColors_Way1(int[] nums) {
		Arrays.sort(nums);
	}

	public void sortColors(int[] nums) {
		int zeroCount = 0, oneCount = 0, twoCount = 0;
		for (int i : nums) {
			if (i == 0) {
				zeroCount++;
			} else if (i == 1) {
				oneCount++;
			} else {
				twoCount++;
			}
		}
		int i = 0;
		for (int j = 0; j < zeroCount; j++) {
			nums[i] = 0;
			i++;
		}

		for (int k = 0; k < oneCount; k++) {
			nums[i] = 1;
			i++;
		}

		for (int l = 0; l < twoCount; l++) {
			nums[i] = 2;
			i++;
		}

	}

	public void sortColorsCountBetter(int[] nums) {
		int zeroCount = 0;
		int oneCount = 0;
		for (int i : nums) {
			if (i == 0)
				zeroCount++;
			else if (i == 1)
				oneCount++;
		}
		int i = 0;
		while (i < zeroCount) {
			nums[i] = 0;
			i++;
		}
		while (i < zeroCount + oneCount) {
			nums[i] = 1;
			i++;
		}
		while (i < nums.length) {
			nums[i] = 2;
			i++;
		}
	}

	// Dutch National Flag Algo
	public void sortColors_DNF(int[] nums) {
		int low = 0;
		int mid = 0;
		int high = nums.length - 1;
		while (mid <= high) {
			if (nums[mid] == 0) {
				// swap low & curr index
				nums[mid] = nums[low];
				nums[low] = 0;
				low++;
				mid++;
			} else if (nums[mid] == 1) {
				mid++;
			} else {
				// swap high & curr index
				nums[mid] = nums[high];
				nums[high] = 2;
				high--;
			}
		}
	}

	public static void main(String[] args) {
		SortColors_75 s = new SortColors_75();
		int nums[] = { 2, 0, 2, 1, 1, 0 };
		s.sortColors(nums);
		for (int i : nums) {
			System.out.print(i + " ");
		}
	}
}
