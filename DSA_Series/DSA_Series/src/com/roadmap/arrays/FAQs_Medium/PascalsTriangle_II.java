package com.roadmap.arrays.FAQs_Medium;

public class PascalsTriangle_II {
    public int[] pascalTriangleIIBF(int r) {
        int[] res = new int[r];
        for (int i = 0; i < r; i++) {
            res[i] = (int) nCr(r - 1, i);
        }
        return res;
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

    public int[] pascalTriangleII(int r) {
        int[] result = new int[r];
        result[0] = 1;
        for (int i = 1; i < r; i++) {
            result[i] = (result[i - 1] * (r - i)) / i;
        }
        return result;
    }
}
