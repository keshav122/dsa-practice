package com.roadmap.beginnerproblems.patterns;

public class Pattern6 {
    public void pattern6(int n) {
        // Printing (n+1-rownumber) in each row.
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n + 1 - i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }
}
