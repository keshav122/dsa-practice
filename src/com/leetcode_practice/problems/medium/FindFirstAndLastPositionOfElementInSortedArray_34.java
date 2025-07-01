package com.leetcode_practice.problems.medium;

/*Author: keshav122 */

public class FindFirstAndLastPositionOfElementInSortedArray_34 {

	public int[] searchRange(int[] nums, int target) {
		int[] ans = new int[2];
		int n = nums.length;
		int start = 0;
		int end = n - 1;
		boolean isFound = false;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (nums[mid] == target) {
				isFound = true;
				int left = mid;
				int right = mid;
				if (left == 0) {
					ans[0] = 0;
				} else {
					while (left >= 0 && nums[left] == target) {
						left--;
					}
					ans[0] = left + 1;
				}
				if (right == n - 1) {
					ans[1] = n - 1;
				} else {
					while (right < n && nums[right] == target) {
						right++;
					}
					ans[1] = right - 1;
				}

				if (isFound) {
					return ans;
				}
			} else if (nums[mid] > target) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		if (!isFound) {
			ans[0] = ans[1] = -1;
		}
		return ans;
	}

	public int[] searchRangeOptimal(int[] nums, int target) {
		int ans[] = new int[2];
		ans[0] = firstOcc(nums, nums.length, target);
		ans[1] = lastOcc(nums, nums.length, target);
		return ans;
	}

	private int lastOcc(int[] nums, int n, int target) {
		int low = 0;
		int high = n - 1;
		int ans = -1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (nums[mid] == target) {
				ans = mid;
				low = mid + 1;
			} else if (nums[mid] > target) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return ans;
	}

	private int firstOcc(int[] nums, int n, int target) {
		int low = 0;
		int high = n - 1;
		int ans = -1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (nums[mid] == target) {
				ans = mid;
				high = mid - 1;
			} else if (nums[mid] > target) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return ans;
	}

}
