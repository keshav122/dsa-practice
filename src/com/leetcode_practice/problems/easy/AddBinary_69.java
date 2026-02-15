package com.leetcode_practice.problems.easy;

public class AddBinary_69 {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1;
        int carry = 0;
        while (i >= 0 && j >= 0) {
            int first = a.charAt(i) - '0';
            int second = b.charAt(j) - '0';
            int sum = (first + second + carry);
            if (sum % 2 == 0) {
                sb.append('0');
            } else {
                sb.append('1');
            }
            carry = sum > 1 ? 1 : 0;
            i--;
            j--;
        }

        while (i >= 0) {
            int sum = (int) (a.charAt(i) - '0') + carry;
            if (sum % 2 == 0) {
                sb.append('0');
            } else {
                sb.append('1');
            }
            carry = sum > 1 ? 1 : 0;
            i--;
        }

        while (j >= 0) {
            int sum = (int) (b.charAt(j) - '0') + carry;
            if (sum % 2 == 0) {
                sb.append('0');
            } else {
                sb.append('1');
            }
            carry = sum > 1 ? 1 : 0;
            j--;
        }

        if (carry != 0)
            sb.append('1');
        return sb.reverse().toString();
    }

    public String addBinary_better(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0 || carry == 1) {
            int sum = carry;
            if (i >= 0) {
                sum += (a.charAt(i--) - '0');
            }
            if (j >= 0) {
                sum += (b.charAt(j--) - '0');
            }
            sb.append(sum % 2);
            carry = sum / 2;
        }
        return sb.reverse().toString();
    }
}
