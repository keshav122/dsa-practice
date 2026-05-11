package com.leetcode_practice.problems.easy;

public class SeparateTheDigitsInAnArray_2553 {
    public int[] separateDigits(int[] nums) {
        StringBuilder sb = new StringBuilder();
        for (int num : nums) {
            StringBuilder temp = new StringBuilder();
            while (num > 0) {
                temp.append(num % 10);
                num /= 10;
            }
            sb.append(temp.reverse());
        }
        String digits = sb.toString();
        int n = digits.length();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = (int) (digits.charAt(i) - '0');
        }
        return ans;
    }

    public int[] separateDigits_better(int[] nums) {
        StringBuilder sb = new StringBuilder();
        for (int num : nums) {
            sb.append(num);
        }
        String digits = sb.toString();
        int n = digits.length();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = (int) (digits.charAt(i) - '0');
        }
        return ans;
    }
}
