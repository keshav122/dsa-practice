/*Author: keshav122 */
package com.leetcode_practice.problems.easy;

public class CountHillsAndValleysInAnArray_2210 {
    public int countHillValley(int[] nums) {
        int count = 0;
        int n = nums.length;
        for (int i = 1; i <= n - 2; i++) {
            if (nums[i] != nums[i - 1]) {
                boolean isHill = isHill(nums, i, n);
                boolean isValley = isValley(nums, i, n);
                if (isHill || isValley)
                    count++;
            }
        }
        return count;
    }

    public boolean isHill(int[] nums, int idx, int n) {
        boolean leftSmallerFound = false, rightSmallerFound = false;
        int i = idx - 1, j = idx + 1;
        while (i >= 0) {
            if (nums[i] > nums[idx]) {
                return false;
            } else if (nums[i] < nums[idx]) {
                leftSmallerFound = true;
                break;
            }
            i--;
        }

        while (j < n) {
            if (nums[j] > nums[idx]) {
                return false;
            } else if (nums[j] < nums[idx]) {
                rightSmallerFound = true;
                break;
            }
            j++;
        }
        return leftSmallerFound && rightSmallerFound;
    }

    public boolean isValley(int[] nums, int idx, int n) {
        boolean leftGreaterFound = false, rightGreaterFound = false;
        int i = idx - 1, j = idx + 1;
        while (i >= 0) {
            if (nums[i] < nums[idx]) {
                return false;
            } else if (nums[i] > nums[idx]) {
                leftGreaterFound = true;
                break;
            }
            i--;
        }

        while (j < n) {
            if (nums[j] < nums[idx]) {
                return false;
            } else if (nums[j] > nums[idx]) {
                rightGreaterFound = true;
                break;
            }
            j++;
        }
        return leftGreaterFound && rightGreaterFound;
    }

    public int countHillValley_Cleaner(int[] nums) {
        int count = 0;
        int n = nums.length;
        for (int i = 1; i < n - 1; i++) {
            if (nums[i] == nums[i - 1]) {
                continue;
            }

            // find left distinct
            int left = i - 1;
            while (left >= 0 && nums[left] == nums[i])
                left--;

            int right = i + 1;
            while (right < n && nums[right] == nums[i])
                right++;

            if (left >= 0 && right < n) {
                if (nums[i] > nums[left] && nums[i] > nums[right]) {
                    count++;// hill
                } else if (nums[i] < nums[left] && nums[i] < nums[right]) {
                    count++;// valley
                }
            }
        }
        return count;
    }
}
