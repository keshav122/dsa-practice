package com.roadmap.beginnerproblems.patterns;

public class Pattern7 {
    public void pattern7(int n) {
        for (int i = 0; i < n; i++) {
            // Printing spaces on the left part
            for (int j = 1; j < (n - i); j++) {
                System.out.print(" ");
            }
            // Printing asterisk in the middle
            for (int j = 1; j <= (2 * i + 1); j++) {
                System.out.print("*");
            }
            // Printing spaces on the right part
            for (int j = 1; j < (n - i); j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public void pattern7_better(int n) {
        for (int i = 0; i < n; i++) {
            // Printing spaces on the left part
            for (int j = 1; j < (n - i); j++) {
                System.out.print(" ");
            }
            // Printing asterisk in the middle
            for (int j = 1; j <= (2 * i + 1); j++) {
                System.out.print("*");
            }
            // The loop is not required for the right spaces because there is whole line
            // space
            // so we do not need to be manually place spaces
            System.out.println();
        }
    }
}
