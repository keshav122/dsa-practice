package com.roadmap.beginnerproblems.patterns;

public class Pattern8 {
    public void pattern8(int n) {
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
}
