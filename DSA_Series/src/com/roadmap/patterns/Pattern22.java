package com.roadmap.patterns;

public class Pattern22 {
    public void pattern22(int n) {
        for (int row = 0; row < 2 * n - 1; row++) {
            for (int col = 0; col <= 2 * n - 1; col++) {
                System.out.println(Math.max(Math.max(row, n - row), Math.max(col, n - col)));
            }
            System.out.println();
        }
    }
}
