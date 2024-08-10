package com.roadmap.patterns;

public class Pattern10 {
    public void pattern10(int n) {
        printUpperHalf(n);
        printLowerHalf(n - 1);
    }

    private void printLowerHalf(int n) {
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private void printUpperHalf(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
