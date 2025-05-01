package com.roadmap.beginnerproblems.patterns;

public class Pattern1 {
    public void pattern1(int n) {
        // The pattern is a n*n square of asterisks
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
