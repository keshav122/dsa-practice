package com.problems.easy;

public class RemoveDuplicatesfromSortedArray_26 {

	public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n == 1) {
			return n;
		}
		int slow = 0;
		int fast = 1;
		while (fast < n) {
			if (nums[slow] != nums[fast]) {
				if (fast != slow + 1) {
					nums[slow + 1] = nums[fast];
				}
				slow++;
				fast++;

			} else {
				fast++;
			}
		}
		return slow+1;
    }
}
