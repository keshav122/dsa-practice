package com.leetcode_practice.problems.easy;

public class CountSquareSumTriplets_1925 {

    public int countTriples_BF(int n) {
        int count = 0;
        for (int i = 1; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = i * i + j * j;
                if (sum <= n * n) {
                    for (int k = Math.min(i, j); k <= n; k++) {
                        if (k * k == sum)
                            count += 2;
                    }
                }
            }
        }
        return count;
    }

    public int countTriples(int n) {
        int count = 0;
        for (int a = 1; a < n; a++) {
            for (int b = a; b < n; b++) {
                int c2 = a * a + b * b;
                int c = (int) Math.sqrt(c2);
                if (c <= n && c * c == c2)
                    count += 2;
            }
        }
        return count;
    }
}
