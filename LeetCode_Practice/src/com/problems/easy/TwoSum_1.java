package com.problems.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class TwoSum_1 {

	//Brute Force
	public int[] twoSum(int[] nums, int target) {

		int[] ans = new int[2];
		for(int i = 0; i < nums.length; i++) {
			int req = target - nums[i];
			for(int j = i+ 1; j < nums.length; j++) {
				if(nums[j] == req) {
					ans[0] =i;
					ans[1] = j;
					return ans;
				}
			}
		}
		return ans;
	}
	
	
	public int[] twoSum_Way2(int[] nums, int target) {
		int[] ans = new int[2];
		Map<Integer,Integer> map = new HashMap<>();
		Map<Integer,Integer> targetMap = new HashMap<>();
		for(int i = 0; i < nums.length; i++) {
			if(map.containsKey(nums[i])) {
				if(nums[i] * 2 == target) {
					ans[0] = map.get(nums[i]);
					ans[1] = i;
					return ans;
				}
			}
			map.put(nums[i], i);
			targetMap.put(target - nums[i], i);
		}
		for(Map.Entry<Integer,Integer> entry : targetMap.entrySet()) {
			if(map.containsKey(entry.getKey())) {
				ans[0] = map.get(entry.getKey());
				ans[1] = entry.getValue();
				return ans;
			}
		}
		return ans;
	}
	
	
}

