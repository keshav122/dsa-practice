package com.leetcode-practice.problems.easy;

public class MaxCountOfPosAndNegativeInteger_2529 {
    public int maximumCount(int[] nums) {
        int negCount = 0;
        int i = 0;
        int n = nums.length;
        for (; i < n; i++) {
            if (nums[i] == 0)
                continue;
            else if (nums[i] < 0)
                negCount++;
            else
                break;
        }
        int posCount = n - i;
        return posCount > negCount ? posCount : negCount;
    }

    public int maximumCount_better(int[] nums) {
        // Calculate the lower bound and upper bound for zero and based on that we can
        // calculate the
        // max value.

        // TODO Try the better solution
        return 0;
    }
}
