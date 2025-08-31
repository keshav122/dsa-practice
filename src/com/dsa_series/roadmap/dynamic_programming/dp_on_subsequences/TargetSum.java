package com.dsa_series.roadmap.dynamic_programming.dp_on_subsequences;

//Same Problem as Count Subsets With Given Difference
public class TargetSum {
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

    public int targetSum(int n, int target, int[] nums) {
        return countPartitions_tab_SO(n, target, nums);
    }

}
