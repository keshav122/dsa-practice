package com.leetcode_practice.problems.easy;

public class FindUniqueIntegersAddingUpToZero_1304 {
    public int[] sumZero(int n) {
        int[] ans = new int[n];
        if (n % 2 == 1) {
            ans[0] = 0;
            int k = 1;
            for (int i = 1; i <= n / 2; i++) {
                ans[k++] = i;
                ans[k++] = -i;
            }
            return ans;
        } else {
            int k = 0;
            for (int i = 1; i <= n / 2; i++) {
                ans[k++] = i;
                ans[k++] = -i;
            }
            return ans;
        }

    }

    public int[] sumZero_moreClean(int n) {
        int[] ans = new int[n];
        int k = 0;

        // If n is odd, keep one slot for zero
        if (n % 2 == 1) {
            ans[k++] = 0;
        }

        // Fill remaining slots with symmetric pairs
        for (int i = 1; k < n; i++) {
            ans[k++] = i;
            ans[k++] = -i;
        }
        return ans;
    }
}
