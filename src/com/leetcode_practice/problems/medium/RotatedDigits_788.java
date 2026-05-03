package com.leetcode_practice.problems.medium;

import java.util.HashMap;
import java.util.Map;

public class RotatedDigits_788 {
    public int rotatedDigits(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        map.put(1, 1);
        map.put(8, 8);
        map.put(2, 5);
        map.put(5, 2);
        map.put(6, 9);
        map.put(9, 6);

        int count = 0;
        for (int i = 2; i <= n; i++) {
            int rotatedNum = rotatedNumber(i, map);

            if (rotatedNum != -1) {
                count++;
            }

        }
        return count;
    }

    public int rotatedNumber(int n, Map<Integer, Integer> map) {
        int temp = n;
        int newNum = 0;
        StringBuilder sb = new StringBuilder();
        while (temp > 0) {
            int digit = temp % 10;
            if (!map.containsKey(digit)) {
                return -1;
            }
            int rotatedDigit = map.get(digit);
            sb.append(rotatedDigit);
            temp = temp / 10;
        }
        newNum = Integer.parseInt(sb.reverse().toString());
        if (newNum == n)
            return -1;
        return newNum;
    }

    public int rotatedDigits_better(int n) {
        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (isGood(i)) {
                count++;
            }

        }
        return count;
    }

    private boolean isGood(int n) {
        boolean hasDifferentDigits = false;
        int temp = n;
        while (temp > 0) {
            int digit = temp % 10;
            if (digit == 3 || digit == 4 || digit == 7) {
                return false;
            } else if (digit == 2 || digit == 5 || digit == 6 || digit == 9) {
                hasDifferentDigits = true;
            }

            temp = temp / 10;
        }
        return hasDifferentDigits;
    }

    public int rotatedDigits_optimal(int n) {
        int[] dp = new int[n + 1];
        dp[3] = dp[4] = dp[7] = 0;// invalid
        dp[0] = dp[1] = dp[8] = 1;// same
        dp[2] = dp[5] = dp[6] = dp[9] = 2;// different;

        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (i < 10 && dp[i] == 2)
                count++;
            int prefix = i / 10;
            int lastDigit = i % 10;
            if (dp[prefix] == 0 || dp[lastDigit] == 0) {
                dp[i] = 0;
            } else if (dp[prefix] == 1 && dp[lastDigit] == 1) {
                dp[i] = 1;
            } else if (dp[prefix] == 2 || dp[lastDigit] == 2) {
                dp[i] = 2;
                count++;
            }
        }
        return count;
    }

}