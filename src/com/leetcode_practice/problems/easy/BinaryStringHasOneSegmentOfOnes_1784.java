package com.leetcode_practice.problems.easy;

public class BinaryStringHasOneSegmentOfOnes_1784 {
    public boolean checkOnesSegment(String s) {
        int n = s.length();
        int count = 0;
        int curr = 1;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == '1') {
                curr++;
            } else {
                if (curr > 0) {
                    count++;
                    if (count > 1)
                        return false;
                }
                curr = 0;
            }

        }
        if (curr > 0)
            count++;
        return count == 1;
    }
}
