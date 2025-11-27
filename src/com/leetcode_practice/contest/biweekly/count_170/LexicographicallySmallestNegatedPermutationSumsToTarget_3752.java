package com.leetcode_practice.contest.biweekly.count_170;

// You are given a positive integer n and an integer target.

// Return the lexicographically smallest array of integers of size n such that:

// The sum of its elements equals target.
// The absolute values of its elements form a permutation of size n.
// If no such array exists, return an empty array.

// A permutation of size n is a rearrangement of integers 1, 2, ..., n.
public class LexicographicallySmallestNegatedPermutationSumsToTarget_3752 {

    // TODO Solve this
    public int[] lexSmallestNegatedPerm(int n, long target) {
        long absSum = (n * (n + 1)) / 2;
        if (absSum < target) {
            return new int[] {};
        } else if (absSum == target) {
            int[] res = new int[n];
            for (int i = 1; i <= n; i++) {
                res[i - 1] = i;
            }
            return res;
        } else {

        }

    }
}
