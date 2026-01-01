package com.leetcode_practice.problems.easy;

import java.util.ArrayList;
import java.util.List;

public class PlusOne_66 {
    public int[] plusOne_BF(int[] digits) {
        List<Integer> number = new ArrayList<>();
        int lastDigit = (digits[digits.length - 1] + 1) % 10;
        number.add(lastDigit);
        int carry = (digits[digits.length - 1] + 1) / 10;
        for (int i = digits.length - 2; i >= 0; i--) {
            number.add((digits[i] + carry) % 10);
            carry = (digits[i] + carry) / 10;
        }
        if (carry > 0) {
            number.add(carry);
        }
        int n = number.size();
        int[] ans = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            ans[n - i - 1] = number.get(i);
        }
        return ans;
    }

    public int[] plusOne_optimal(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] ans = new int[digits.length + 1];
        ans[0] = 1;
        return ans;
    }
}
