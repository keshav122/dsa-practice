package com.roadmap.hashing.FAQs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequenceInArray {
    public int longestConsecutive_BF(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int max_count = 1;
        int count = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] - nums[i - 1] == 1) {
                count++;
                max_count = Math.max(max_count, count);
            } else {
                count = 1;
            }
        }
        return max_count;
    }

    public int longestConsecutive_Better(int[] nums) {
        Set<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            hashSet.add(num);
        }
        int max_count = 1;
        for (int elem : hashSet) {
            if (hashSet.contains(elem - 1)) {
                continue;
            } else {
                int currElem = elem;
                int count = 0;
                while (hashSet.contains(currElem)) {
                    currElem += 1;
                    count++;
                }
                max_count = Math.max(max_count, count);

            }
        }
        return max_count;
    }
}
