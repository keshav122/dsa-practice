package com.roadmap.patterns;

public class Pattern2 {
    public void pattern2(int n) {
        // The pattern is a 1-n increasing order of asterisks
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
