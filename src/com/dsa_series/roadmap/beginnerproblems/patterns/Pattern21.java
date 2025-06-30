package com.dsa_series.roadmap.beginnerproblems.patterns;

public class Pattern21 {
    public void pattern21(int n) {
        for (int row = 1; row <= n; row++) {
            if (row == 1 || row == n) {
                for (int j = 1; j <= n; j++) {
                    System.out.print("*");
                }
            } else {
                // Print one asterisk
                System.out.print("*");
                // Print n-2 spaces
                for (int j = 1; j < n - 1; j++) {
                    System.out.print(" ");
                }
                // Print one asterisk
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
