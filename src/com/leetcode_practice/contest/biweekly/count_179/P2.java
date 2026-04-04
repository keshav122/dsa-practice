package com.leetcode_practice.contest.biweekly.count_179;

public class P2 {
    public int countVisiblePeople(int n, int pos, int k) {
        int MOD = 1_000_000_007;
        if (k == 0)
            return 2;
        int leftSize = pos;
        int rightSize = n - 1 - pos;
        // l denotes nos chosen from left , so we move from choosing nothing from left
        // to everything from left
        long options = 2;
        if (leftSize == 0) {
            if (rightSize >= k) {
                return (int) (options + nCr(rightSize, k) % MOD) % MOD;
            } else {
                return 2;
            }
        }

        if (rightSize == 0) {
            if (leftSize >= k) {
                return (int) (options + nCr(leftSize, k) % MOD) % MOD;
            } else {
                return 2;
            }
        }
        for (int l = 0; l <= Math.min(leftSize, k); l++) {
            int r = k - l;
            if (r > rightSize)
                continue;
            long lOptions = nCr(leftSize, l) % MOD;
            long rOptions = nCr(rightSize, r) % MOD;
            options = (options + (lOptions + rOptions) % MOD) % MOD;
        }
        return (int) (options);
    }

    private long nCr(int n, int r) {
        if (r > n - r)
            r = n - r;
        long res = 1;
        for (int i = 0; i < r; i++) {
            res *= (n - i);
            res /= (i + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        P2 p = new P2();
        int n = 2;
        int pos = 1;
        int k = 1;
        System.out.println(p.countVisiblePeople(n, pos, k));
    }
}
