package com.dsa_series.roadmap.sliding_window_and_two_pointers.constant_window;

public class MaxPointsYouCanObtainFromCards {
    public int maxScore(int[] cardScore, int k) {
        int n = cardScore.length;
        int leftIndex = n - k, rightIndex = n - 1;
        int currentSum = 0;

        for (int i = leftIndex; i <= rightIndex; i++) {
            currentSum += cardScore[i];
        }

        int maxScore = currentSum;

        while (leftIndex < n) {
            currentSum -= cardScore[leftIndex];
            leftIndex++;
            rightIndex++;
            currentSum += cardScore[rightIndex % n];
            maxScore = Math.max(maxScore, currentSum);
        }

        return maxScore;
    }
}
