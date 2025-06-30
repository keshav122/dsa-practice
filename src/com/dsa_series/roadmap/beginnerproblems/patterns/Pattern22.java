package com.dsa_series.roadmap.beginnerproblems.patterns;

public class Pattern22 {
    public void pattern22(int n) {
        for (int row = 0; row < 2 * n - 1; row++) {
            for (int col = 0; col < 2 * n - 1; col++) {
                int leftDist = col;
                int topDist = row;
                int rightDist = ((2 * n - 2) - col);
                int bottomDist = ((2 * n - 2) - row);
                int minValue = Math.min(Math.min(rightDist, leftDist), Math.min(topDist, bottomDist));
                System.out.print(n - minValue + " ");
            }
            System.out.println();
        }
    }
}
