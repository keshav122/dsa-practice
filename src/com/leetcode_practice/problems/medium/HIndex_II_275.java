package com.leetcode_practice.problems.medium;

//Test cases : [0] expected : 0
//[11,15] : expected 2
//[0,1,3,5,6] expected 3
//Check why low <= high created a array Index oob
public class HIndex_II_275 {

    public int hIndex_BF(int[] citations) {
        int n = citations.length;
        int ans = 0;
        for (int paper = 1; paper <= n; paper++) {
            int count = 0;
            for (int cited : citations) {
                if (cited >= paper)
                    count++;
            }
            if (count >= paper) {
                ans = ans > paper ? ans : paper;
            }
        }
        return ans;
    }

    public int hIndex_better(int[] citations) {
        int n = citations.length;
        int low = 0, high = n, ans = 0;
        while (low <= high) {
            // mid represents the number of subjects
            int midPapers = (low + high) >> 1;
            int count = 0;
            for (int cited : citations) {
                if (cited >= midPapers)
                    count++;
            }
            if (count >= midPapers) {
                ans = ans > midPapers ? ans : midPapers;
                low = midPapers + 1;
            } else {
                high = midPapers - 1;
            }
        }
        return ans;
    }

    // Because citations is a sorted array -- we can use binary search to find out
    // number of citations greater than midPapers -- upper bound of midPapers
    public int hIndex_best(int[] citations) {
        int n = citations.length;
        int low = 0, high = n, ans = 0;
        while (low <= high) {
            // mid represents the number of subjects
            int midPapers = (low + high) >> 1;
            int count = n - lowerBound(citations, midPapers, n);
            if (count >= midPapers) {
                ans = ans > midPapers ? ans : midPapers;
                low = midPapers + 1;
            } else {
                high = midPapers - 1;
            }
        }
        return ans;
    }

    private int lowerBound(int[] citations, int paper, int n) {
        int low = citations[0], high = citations[n - 1];
        while (low <= high) {
            int mid = (low + high) >> 1;
            if (citations[mid] >= paper) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    // Without the count and ans variables
    public int hIndex(int[] citations) {
        int n = citations.length;
        int low = 0, high = n;
        while (low <= high) {
            // mid represents the number of subjects
            int midPapers = (low + high) >> 1;
            if ((n - lowerBound(citations, midPapers, n)) >= midPapers) {
                low = midPapers + 1;
            } else {
                high = midPapers - 1;
            }
        }
        return high;
    }

}
