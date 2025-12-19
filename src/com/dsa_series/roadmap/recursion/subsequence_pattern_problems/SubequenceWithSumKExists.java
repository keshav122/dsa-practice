/*Author: keshav122 */
package com.dsa_series.roadmap.recursion.subsequence_pattern_problems;

public class SubequenceWithSumKExists {
    public boolean checkSubsequenceSum(int[] nums, int k) {
        int n = nums.length;
        return checkSumExists(nums, 0, 0, k, n);
    }

    public boolean checkSumExists(int[] nums, int index, int currentSum, int k, int n) {
        if (index == n) {
            return false;
        }
        // Without taking the element at index i in sum
        boolean smallAns1 = checkSumExists(nums, index + 1, currentSum, k, n);
        currentSum += nums[index];
        if (currentSum == k) {
            return true;
        }
        boolean smallAns2 = checkSumExists(nums, index + 1, currentSum, k, n);
        return (smallAns1 || smallAns2);
    }

    public static void main(String[] args) {
        int[] nums = { 1, 10, 4, 5 };
        int k = 16;
        SubequenceWithSumKExists subSum = new SubequenceWithSumKExists();
        System.out.println(subSum.checkSubsequenceSum(nums, k));
    }
}
