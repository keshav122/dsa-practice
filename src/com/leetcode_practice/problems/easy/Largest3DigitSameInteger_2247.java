package com.leetcode_practice.problems.easy;

public class Largest3DigitSameInteger_2247 {
    public String largestGoodInteger(String num) {
        int n = num.length();
        String ans = "";
        char currentChar = num.charAt(0);
        int count = 1;
        for (int i = 1; i < n; i++) {
            if (num.charAt(i) == currentChar) {
                count++;
                if (count == 3) {
                    if (ans == "" || ans.charAt(0) < num.charAt(i)) {
                        ans = num.substring(i - 2, i + 1);
                    }
                }
            } else {
                currentChar = num.charAt(i);
                count = 1;
            }
        }
        return ans;
    }
}
