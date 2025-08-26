package com.leetcode_practice.problems.easy;

public class LongestDiagonalArea_3000 {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int area = 0;
        int maxDiagonalLength = 0;
        for (int[] a : dimensions) {
            int diagonalLength = a[0] * a[0] + a[1] * a[1];
            if (diagonalLength > maxDiagonalLength) {
                area = a[0] * a[1];
                maxDiagonalLength = diagonalLength;
            } else if (diagonalLength == maxDiagonalLength) {
                area = Math.max(area, a[0] * a[1]);
            }
        }
        return area;
    }
}
