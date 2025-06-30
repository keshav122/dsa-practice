package com.roadmap.greedy_algorithms.scheduling_and_interval_problems;

import java.util.Arrays;
import java.util.Comparator;

public class JobSequencingProblem {
    public int[] JobScheduling(int[][] Jobs) {
        int n = Jobs.length;
        // Sorting the Jobs array based on profit
        Arrays.sort(Jobs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o2[2], o1[2]);
            }

        });
        int maxDeadline = -1;
        for (int i = 0; i < n; i++) {
            maxDeadline = Math.max(maxDeadline, Jobs[i][1]);
        }
        int[] hash = new int[maxDeadline + 1];
        int count = 0, maxProfit = 0;

        for (int i = 0; i < n; i++) {
            for (int j = Jobs[i][1]; j > 0; j--) {
                if (hash[j] == 0) {
                    count++;
                    maxProfit += Jobs[i][2];
                    hash[j] = Jobs[i][0];
                    break;
                }
            }
        }
        int[] ans = new int[2];
        ans[0] = count;
        ans[1] = maxProfit;
        return ans;
    }
}
