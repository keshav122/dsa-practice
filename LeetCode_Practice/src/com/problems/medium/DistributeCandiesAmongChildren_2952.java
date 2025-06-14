package com.problems.medium;

public class DistributeCandiesAmongChildren_2952 {

    public long distributeCandies_BF(int n, int limit) {
        long ways = 0;
        for (int i = 0; i <= limit; i++) {
            int target = n - i;
            for (int j = 0; j <= limit; j++) {
                int k = target - j;
                if (k <= limit && k >= 0)
                    ways++;
            }
        }
        return ways;
    }

    public long distributeCandies(int n, int limit) {
        return countWays(n, limit);
    }

    private long countWays(int n, int limit) {
        long total = nCr(n + 2, 2);
        for (int i = 0; i < 3; i++) {
            int excess = n - (limit + 1);
            if (excess >= 0)
                total -= nCr(excess + 2, 2);
        }

        for (int i = 0; i < 3; i++) {
            for (int j = i + 1; j < 3; j++) {
                int excess = n - 2 * (limit + 1);
                if (excess >= 0)
                    total += nCr(excess + 2, 2);
            }
        }

        int excess = n - 3 * (limit + 1);
        if (excess >= 0)
            total -= nCr(excess + 2, 2);

        return total;
    }

    private long nCr(int n, int r) {
        if (n < r)
            return 0;
        if (r == 0 || r == n)
            return 1;
        long res = 1;
        for (int i = 1; i <= r; i++) {
            res *= n - r + i;
            res /= i;
        }
        return res;
    }
}
