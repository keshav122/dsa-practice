package com.roadmap.patterns;

public class Pattern3 {
    public void pattern3(int n) {
        // The pattern is a 1-n increasing order of values
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }
}
