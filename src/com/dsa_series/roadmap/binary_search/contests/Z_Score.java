package com.dsa_series.roadmap.binary_search.contests;

import java.util.Arrays;

public class Z_Score {
    public int ZScore(int[] marks, int k) {
        int n = marks.length;
        Arrays.sort(marks);
        int low = 1, high = n, ans = 0;
        while (low <= high) {
            // mid represents the number of subjects
            int mid = (low + high) >> 1;
            int score = mid * k;
            if (isPossible(marks, score, mid, n)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    public boolean isPossible(int[] marks, int score, int subjects, int n) {
        int low = 0;
        int high = n - 1;
        int ans = -1;
        while (low <= high) {
            int mid = (low + high) >> 1;
            if (marks[mid] >= score) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        if (ans == -1)
            return false;
        int count = n - ans;
        return (count >= subjects);
    }
}
