package com.leetcode_practice.problems.easy;

import java.util.HashSet;
import java.util.Set;

public class MinimumCommonValue_2540 {
    public int getCommon(int[] nums1, int[] nums2) {
        Set<Integer> hash = new HashSet<>();
        for (int num : nums1) {
            hash.add(num);
        }
        for (int num : nums2) {
            if (hash.contains(num)) {
                return num;
            }
        }
        return -1;
    }

    public int getCommon_better(int[] nums1, int[] nums2) {
        int i = 0, j = 0, n1 = nums1.length, n2 = nums2.length;
        while (i < n1 && j < n2) {
            if (nums1[i] == nums2[j])
                return nums1[i];
            else if (nums1[i] < nums2[j])
                i++;
            else
                j++;
        }
        return -1;
    }
}
