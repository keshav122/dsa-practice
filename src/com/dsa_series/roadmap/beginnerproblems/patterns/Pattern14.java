package com.dsa_series.roadmap.beginnerproblems.patterns;

public class Pattern14 {
    public void pattern14(int n) {
        for (int i = 1; i <= n; i++) {
            char start = 'A';
            for (int j = 0; j < i; j++) {
                System.out.print((char) (start + j));
            }
            System.out.println();
        }
    }
}
