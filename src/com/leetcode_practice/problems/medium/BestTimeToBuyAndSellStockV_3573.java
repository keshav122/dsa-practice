package com.leetcode_practice.problems.medium;

import java.util.Arrays;

public class BestTimeToBuyAndSellStockV_3573 {
    static final long NEG_INF = -(long) 1e15;

    public long maximumProfit(int[] prices, int k) {
        // we can denote the flat , long and short state by 0 ,1 , 2
        return f(0, k, 0, prices);
    }

    private long f(int day, int k, int positionState, int[] prices) {
        if (day == prices.length) {
            return positionState == 0 ? 0 : NEG_INF;
        }
        if (positionState == 0) {
            long skip = f(day + 1, k, 0, prices);

            long openLong = NEG_INF;
            long openShort = NEG_INF;

            if (k > 0) {
                openLong = -prices[day] + f(day + 1, k, 1, prices);
                openShort = prices[day] + f(day + 1, k, 2, prices);
            }

            return Math.max(skip, Math.max(openLong, openShort));
        } else if (positionState == 1) {
            long hold = f(day + 1, k, 1, prices);
            long closeLong = -(long) 1e10;
            if (k > 0) {
                closeLong = prices[day] + f(day + 1, k - 1, 0, prices);
            }
            return Math.max(hold, closeLong);
        } else {
            long hold = f(day + 1, k, 2, prices);
            long closeShort = -(long) 1e10;
            if (k > 0) {
                closeShort = -prices[day] + f(day + 1, k - 1, 0, prices);
            }
            return Math.max(hold, closeShort);
        }
    }

    public long maximumProfit_mem(int[] prices, int k) {
        long[][][] dp = new long[prices.length][k + 1][3];
        for (long[][] mat : dp) {
            for (long[] row : mat) {
                Arrays.fill(row, -1);
            }
        }
        // we can denote the flat , long and short state by 0 ,1 , 2
        return f(0, k, 0, prices, dp);
    }

    private long f(int day, int k, int positionState, int[] prices, long[][][] dp) {
        if (day == prices.length) {
            return positionState == 0 ? 0 : NEG_INF;
        }

        if (dp[day][k][positionState] != -1)
            return dp[day][k][positionState];
        if (positionState == 0) {
            long skip = f(day + 1, k, 0, prices, dp);

            long openLong = NEG_INF;
            long openShort = NEG_INF;

            if (k > 0) {
                openLong = -prices[day] + f(day + 1, k, 1, prices, dp);
                openShort = prices[day] + f(day + 1, k, 2, prices, dp);
            }

            return dp[day][k][positionState] = Math.max(skip, Math.max(openLong, openShort));
        } else if (positionState == 1) {
            long hold = f(day + 1, k, 1, prices, dp);
            long closeLong = -(long) 1e10;
            if (k > 0) {
                closeLong = prices[day] + f(day + 1, k - 1, 0, prices, dp);
            }
            return dp[day][k][positionState] = Math.max(hold, closeLong);
        } else {
            long hold = f(day + 1, k, 2, prices, dp);
            long closeShort = -(long) 1e10;
            if (k > 0) {
                closeShort = -prices[day] + f(day + 1, k - 1, 0, prices, dp);
            }
            return dp[day][k][positionState] = Math.max(hold, closeShort);
        }
    }

    public long maximumProfit_DP(int[] prices, int k) {
        int n = prices.length;
        long[][][] dp = new long[n + 1][3][k + 1];
        for (int l = 0; l <= k; l++) {
            dp[n][0][l] = 0;
            dp[n][1][l] = NEG_INF;
            dp[n][2][l] = NEG_INF;
        }

        // i - day , j - position state , l - transactions
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < 3; j++) {
                for (int l = k; l >= 0; l--) {
                    if (j == 0) {
                        long skip = dp[i + 1][0][l];
                        long openLong = NEG_INF;
                        long openShort = NEG_INF;

                        if (l > 0) {
                            openLong = -prices[i] + dp[i + 1][1][l];
                            openShort = prices[i] + dp[i + 1][2][l];
                        }
                        dp[i][j][l] = Math.max(skip, Math.max(openLong, openShort));
                    } else if (j == 1) {
                        long hold = dp[i + 1][1][l];
                        long closeLong = -(long) 1e10;
                        if (l > 0) {
                            closeLong = prices[i] + dp[i + 1][0][l - 1];
                        }
                        dp[i][j][l] = Math.max(hold, closeLong);
                    } else {
                        long hold = dp[i + 1][2][l];
                        long closeShort = -(long) 1e10;
                        if (l > 0) {
                            closeShort = -prices[i] + dp[i + 1][0][l - 1];
                        }
                        dp[i][j][l] = Math.max(hold, closeShort);
                    }
                }
            }
        }

        return dp[0][0][k];
    }

}
