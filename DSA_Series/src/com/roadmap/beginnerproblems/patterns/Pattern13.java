package com.roadmap.beginnerproblems.patterns;

public class Pattern13 {
    public void pattern13(int n) {
        int count = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(count + " ");
                count++;
            }

            System.out.println();
        }
    }
}
