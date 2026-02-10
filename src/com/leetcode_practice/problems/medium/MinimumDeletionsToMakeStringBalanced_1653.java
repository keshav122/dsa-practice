package com.leetcode_practice.problems.medium;

public class MinimumDeletionsToMakeStringBalanced_1653 {
    public int minimumDeletions(String s) {
        int n = s.length();
        int[] bPrefix = new int[n];
        if (s.charAt(0) == 'b')
            bPrefix[0] = 1;
        int[] aSuffix = new int[n];
        if (s.charAt(n - 1) == 'a')
            aSuffix[n - 1] = 1;
        for (int i = 1; i < n; i++) {
            bPrefix[i] = (s.charAt(i) == 'b') ? bPrefix[i - 1] + 1 : bPrefix[i - 1];
        }

        for (int i = n - 2; i >= 0; i--) {
            aSuffix[i] = s.charAt(i) == 'a' ? aSuffix[i + 1] + 1 : aSuffix[i + 1];
        }

        int count = 100000;
        for (int i = 0; i < n; i++) {
            count = Math.min(count, bPrefix[i] + aSuffix[i] - 1);
        }
        return count;
    }

    public int minimumDeletions_optimal(String s) {
        int deletions = 0;
        int bCount = 0;
        for (int i = 0; i < s.length(); i++) {
            // Deletion of b upto this index
            if (s.charAt(i) == 'b') {
                bCount++;
            } else {
                // Either delete this 'a' (deletions + 1)
                // OR delete all previous 'b's (bCount)
                deletions = Math.min(deletions + 1, bCount);
            }
        }
        return deletions;
    }

}
