package com.dsa_series.roadmap.binary_search.answers;

public class PaintersPartition {
    public int paint(int A, int B, int[] C) {
        int MOD = 10000003;
        long low = C[0];
        long high = 0;
        for (int board : C) {
            low = Math.max(low, board);
            high += board;
        }

        long time = 0;
        while (low <= high) {
            long mid = low + ((high - low) >> 1);
            if (possible(A, C, mid)) {
                time = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return (int) (((time % MOD) * (B % MOD)) % MOD);
    }

    private boolean possible(int A, int[] C, long units) {
        int painters = 1;
        long currUnits = 0;
        for (int unit : C) {
            if (currUnits + unit <= units) {
                currUnits += unit;
            } else {
                painters++;
                currUnits = unit;
            }
        }
        return painters <= A;
    }
}
