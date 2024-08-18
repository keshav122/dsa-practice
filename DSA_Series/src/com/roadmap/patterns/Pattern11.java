package com.roadmap.patterns;

public class Pattern11 {
    public void pattern11(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= i + 1; j++) {
                System.out.print((i + j) % 2 + " ");
            }
            System.out.println();
        }
    }
}
