package com.leetcode-practice.problems.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LargePositiveIntegerThatExistsWithItsNegative_2441 {

	public int findMaxK(int[] nums) {
		Set<Integer> hashSet = new HashSet<Integer>();
        for(int num : nums){
            hashSet.add(num);
        }
        Arrays.sort(nums);
        for(int i = nums.length -1; i>0 && nums[i] > 0;i--){
           if(hashSet.contains(nums[i] * -1)){
            return nums[i];
           }
        }
        return -1;
	}
}
