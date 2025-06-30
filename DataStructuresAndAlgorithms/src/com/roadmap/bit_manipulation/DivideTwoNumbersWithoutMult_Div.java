package com.roadmap.bit_manipulation;

public class DivideTwoNumbersWithoutMult_Div {
    public int divide_BF(int dividend, int divisor) {
        if (dividend == divisor)
            return 1;
        long count = 0;
        long sum = 0;
        boolean sign = true; // Assuming positive
        if (dividend >= 0 && divisor < 0)
            sign = false;
        if (dividend < 0 && divisor > 0)
            sign = false;
        long n = Math.abs((long) dividend);
        long d = Math.abs((long) divisor);
        while (sum + d <= n) {
            count++;
            sum += d;
        }
        if (count == Math.pow(2, 31) && sign) {
            return Integer.MAX_VALUE;
        }
        if (count == Math.pow(2, 31) && !sign) {
            return Integer.MIN_VALUE;
        }
        return (int) (sign ? count : (-1 * count));

    }

    public int divide(int dividend, int divisor) {
        if (dividend == divisor)
            return 1;

        boolean sign = true; // Assuming positive
        if (dividend >= 0 && divisor < 0)
            sign = false;
        if (dividend < 0 && divisor > 0)
            sign = false;

        long n = Math.abs((long) dividend);
        long d = Math.abs((long) divisor);

        int ans = 0;
        while (n >= d) {
            int count = 0;
            while (n >= (d << (count + 1))) {
                count++;
            }
            ans += (1 << count);
            n -= d * (1 << count);
        }

        if (ans > Integer.MAX_VALUE && sign) {
            return Integer.MAX_VALUE;
        }
        if (ans > Integer.MAX_VALUE && !sign) {
            return Integer.MIN_VALUE;
        }
        return sign ? ans : (-1 * ans);
    }
}
