package com.leetcode_practice.contest.weekly.count_480;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MinimumMovesToBalanceCircularArray_3776 {

    public long minMoves(int[] balance) {
        long sum = 0;
        int n = balance.length;
        int k = -1;
        for (int i = 0; i < n; i++) {
            sum += balance[i];
            if (balance[i] < 0) {
                k = i;
            }
        }
        if (sum < 0)
            return -1;
        if (k == -1)
            return 0;
        long need = -balance[k];

        List<int[]> suppliers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i == k || balance[i] <= 0)
                continue;
            int distance = Math.min((i - k + n) % n, (k - i + n) % n);
            suppliers.add(new int[] { distance, balance[i] });
        }

        Collections.sort(suppliers, Comparator.comparingInt((int[] a) -> a[0]));
        long moves = 0;
        for (int[] s : suppliers) {
            if (need == 0)
                break;
            long take = Math.min(need, s[1]);
            moves += take * s[0];
            need -= take;
        }
        return need == 0 ? moves : -1;

    }

    public long minMoves_optimal(int[] balance) {
        long sum = 0;
        int n = balance.length;
        int k = -1;
        for (int i = 0; i < n; i++) {
            sum += balance[i];
            if (balance[i] < 0) {
                k = i;
            }
        }
        if (sum < 0)
            return -1;
        if (k == -1)
            return 0;
        long need = -balance[k];
        int maxDist = n / 2;
        // This stores positive units of balance available at (i+1) distance
        long[] bucket = new long[maxDist + 1];
        for (int i = 0; i < n; i++) {
            if (i == k || balance[i] <= 0)
                continue;
            int d1 = (i - k + n) % n;
            int d2 = (k - i + n) % n;
            int distance = Math.min(d1, d2);
            bucket[distance] += balance[i];
        }

        long moves = 0;
        for (int d = 1; d <= maxDist && need > 0; d++) {
            long take = Math.min(need, bucket[d]);
            need -= take;
            moves += take * d;
        }
        return need == 0 ? moves : -1;
    }

}