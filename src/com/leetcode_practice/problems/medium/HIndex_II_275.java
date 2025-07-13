package com.leetcode_practice.problems.medium;

public class HIndex_II_275 {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int low = 1, high = n, ans = 0;
        while (low <= high) {
            // mid represents the number of subjects
            int mid = (low + high) >> 1;
            if (isPossible(citations, citations[mid], n)) {
                System.out.println("isPossible :" + mid);
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    private boolean isPossible(int[] citations, int val, int n) {
        int low = 0, high = n - 1, ans = -1;
        while (low <= high) {
            int mid = (low + high) >> 1;
            if (citations[mid] >= val) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        if (ans == -1)
            return false;

        return (val >= (n - ans));
    }
}
