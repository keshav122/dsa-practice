package com.leetcode_practice.contest.biweekly.count_183;

public class P1 {
    public int minimumSwaps(int[] nums) {
        int n = nums.length;
        int i = 0, j = n - 1, count = 0;
        while (i < j) {
            while (nums[j] == 0)
                j--;
            while (nums[i] != 0)
                i++;
            if (i >= j)
                return count;
            i++;
            j--;
            count++;
        }
        return count;

    }
}
