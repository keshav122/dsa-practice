package com.dsa_series.roadmap.dynamic_programming.dp_on_subsequences;

import java.util.Arrays;

public class CountPartitionsWithGivenDifference {
    static int MODOULO = (int) 1e9 + 7;

    public int countPartitions(int n, int diff, int[] arr) {
        int totalSum = 0;
        for (int a : arr) {
            totalSum += a;
        }
        // As S1 + S2 = totalSum and S1-S2 = diff
        // So desired S1 is (totalSum + diff)/2
        if ((totalSum + diff) % 2 != 0) {
            return 0;
        }
        int target = (totalSum + diff) / 2;
        // Same as count subsets sum equal to K
        return f(n - 1, target, arr);
    }

    private int f(int index, int target, int[] arr) {
        if (target == 0)
            return 1;
        if (index == 0)
            return (arr[index] == target) ? 1 : 0;

        int notTake = f(index - 1, target, arr);
        int take = 0;
        if (arr[index] <= target) {
            take = f(index - 1, target - arr[index], arr);
        }
        return take + notTake;
    }

    public int countPartitions_m(int n, int diff, int[] arr) {
        int totalSum = 0;
        for (int a : arr) {
            totalSum += a;
        }
        // As S1 + S2 = totalSum and S1-S2 = diff
        // So desired S1 is (totalSum + diff)/2
        int target = (totalSum + diff) / 2;
        if ((totalSum + diff) % 2 != 0)
            return 0;
        int[][] dp = new int[n][target + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        // Same as count subsets sum equal to K
        return f(n - 1, target, arr, dp);
    }

    private int f(int index, int target, int[] arr, int[][] dp) {

        if (index == 0) {
            if (target == 0 && arr[0] == 0)
                return 2;
            if (target == 0 || arr[0] == 0)
                return 1;
            return 0;
        }

        if (dp[index][target] != -1)
            return dp[index][target];
        int notTake = f(index - 1, target, arr, dp);
        int take = 0;
        if (arr[index] <= target) {
            take = f(index - 1, target - arr[index], arr, dp);
        }
        return dp[index][target] = (take + notTake) % MODOULO;
    }

    public int countPartitions_tab(int n, int diff, int[] arr) {
        int totalSum = 0;
        for (int a : arr) {
            totalSum += a;
        }

        if ((totalSum + diff) % 2 != 0 || totalSum < diff)
            return 0;
        int target = (totalSum + diff) / 2;
        return countSubsetsWithSum(arr, target);

    }

    private int countSubsetsWithSum(int[] arr, int target) {
        int MODOULO = (int) 1e9 + 7;
        int n = arr.length;
        int[][] dp = new int[n][target + 1];

        if (arr[0] == 0) {
            dp[0][0] = 2;// Either take the element which is 0 or not at all pick the element
        } else {
            dp[0][0] = 1;
            if (arr[0] <= target) {
                dp[0][arr[0]] = 1;
            }
        }

        for (int i = 1; i < n; i++) {
            for (int k = 0; k <= target; k++) {
                int notTake = dp[i - 1][k];
                int take = 0;
                if (arr[i] <= k) {
                    take = dp[i - 1][k - arr[i]];
                }
                dp[i][k] = (take + notTake) % MODOULO;
            }
        }
        return dp[n - 1][target];
    }

    public int countPartitions_tab_SO(int n, int diff, int[] arr) {
        int totalSum = 0;
        for (int a : arr) {
            totalSum += a;
        }

        if ((totalSum + diff) % 2 != 0 || totalSum < diff)
            return 0;
        int target = (totalSum + diff) / 2;
        return countSubsetsWithSum_SO(arr, target);

    }

    private int countSubsetsWithSum_SO(int[] arr, int target) {
        int MODOULO = (int) 1e9 + 7;
        int n = arr.length;
        int[] prev = new int[target + 1];

        if (arr[0] == 0) {
            prev[0] = 2;// Either take the element which is 0 or not at all pick the element
        } else {
            prev[0] = 1;
            if (arr[0] <= target) {
                prev[arr[0]] = 1;
            }
        }

        for (int i = 1; i < n; i++) {
            int[] curr = new int[target + 1];
            for (int k = 0; k <= target; k++) {
                int notTake = prev[k];
                int take = 0;
                if (arr[i] <= k) {
                    take = prev[k - arr[i]];
                }
                curr[k] = (take + notTake) % MODOULO;
            }
            prev = curr;
        }
        return prev[target];
    }
}
