package com.dsa_series.roadmap.arrays.FAQs_Medium;

public class PascalsTriangle_I {
    public int pascalTriangleI(int r, int c) {
        return (int) nCr(r - 1, c - 1);
    }

    private long nCr(int n, int r) {
        // Choose the smaller value for lesser iterations
        if (r > n - r)
            r = n - r;
        long res = 1;
        for (int i = 0; i < r; i++) {
            res *= (n - i);
            res /= (i + 1);
        }
        return res;
    }
}
