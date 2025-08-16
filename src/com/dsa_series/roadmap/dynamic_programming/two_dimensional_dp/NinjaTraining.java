package com.dsa_series.roadmap.dynamic_programming.two_dimensional_dp;

import java.util.Arrays;

public class NinjaTraining {
    public int ninjaTraining_BF(int[][] matrix) {
        return ninjaTraining(matrix, matrix.length - 1, 3);
    }

    private int ninjaTraining(int[][] matrix, int day, int last) {
        int maxi = 0;
        if (day == 0) {
            for (int i = 0; i <= 2; i++) {
                if (i != last) {
                    maxi = Math.max(maxi, matrix[day][i]);
                }
            }
            return maxi;
        }
        maxi = 0;
        for (int i = 0; i <= 2; i++) {
            if (i != last) {
                int points = ninjaTraining(matrix, day - 1, i) + matrix[day][i];
                maxi = Math.max(maxi, points);
            }
        }
        return maxi;
    }

    public int ninjaTraining(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][4];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return ninjaTraining(matrix, n - 1, 3, dp);
    }

    private int ninjaTraining(int[][] matrix, int day, int last, int[][] dp) {
        int maxi = 0;
        if (day == 0) {
            for (int i = 0; i <= 2; i++) {
                if (i != last) {
                    maxi = Math.max(maxi, matrix[day][i]);
                }
            }
            return maxi;
        }
        if (dp[day][last] != -1)
            return dp[day][last];
        maxi = 0;
        for (int i = 0; i <= 2; i++) {
            if (i != last) {
                int points = ninjaTraining(matrix, day - 1, i, dp) + matrix[day][i];
                maxi = Math.max(maxi, points);
            }
        }
        return dp[day][last] = maxi;
    }

    public int ninjaTraining_Tabulation(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][4];
        dp[0][0] = Math.max(matrix[0][1], matrix[0][2]);
        dp[0][1] = Math.max(matrix[0][0], matrix[0][2]);
        dp[0][2] = Math.max(matrix[0][0], matrix[0][1]);
        dp[0][3] = Math.max(matrix[0][1], Math.max(matrix[0][1], matrix[0][2]));
        for (int day = 1; day < n; day++) {
            for (int last = 0; last <= 3; last++) {
                dp[day][last] = 0;
                for (int task = 0; task < 3; task++) {
                    if (task != last) {
                        // dp[day-1][task] because you are sending the info
                        // that you did the task on current day and then adding the
                        // result upto day -1
                        int points = dp[day - 1][task] + matrix[day][task];
                        dp[day][last] = Math.max(dp[day][last], points);
                    }
                }
            }
        }

        return dp[n - 1][3];
    }

    public int ninjaTraining_Tabulation_SO(int[][] matrix) {
        int n = matrix.length;
        int[] prev = new int[4];
        prev[0] = Math.max(matrix[0][1], matrix[0][2]);
        prev[1] = Math.max(matrix[0][0], matrix[0][2]);
        prev[2] = Math.max(matrix[0][0], matrix[0][1]);
        prev[3] = Math.max(matrix[0][1], Math.max(matrix[0][1], matrix[0][2]));
        for (int day = 1; day < n; day++) {
            int[] temp = new int[4];
            for (int last = 0; last <= 3; last++) {
                temp[last] = 0;
                for (int task = 0; task < 3; task++) {
                    if (task != last) {
                        temp[last] = Math.max(temp[last], prev[task] + matrix[day][task]);
                    }
                }
            }
            prev = temp;
        }

        return prev[3];
    }
}
