/*Author: keshav122 */
package com.roadmap.beginnerproblems.patterns;

public class Pattern19 {
    public void pattern19(int n) {
        printUpperHalf(n);
        printLowerHalf(n);
    }

    private void printUpperHalf(int n) {
        // Print Upper half
        for (int i = 0; i < n; i++) {
            // Print asterisks on left end
            for (int j = 0; j < n - i; j++) {
                System.out.print("*");
            }
            for (int j = 1; j <= 2 * i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < n - i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private void printLowerHalf(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            for (int j = 1; j <= 2 * (n - i); j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
