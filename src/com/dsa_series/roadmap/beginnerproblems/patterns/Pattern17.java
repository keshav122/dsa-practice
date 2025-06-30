package com.dsa_series.roadmap.beginnerproblems.patterns;

public class Pattern17 {
    public void pattern17(int n) {
        for (int i = 1; i <= n; i++) {
            // Printing spaces on the left part
            for (int j = 1; j <= (n - i); j++) {
                System.out.print(" ");
            }
            printLeftHalf(i);
            printRightHalf(i - 1);
            System.out.println();
        }
    }

    private void printLeftHalf(int n) {
        char start = 'A';
        for (int j = 0; j < n; j++) {
            System.out.print((char) (start + j));
        }
    }

    private void printRightHalf(int n) {
        char start = 'A';
        for (int j = n; j > 0; j--) {
            System.out.print((char) (start + j));
        }
    }
}
