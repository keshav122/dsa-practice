package com.leetcode_practice.problems.medium;

import java.util.ArrayList;
import java.util.List;

public class SequentialDigits_1291 {
    public List<Integer> sequentialDigits(int low, int high) {
        String temp = "123456789";
        List<Integer> ans = new ArrayList<>();
        int maxLen = (int) (Math.log10(high) + 1);
        for (int len = 1; len <= maxLen; len++) {
            for (int j = 0; j <= temp.length() - len; j++) {
                String sub = temp.substring(j, j + len);
                Integer val = Integer.parseInt(sub);
                if (val >= low && val <= high) {
                    ans.add(val);
                }
            }
        }
        return ans;
    }
}
