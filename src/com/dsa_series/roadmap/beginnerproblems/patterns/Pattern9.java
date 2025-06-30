package com.dsa_series.roadmap.beginnerproblems.patterns;

public class Pattern9 {

    public void pattern9(int n) {
        printUpperHalf(n);
        printLowerHalf(n);
    }

    private void printLowerHalf(int n) {
        for (int i = n - 1; i >= 0; i--) {
            // Printing spaces on the left part
            for (int j = 1; j < (n - i); j++) {
                System.out.print(" ");
            }
            // Printing asterisk in the middle
            for (int j = 1; j <= (2 * i + 1); j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private void printUpperHalf(int n) {
        for (int i = 0; i < n; i++) {
            // Printing spaces on the left part
            for (int j = 1; j < (n - i); j++) {
                System.out.print(" ");
            }
            // Printing asterisk in the middle
            for (int j = 1; j <= (2 * i + 1); j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
