package com.leetcode_practice.problems.easy;

public class Maximum_69_Number_1323 {

    public int maximum69Number_ConciseSol(int num) {
        return Integer.parseInt(String.valueOf(num).replaceFirst("6", "9"));
    }

    public int maximum69Number(int num) {
        return Integer.parseInt((num + "").replaceFirst("6", "9"));
    }

    public int maximum69Number_MySol(int num) {
        int[] digits = new int[6];
        int j = 5;
        while (num > 0) {
            digits[j] = num % 10;
            j--;
            num /= 10;
        }
        for (int i = 0; i < 6; i++) {
            if (digits[i] == 6) {
                digits[i] = 9;
                break;
            }
        }
        int mult = 10;
        int value = digits[5];
        for (int i = 4; i >= 0; i--) {
            if (digits[i] == 0) {
                return value;
            } else {
                value += digits[i] * mult;
                mult *= 10;
            }
        }
        return value;
    }

    public int maximum69Number_Math_most_optimal(int num) {
        int n = num, index = -1, pos = 0;

        while (n > 0) {
            if (n % 10 == 6) {
                index = pos; // position of last seen '6'
            }
            n /= 10;
            pos++;
        }

        // If we found a '6', flip it to '9'
        if (index != -1) {
            num += 3 * (int) Math.pow(10, index);
        }
        return num;
    }

}
