/*Author: keshav122 */
package com.leetcode_practice.problems.easy;

public class MinimumRecolorsToGetkConsecutiveBlacks_2379 {
    // My solution
    public int minimumRecolors(String blocks, int k) {
        int l = 0, r = 0, n = blocks.length();
        int count = 0;
        int minOperationRequired = Integer.MAX_VALUE;
        int operations = 0;
        while (r < n) {
            if (blocks.charAt(r) != 'B') {
                operations++;
            }
            count++;
            if (count == k) {
                minOperationRequired = Math.min(operations, minOperationRequired);
            }
            if (count > k) {
                if (blocks.charAt(l) == 'B') {
                    count--;
                } else {
                    operations--;
                    minOperationRequired = Math.min(operations, minOperationRequired);
                }
                l++;
            }
            r++;

        }
        return minOperationRequired;
    }

    // Optimized - No need of using count as r-l+1 gives the range
    public int minimumRecolors_optimized(String blocks, int k) {
        // We are basically looking for a substring of range K with the max number of B
        // in it
        int l = 0, operations = 0, minOperations = Integer.MAX_VALUE;
        for (int r = 0; r < blocks.length(); r++) {
            if (blocks.charAt(r) == 'W') {
                operations++;
            }
            // r-l + 1 gives the window size
            if (r - l + 1 > k) {
                if (blocks.charAt(l) == 'W') {
                    operations--;
                }
                l++;
            }
            if (r - l + 1 == k) {
                minOperations = Math.min(minOperations, operations);
            }
        }
        return minOperations;
    }

}
