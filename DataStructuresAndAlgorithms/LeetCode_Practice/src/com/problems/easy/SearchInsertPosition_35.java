package com.problems.easy;

public class SearchInsertPosition_35 {

	public int searchInsert(int[] nums, int target) {
		int n = nums.length;
		int start = 0;
		int end = n - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] > target) {
				if (mid == 0) {
					return mid;
				} else if (mid > 0 && nums[mid - 1] < target) {
					return mid;
				}
				end = mid - 1;
			} else {
				if (mid == n - 1) {
					return n;
				} else if (mid < n - 1 && nums[mid + 1] > target) {
					return mid + 1;
				}

				start = mid + 1;
			}
		}
		
		return 0;
	}

	public int searchInsert_optimal(int[] nums, int target) {
		int n = nums.length;
		 int ans = n;
		 int low = 0;
		 int high = nums.length -1;
		 while(low <= high) {
			 int mid = (low + high)/2;
			 if(nums[mid] >= target) {
				ans = mid;
				high = mid-1;
			 }else {
				 low = mid + 1;
			 }
		 }
		 return ans;
	}
}
