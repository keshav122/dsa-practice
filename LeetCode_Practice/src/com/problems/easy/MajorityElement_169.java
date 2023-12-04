package com.problems.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement_169 {

	public int majorityElement(int[] nums) {

		int n = nums.length;
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : nums) {
			if (map.containsKey(num)) {
				map.put(num, map.get(num) + 1);
				if (map.get(num) > (n / 2)) {
					return num;
				}

			} else {
				map.put(num, 1);
			}
		}
		return nums[0];
	}

	// if you sort the element in any order , the number at the middle index will be
	// the majority element as the number appears more than (n/2) times
	public int majorityElement_SortingArray(int[] nums) {
		Arrays.sort(nums);
		return nums[(0 + nums.length) / 2];
	}
	
	
	//Moore Voting Algorithm
	public int majorityElement_MooreVotingAlgo(int[] nums) {
		int candidate = nums[0];
		int count = 1;
		for(int i = 1; i < nums.length;i++) {
			if(count == 0) {
				candidate = nums[i];
			}
			if(nums[i] == candidate) {
				count++;
			}else {
				count--;
			}
		}
		return candidate;
	}
}
