package com.leetcode_practice.problems.medium;

import com.contests.codeforces.round_1047_Div3.A;

public class FourDivisors_1930 {
    public int sumFourDivisors(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += getSum(num);
        }
        return sum;
    }

    private int getSum(int n) {
        int count = 0;
        int sum = 0;
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                if (i != n / i) {
                    sum += i;
                    sum += n / i;
                    count += 2;
                } else {
                    sum += i;
                    count++;
                }

                if (count > 4)
                    return 0;
            }
        }
        if (count == 4)
            return sum;
        return 0;
    }

    // A number has exactly 4 divisors only if it is either p³ or p×q (p ≠ q
    // primes).So instead of counting divisors, we detect these forms directly and
    // compute the sum
    public int sumFourDivisors_gpt(int[] nums) {
        int res = 0;
        for (int n : nums) {
            res += fourDivisorSum(n);
        }
        return res;
    }

    private int fourDivisorSum(int n) {
        int p = smallestPrimeFactor(n);

        if (p == -1)
            return 0;

        int q = n / p;

        // Case 1: p^3
        if (q == p * p && isPrime(p)) {
            return 1 + p + p * p + n;
        }

        // Case 2: p * q (distinct primes)
        if (p != q && isPrime(q)) {
            return 1 + p + q + n;
        }

        return 0;
    }

    private int smallestPrimeFactor(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0)
                return i;
        }
        return -1;
    }

    private boolean isPrime(int n) {
        if (n < 2)
            return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

}
