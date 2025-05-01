package com.problems.medium;

public class FindPeakElement_162 {

	public int findPeakElement(int[] nums) {
		int n = nums.length;
		if (n == 1)
			return 0;
		if (nums[0] > nums[1])
			return 0;
		if (nums[n - 1] > nums[n - 2])
			return n - 1;

		int low = 1;
		int high = n - 2;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1])
				return mid;

			if ((mid % 2 == 0 && nums[mid + 1] > nums[mid]) || (mid % 2 == 1 && nums[mid] > nums[mid - 1])) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}

		return -1;
	}

	// More intuitive solution - This will work only for 1 peak. For mutiple peaks we
	//might have to tweak the solution a bit
	//Check this code for : 1 5 1 2 1
	public int findPeakElement_1(int[] nums) {
		int n = nums.length;
		if (n == 1)
			return 0;
		if (nums[0] > nums[1])
			return 0;
		if (nums[n - 1] > nums[n - 2])
			return n - 1;

		int low = 1;
		int high = n - 2;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1])
				return mid;

			else if (nums[mid] > nums[mid - 1]) {
				low = mid + 1;
			} 
			else if (nums[mid] > nums[mid + 1]) {
				high = mid - 1;
			}
		}
		return -1;
	}
	
	public int findPeakElement_1MultiplePeaks(int[] nums) {
		int n = nums.length;
		if (n == 1)
			return 0;
		if (nums[0] > nums[1])
			return 0;
		if (nums[n - 1] > nums[n - 2])
			return n - 1;

		int low = 1;
		int high = n - 2;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1])
				return mid;

			else if (nums[mid] > nums[mid - 1]) {
				low = mid + 1;
			}
			else if (nums[mid] > nums[mid + 1]) {
				high = mid - 1;
			}else {
				low = mid+1; //we can also do high = mid-1;//Going to any half will give us solution
			}
		}
		return -1;
	}
}
