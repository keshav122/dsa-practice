package com.leetcode_practice.problems.medium;

public class SearchInRotatedSortedArray_33 {

	public int search(int[] nums, int target) {
		int low = 0;
		int high = nums.length -1;
		while(low <= high) {
			int mid = (low + high)/2;
			if(nums[mid] == target) {
				return mid;
			}
			
			if(nums[low] <= nums[mid]) {
				if(nums[low] <= target && target <= nums[mid]) {
					high = mid-1;
				}else {
					low = mid + 1;
				}
			}else {
				//value is in the right half
				if(nums[mid] < target && target <= nums[high]) {
					low = mid+1;
				}else {
					//value is not in the right half
					high = mid - 1;
				}
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int a[] = {4,5,6,7,0,1,2};
		int target = 0;
		SearchInRotatedSortedArray_33 s = new SearchInRotatedSortedArray_33();
		System.out.println(s.search(a, target));
	}

}
