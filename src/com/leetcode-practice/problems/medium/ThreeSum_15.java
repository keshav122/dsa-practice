package com.leetcode-practice.problems.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum_15 {

	public List<List<Integer>> threeSum(int[] nums) {
		int n = nums.length;
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		for (int i = 0; i < n - 2; i++) {
			for (int j = i + 1; j < n - 1; j++) {
				int target = -(nums[i] + nums[j]);
				for (int k = j + 1; k < n; k++) {
					if (nums[k] == target) {
						List<Integer> li = new ArrayList<>();
						li.add(nums[i]);
						li.add(nums[j]);
						li.add(nums[k]);
						Collections.sort(li);
						if (!ans.contains(li)) {
							ans.add(li);
						}
					}
				}
			}
		}
		return ans;
	}

	public static List<List<Integer>> threeSum_Better(int[] nums) {
		int n = nums.length;
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		for (int i = 0; i < n; i++) {
			Set<Integer> hashSet = new HashSet<>();
			for (int j = i + 1; j < n; j++) {
				int target = -(nums[i] + nums[j]);
				if (hashSet.contains(target)) {
					List<Integer> li = new ArrayList<>();
					li.add(nums[i]);
					li.add(nums[j]);
					li.add(target);
					Collections.sort(li);
					if (!ans.contains(li)) {
						ans.add(li);
					}

				}
				hashSet.add(nums[j]);
			}
		}
		return ans;
	}

	public static List<List<Integer>> threeSum_Optimal(int[] nums) {
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		int i = 0;
		while (i < nums.length) {
			int j = i + 1;
			int k = nums.length - 1;
			while (j < k) {
				int sum = nums[i] + nums[j] + nums[k];
				if (sum == 0) {
					List<Integer> li = new ArrayList<>();
					li.add(nums[i]);
					li.add(nums[j]);
					li.add(nums[k]);
					if (!ans.contains(li)) {
						ans.add(li);
					}

					int t1 = nums[k];
					k--;
					while (nums[k] == t1 && k > j) {
						k--;
					}
					int t2 = nums[j];
					j++;
					while (nums[j] == t2 && j < k) {
						j++;
					}
				} else if (sum > 0) {
					k--;
				} else {
					j++;
				}
			}
			int t = nums[i];
			i++;
			while (i < nums.length && nums[i] == t && i < k) {
				i++;
			}

		}
		return ans;
	}

	public static List<List<Integer>> threeSum_OptimalOfficialSol(int[] nums) {
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			if (i > 0 && nums[i] == nums[i - 1])
				continue;
			int j = i + 1;
			int k = n - 1;
			while (j < k) {
				int sum = nums[i] + nums[j] + nums[k];
				if (sum < 0) {
					j++;
				} else if (sum > 0) {
					k--;
				} else {
					List<Integer> li = new ArrayList<>();
					li.add(nums[i]);
					li.add(nums[j]);
					li.add(nums[k]);
					ans.add(li);
					j++;
					k--;
					while (j < k && nums[j] == nums[j - 1])
						j++;
					while (j < k && nums[k] == nums[k + 1])
						k--;
				}
			}
		}

		return ans;
	}

	public static void main(String[] args) {
		int nums[] = { -1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4 };
		System.out.println(threeSum_Better(nums).toString());

	}
}
