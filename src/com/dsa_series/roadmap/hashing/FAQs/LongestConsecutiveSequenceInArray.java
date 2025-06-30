package com.dsa_series.roadmap.hashing.FAQs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequenceInArray {

    public int longestConsecutive_BF(int[] nums) {
        int longestSeq = 1;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            int cnt = 1;
            while (ls(nums, x + 1)) {
                x++;
                cnt++;
            }
            longestSeq = Math.max(cnt, longestSeq);
        }
        return longestSeq;
    }

    private boolean ls(int[] nums, int x) {
        for (int num : nums) {
            if (num == x)
                return true;
        }
        return false;
    }

    public int longestConsecutive_Better(int[] nums) {
        Arrays.sort(nums);
        int maxCount = 1;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            int diff = nums[i] - nums[i - 1];
            if (diff == 1) {
                count++;
                maxCount = Math.max(count, maxCount);
            } else if (diff == 0) {
                continue;
            } else {
                count = 1;
            }
        }
        return maxCount;
    }

    // Here we keep a variable last smaller and do the checks based on that
    public int longestConsecutive_SlightlyModifiedBetter(int[] nums) {
        Arrays.sort(nums);
        int largestSeq = 1, count = 1, lastSmaller = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] - 1 == lastSmaller) {
                count++;
                lastSmaller = nums[i];
                largestSeq = Math.max(count, largestSeq);
            } else if (nums[i] != lastSmaller) {
                lastSmaller = nums[i];
                count = 1;
            }

        }
        return largestSeq;
    }

    public int longestConsecutive(int[] nums) {
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
