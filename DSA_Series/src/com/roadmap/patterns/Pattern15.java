package com.roadmap.patterns;

public class Pattern15 {
    public void pattern15(int n) {
        for (int row = 1; row <= n; row++) {
            char start = 'A';
            for (int j = 0; j < n - row; j++) {
                System.out.print((char) (start + j));
            }
            System.out.println();
        }
    }
}
