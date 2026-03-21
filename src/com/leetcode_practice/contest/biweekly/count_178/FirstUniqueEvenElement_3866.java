package com.leetcode_practice.contest.biweekly.count_178;

public class FirstUniqueEvenElement_3866 {
    public int firstUniqueEven(int[] nums) {
        int[] hash = new int[101];
        for (int num : nums) {
            if (num % 2 == 0 && hash[num] == 0) {
                hash[num]++;
            } else if (hash[num] > 0) {
                hash[num] = -1;
            }
        }

        for (int num : nums) {
            if (hash[num] == 1)
                return num;
        }
        return -1;
    }
}
