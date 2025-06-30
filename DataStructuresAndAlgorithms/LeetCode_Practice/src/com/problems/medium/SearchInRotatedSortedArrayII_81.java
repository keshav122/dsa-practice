package com.problems.medium;

public class SearchInRotatedSortedArrayII_81 {

	// O(N) solution - Linear Search
	public boolean search(int[] nums, int target) {
		for (int i : nums) {
			if (i == target)
				return true;
		}
		return false;
	}

	public boolean search_optimal(int[] nums, int target) {
		int low = 0;
		int high = nums.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (nums[mid] == target) {
				return true;
			}

			if (nums[low] == nums[mid] && nums [mid] == nums[high]) {
				low += 1;
				high -= 1;
			}
			// Left half is sorted
			else if (nums[low] <= nums[mid]) {
				if (nums[low] <= target && target <= nums[mid]) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			} else if (nums[low] > nums[mid]) { 
				if (nums[mid] < target && target <= nums[high]) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		int a[] = {1,0,1,1,1};
		int target = 0;
		SearchInRotatedSortedArrayII_81 s = new SearchInRotatedSortedArrayII_81();
		System.out.println(s.search_optimal(a, target));
	}
}
