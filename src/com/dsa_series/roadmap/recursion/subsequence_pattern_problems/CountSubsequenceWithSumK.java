package com.dsa_series.roadmap.recursion.subsequence_pattern_problems;

public class CountSubsequenceWithSumK {
    public int countSubsequenceWithTargetSum(int[] nums, int k) {
        int n = nums.length;
        return countSubSequenceSumOccurence(nums, 0, 0, k, n);
    }

    public int countSubSequenceSumOccurence(int[] nums, int index, int currentSum, int k, int n) {
        int count = 0;
        if (index == n) {
            return count;
        }
        // Without taking the element at index i in sum
        int smallAns1 = countSubSequenceSumOccurence(nums, index + 1, currentSum, k, n);
        currentSum += nums[index];
        if (currentSum == k) {
            count++;
        }
        int smallAns2 = countSubSequenceSumOccurence(nums, index + 1, currentSum, k, n);
        return (smallAns1 + smallAns2 + count);
    }
}
