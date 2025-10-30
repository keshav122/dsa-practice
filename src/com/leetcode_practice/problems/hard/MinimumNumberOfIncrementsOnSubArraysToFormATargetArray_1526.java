package com.leetcode_practice.problems.hard;

import java.util.ArrayList;
import java.util.List;

public class MinimumNumberOfIncrementsOnSubArraysToFormATargetArray_1526 {

    // Gives TLE
    public int minNumberOperations(int[] target) {
        int n = target.length;
        int operations = 1;
        int[] initial = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += target[i];
            initial[i] = 1;
        }
        int j = 0;
        while (j < sum) {
            List<Pair> pairs = getSubGroups(initial, target, n);
            if (pairs.size() == 0) {
                return operations;
            } else {
                operations += pairs.size();
                for (Pair p : pairs) {
                    int start = p.start;
                    int end = p.end;
                    for (int i = start; i < end; i++) {
                        initial[i]++;
                    }
                }
            }
            j++;
        }
        return operations;
    }

    private List<Pair> getSubGroups(int[] initial, int[] target, int n) {
        List<Pair> pairs = new ArrayList<>();
        int rangeStart = 0, i = 0;
        while (i < n) {
            if (initial[i] == target[i]) {
                if (i != rangeStart) {
                    pairs.add(new Pair(rangeStart, i));
                }

                while (i < n && initial[i] == target[i]) {
                    i++;
                }
                rangeStart = i;
            } else {
                i++;
            }
        }
        if (rangeStart < n) {
            pairs.add(new Pair(rangeStart, n));
        }

        return pairs;
    }

    public int minNumberOperations_optimal(int[] target) {
        int operations = target[0];
        for (int i = 1; i < target.length; i++) {
            if (target[i] > target[i - 1]) {
                operations += target[i] - target[i - 1];
            }
        }
        return operations;
    }

    public static void main(String[] args) {
        int[] a = { 3, 1, 1, 2 };
        MinimumNumberOfIncrementsOnSubArraysToFormATargetArray_1526 obj = new MinimumNumberOfIncrementsOnSubArraysToFormATargetArray_1526();
        System.out.println(obj.minNumberOperations(a));
    }
}

class Pair {
    int start;
    int end;

    Pair(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
