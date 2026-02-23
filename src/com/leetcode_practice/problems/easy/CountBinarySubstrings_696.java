package com.leetcode_practice.problems.easy;

import java.util.ArrayList;
import java.util.List;

public class CountBinarySubstrings_696 {
    public int countBinarySubstrings(String s) {
        int n = s.length();
        int count = 0;
        for (int i = 0; i < n; i++) {
            char first = s.charAt(i);
            int firstBlockCount = 0, secondBlockCount = 0, transitionCount = 0;
            for (int j = i; j < n; j++) {
                if (s.charAt(j) == first) {
                    if (transitionCount == 1) {
                        break;
                    } else {
                        firstBlockCount++;
                    }
                } else {
                    if (secondBlockCount == 0) {
                        transitionCount++;
                    }
                    secondBlockCount++;
                    if (secondBlockCount == firstBlockCount) {
                        count++;
                    }
                    if (secondBlockCount > firstBlockCount) {
                        break;
                    }
                }

            }
        }
        return count;
    }

    public int countBinarySubstrings_better(String s) {
        int n = s.length();
        int count = 0;
        int i = 1;
        char currChar = s.charAt(0);
        int currentCnt = 1;
        List<Integer> blocks = new ArrayList<>();
        while (i < n) {
            if (s.charAt(i) == currChar) {
                currentCnt++;
            } else {
                blocks.add(currentCnt);
                currChar = s.charAt(i);
                currentCnt = 1;
            }
            i++;
        }
        blocks.add(currentCnt);
        for (int j = 1; j < blocks.size(); j++) {
            count += Math.min(blocks.get(j), blocks.get(j - 1));
        }
        return count;
    }

    public int countBinarySubstrings_optimal(String s) {
        int n = s.length();
        int ans = 0, prev = 0, curr = 1;
        char currChar = s.charAt(0);
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == currChar) {
                curr++;
            } else {
                currChar = s.charAt(i);
                ans += Math.min(curr, prev);
                prev = curr;
                curr = 1;
            }
        }
        ans += Math.min(ans, prev);
        return ans;
    }
}
