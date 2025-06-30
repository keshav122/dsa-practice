package com.leetcode_practice.problems.medium;


public class MinSumOfTwoArraysAfterEqualingZeroes_2918 {
    public long minSum(int[] nums1, int[] nums2) {
        long minS1 = 0;
        int nums1ZeroCnt = 0;
        long minS2 = 0;
        int nums2ZeroCnt = 0;
        for (int num : nums1) {
            if (num == 0) {
                nums1ZeroCnt++;
                minS1++;
            } else {
                minS1 += num;
            }
            ;
        }
        for (int num : nums2) {
            if (num == 0) {
                minS2++;
                nums2ZeroCnt++;
            } else {
                minS2 += num;
            }
        }

        if (minS1 != minS2) {
            if ((minS1 < minS2 && nums1ZeroCnt == 0) || (minS1 > minS2 && nums2ZeroCnt == 0)) {
                return -1;
            }
        }
        return Math.max(minS1, minS2);

    }
}
