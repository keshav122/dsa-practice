package com.dsa_series.roadmap.beginnerproblems.basic_maths;

public class LargestDigitInNumber {
    public int largestDigit(int n) {
        if (n == 0)
            return 0;
        int largestDigit = 0;
        while (n > 0) {
            // We extract the digits by doing the modulus of number by 10.
            largestDigit = Math.max(largestDigit, n % 10);
            n /= 10;
        }
        return largestDigit;
    }
}
