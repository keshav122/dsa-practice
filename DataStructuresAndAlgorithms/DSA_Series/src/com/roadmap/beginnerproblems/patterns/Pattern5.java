package com.roadmap.beginnerproblems.patterns;

public class Pattern5 {
    public void pattern5(int n) {
        // Printing (n+1-rownumber) asterisk in each row.
        for (int i = 1; i <= n; i++) {
            for (int j = n; j >= i; j--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
