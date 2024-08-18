package com.roadmap.beginnerproblems.basic_maths;

public class PerfectNumber {
    public boolean isPerfect(int n) {
        // We start with 1 so that we don't have to deal with 1 as a proper divisor
        int divisorSum = 1;
        int div = 2;
        // div represents the divisor here
        while (div * div <= n) {
            if (n % div == 0 && div != (n / div)) {
                if (div != (n / div)) {
                    divisorSum += (div) + (n / div);
                } else {
                    // For square roots , we should add the divisor only once
                    divisorSum += (div);
                }

            }
            div++;
        }
        return (divisorSum == n);
    }
}
