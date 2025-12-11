package com.leetcode_practice.problems.medium;

public class CountTheNumberOfComputerUnlockingPermutations_3577 {
    public int countPermutations(int[] complexity) {
        int MOD = (int) (1e9) + 7;
        int n = complexity.length;
        for (int i = 1; i < n; i++) {
            if (complexity[i] <= complexity[0]) {
                return 0;
            }
        }
        return fact(n - 1, MOD);
    }

    private int fact(int n, int MOD) {
        long res = 1;
        for (int i = 1; i <= n; i++) {
            res = ((res % MOD) * i) % MOD;
        }
        return (int) res;
    }
}
