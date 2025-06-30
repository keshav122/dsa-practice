package com.leetcode_practice.problems.medium;

import java.util.List;

public class MinimumIndexOfAValidSplit_2780 {
    public int minimumIndex(List<Integer> nums) {
        int n = nums.size();
        int[] ans = getDominantElement(nums, n);
        if (ans[0] == -1)
            return -1;
        int domCurrCount = 0;
        for (int i = 0; i < n; i++) {
            if (nums.get(i) == ans[0]) {
                domCurrCount++;
            }
            boolean isLeftDom = (domCurrCount * 2) > (i + 1);
            boolean isRightDom = ((ans[1] - domCurrCount) * 2) > (n - (i + 1));
            if (isLeftDom && isRightDom)
                return i;
        }
        return -1;
    }

    private int[] getDominantElement(List<Integer> nums, int n) {
        int candidate = nums.get(0);
        int candidateCount = 1;

        for (int i = 1; i < n; i++) {
            if (nums.get(i) == candidate) {
                candidateCount++;
            } else {
                candidateCount--;
            }
            if (candidateCount == 0) {
                candidate = nums.get(i);
                candidateCount = 1;
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (nums.get(i) == candidate) {
                count++;
            }
        }
        int ans[] = new int[2];
        if (count > n / 2) {
            ans[0] = candidate;
            ans[1] = count;
        } else {
            ans[0] = -1;
            ans[1] = -1;
        }
        return ans;
    }
}
