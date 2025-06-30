package com.leetcode-practice.problems.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FourSum_18 {
	public List<List<Integer>> fourSumBF(int[] nums, int target) {
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				for (int k = j + 1; k < n; k++) {
					for (int l = k + 1; l < n; l++) {
						if (nums[i] + nums[k] + nums[j] + nums[l] == target) {
							List<Integer> li = new ArrayList<>();
							li.add(nums[i]);
							li.add(nums[j]);
							li.add(nums[k]);
							li.add(nums[l]);
							Collections.sort(li);
							if (!ans.contains(li)) {
								ans.add(li);
							}
						}
					}
				}
			}
		}
		return ans;
	}

	public List<List<Integer>> fourSumBetter(int[] nums, int target) {
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				Set<Integer> hashSet = new HashSet<>();
				for (int k = j + 1; k < n; k++) {
					int val = target - (nums[i] + nums[j] + nums[k]);
					if (hashSet.contains(val)) {
						List<Integer> li = new ArrayList<>();
						li.add(nums[i]);
						li.add(nums[j]);
						li.add(nums[k]);
						li.add(val);
						Collections.sort(li);
						if (!ans.contains(li)) {
							ans.add(li);
						}
					}
					hashSet.add(nums[k]);
				}
			}
		}
		return ans;
	}

	public List<List<Integer>> fourSumOptimal(int[] nums, int target) {
		Arrays.sort(nums);
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			if (i > 0 && nums[i] == nums[i - 1])
				continue;
			for (int j = i + 1; j < n; j++) {
				if (j > i + 1 && nums[j] == nums[j - 1])
					continue;
				int k = j + 1;
				int l = n - 1;
				while (k < l) {
					long a = nums[i] + nums[j];
					long b = nums[k] + nums[l];
					long sum = a + b;
					if (sum < target) {
						k++;
					} else if (sum > target) {
						l--;
					} else {
						List<Integer> li = new ArrayList<>();
						li.add(nums[i]);
						li.add(nums[j]);
						li.add(nums[k]);
						li.add(nums[l]);
						ans.add(li);
						k++;
						l--;
						while (k < l && nums[k] == nums[k - 1])
							k++;
						while (k < l && nums[l] == nums[l + 1])
							l--;
					}
				}

			}
		}

		return ans;
	}

	public static void main(String[] args) {
		int a[] = { 1000000000, 1000000000, 1000000000, 1000000000 };
		FourSum_18 f = new FourSum_18();
		List<List<Integer>> ans = f.fourSumOptimal(a, -294967296);
		for (List<Integer> i : ans) {
			System.out.println(i.toString());
		}

	}
}
