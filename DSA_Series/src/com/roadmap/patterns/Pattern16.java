package com.roadmap.patterns;

public class Pattern16 {
    public void pattern16(int n) {
        for (int row = 0; row < n; row++) {
            char rowChar = (char) ('A' + row);
            for (int j = 0; j <= row; j++) {
                System.out.print(rowChar);
            }
            System.out.println();
        }
    }
}
