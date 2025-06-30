package com.dsa_series.roadmap.stacks_and_queues.FAQs;

public class CelebrityProblem {
    public int celebrity(int[][] M) {
        int n = M.length;
        for (int i = 0; i < n; i++) {
            if (areAllZeroes(M[i])) {
                return i;
            }
        }
        return -1;
    }

    private boolean areAllZeroes(int[] arr) {
        for (int a : arr) {
            if (a != 0)
                return false;
        }
        return true;
    }

    public int celebrity_BF(int[][] M) {
        int n = M.length;
        int[] knowsMe = new int[n];
        int[] iKnow = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (M[i][j] == 1) {
                    knowsMe[j]++;
                    iKnow[i]++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (knowsMe[i] == n - 1 && iKnow[i] == 0) {
                return i;
            }
        }
        return -1;
    }

    public int celebrity_Optimal(int[][] M) {
        int n = M.length;
        int top = 0, bottom = n - 1;
        while (top < bottom) {
            if (M[top][bottom] == 1) {
                top++;
            } else if (M[bottom][top] == 1) {
                bottom--;
            } else {
                top++;
                bottom--;
            }
        }

        if (top > bottom)
            return -1;

        for (int i = 0; i < n; i++) {
            if (i == top)
                continue;
            if (M[top][i] == 0 && M[i][top] == 1) {
                continue;
            } else {
                return -1;
            }
        }
        return top;
    }
}
