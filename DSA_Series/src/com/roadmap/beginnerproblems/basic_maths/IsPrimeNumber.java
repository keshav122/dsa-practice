package com.roadmap.beginnerproblems.basic_maths;

public class IsPrimeNumber {
    public boolean isPrime(int n) {
        int div = 2;
        // div represents the divisor here
        while (div * div <= n) {
            if (n % div == 0) {
                return false;
            }
            div++;
        }
        return true;
    }
}
