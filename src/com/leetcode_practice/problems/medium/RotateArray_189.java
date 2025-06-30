package com.leetcode_practice.problems.medium;

/*Author: keshav122 */
package com.problems.medium;

/*# Author: keshav122*/
public class RotateArray_189 {
	// With extra space

	public void rotate(int[] nums, int k) {
		int[] ans = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			int index = (i + k) % (nums.length);
			ans[index] = nums[i];
		}

		for (int i = 0; i < ans.length; i++) {
			nums[i] = ans[i];
		}
	}

	public void rotate_extrad(int[] nums, int k) {
		int n = nums.length;
		k = k % n;
		int[] ans = new int[k];
		for (int i = n - k, j = 0; i < n; i++, j++) {
			ans[j] = nums[i];
		}

		for (int i = n - k - 1; i >= 0; i--) {
			nums[i + k] = nums[i];
		}
		for (int i = 0; i < k; i++) {
			nums[i] = ans[i];
		}

	}

	// Reversal Based Solution
	public void rotate_ReversalBased(int[] nums, int k) {
		int n = nums.length;
		reverseArray(nums, 0, n - k - 1);
		reverseArray(nums, n - k, n - 1);
		reverseArray(nums, 0, n - 1);
	}

	private void reverseArray(int[] nums, int startIndex, int endIndex) {
		while (startIndex <= endIndex) {
			int temp = nums[startIndex];
			nums[startIndex] = nums[endIndex];
			nums[endIndex] = temp;
			startIndex++;
			endIndex--;
		}
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
		RotateArray_189 r = new RotateArray_189();
		r.rotate_ReversalBased(arr, 2);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
