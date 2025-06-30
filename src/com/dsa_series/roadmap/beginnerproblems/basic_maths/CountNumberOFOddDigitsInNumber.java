package com.dsa_series.roadmap.beginnerproblems.basic_maths;

public class CountNumberOFOddDigitsInNumber {
    public int countOddDigit(int n) {
        if (n == 0)
            return 0;
        int oddDigitCount = 0;
        while (n > 0) {
            // We extract the digits by doing the modulus of number by 10.
            int lastDigit = n % 10;
            if (lastDigit % 2 == 1) {
                oddDigitCount++;
            }
            n /= 10;
        }
        return oddDigitCount;
    }
}
