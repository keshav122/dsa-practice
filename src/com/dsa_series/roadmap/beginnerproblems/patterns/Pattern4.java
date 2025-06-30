package com.dsa_series.roadmap.beginnerproblems.patterns;

public class Pattern4 {
    public void pattern4(int n) {
        // In this pattern each row number is printed <row-number> times.
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i);
            }
            System.out.println();
        }
    }
}
