package com.dsa_series.roadmap.dynamic_programming.dp_on_subsequences;

import java.util.Arrays;

//From the tabulation solution of subset sum equals target we have derived that if our target is 'k'
//Using the tabulation we can tell for all the values between 1 and k that whether they they are achievable
//upto a particular index 

public class PartititonSetIntoSubsequencesOfMinAbsDifference {

    public boolean f(int[] arr, int index, int target) {
        if (target == 0)
            return true;
        if (index == 0)
            return (arr[index] == target);
        boolean notTake = f(arr, index - 1, target);
        boolean take = false;
        if (target >= arr[index]) {
            take = f(arr, index - 1, target - arr[index]);
        }
        return take || notTake;
    }

    public int minDifference_rec(int[] arr, int n) {
        int sum = 0;
        for (int a : arr) {
            sum += a;
        }

        int mini = Integer.MAX_VALUE;
        for (int i = 0; i <= sum; i++) {
            if (f(arr, n - 1, i) == true) {
                int diff = Math.abs(i - (sum - i));
                mini = Math.min(mini, diff);
            }
        }
        return mini;
    }

    public boolean f(int[] arr, int index, int target, int[][] dp) {
        if (target == 0)
            return true;
        if (index == 0)
            return (arr[index] == target);
        if (dp[index][target] != -1)
            return dp[index][target] == 1 ? true : false;
        boolean notTake = f(arr, index - 1, target);
        boolean take = false;
        if (target >= arr[index]) {
            take = f(arr, index - 1, target - arr[index]);
        }
        dp[index][target] = (take || notTake) ? 1 : 0;
        return take || notTake;
    }

    public int minDifference_mem(int[] arr, int n) {
        int sum = 0;
        for (int a : arr) {
            sum += a;
        }
        int[][] dp = new int[n][sum + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        int mini = (int) (1e9);
        for (int i = 0; i <= sum; i++) {
            if (f(arr, n - 1, i, dp) == true) {
                int diff = Math.abs(i - (sum - i));
                mini = Math.min(mini, diff);
            }
        }
        return mini;
    }

    public int minDifference_tab(int[] arr, int n) {
        int sum = 0;
        for (int a : arr) {
            sum += a;
        }
        int target = sum;
        boolean[][] dp = new boolean[n][target + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        if (arr[0] <= target) {
            dp[0][arr[0]] = true;
        }
        for (int i = 1; i < n; i++) {
            for (int k = 1; k <= target; k++) {
                boolean notTake = dp[i - 1][k];
                boolean take = false;
                if (arr[i] <= k) {
                    take = dp[i - 1][k - arr[i]];
                }
                dp[i][k] = take || notTake;
            }
        }

        int mini = (int) (1e9);
        for (int s1 = 0; s1 <= sum / 2; s1++) {
            if (dp[n - 1][s1]) {
                // s2 would be (sum - i) and the diff would be sum - i - i
                mini = Math.min(mini, Math.abs(sum - 2 * s1));
            }
        }
        return mini;
    }

    public int minDifference_tab_so(int[] arr, int n) {
        int sum = 0;
        for (int a : arr) {
            sum += a;
        }
        int target = sum;
        boolean[] prev = new boolean[target + 1];
        prev[0] = true;
        if (arr[0] <= target) {
            prev[arr[0]] = true;
        }

        for (int i = 1; i < n; i++) {
            boolean[] curr = new boolean[target + 1];
            curr[0] = true;
            for (int j = 1; j <= target; j++) {
                boolean notTake = prev[j];
                boolean take = false;
                if (j >= arr[i]) {
                    take = prev[j - arr[i]];
                }
                curr[j] = take || notTake;
            }
            prev = curr;
        }

        int mini = (int) (1e9);
        for (int s1 = 0; s1 <= sum / 2; s1++) {
            if (prev[s1]) {
                // s2 would be (sum - i) and the diff would be sum - i - i
                mini = Math.min(mini, Math.abs(sum - 2 * s1));
            }
        }
        return mini;
    }
}
