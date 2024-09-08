package com.roadmap.arrays.FAQs_Medium;

public class RotateMatrixBy90Degrees {

    public void rotateMatrix_BF(int[][] matrix) {
        int n = matrix.length;
        int[][] temp = new int[n][n];
        for (int col = 0; col < n; col++) {
            for (int row = n - 1; row >= 0; row--) {
                temp[col][n - 1 - row] = matrix[row][col];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = temp[i][j];
            }
        }

    }

    public void rotateMatrix(int[][] matrix) {
        int n = matrix.length;
        // Transpose the matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Reverse it
        for (int i = 0; i < n; i++) {
            int j = 0, k = n - 1;
            while (j <= k) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][k];
                matrix[i][k] = temp;
                j++;
                k--;
            }
        }

    }

    public static void main(String[] args) {
        int[][] input = { { 0, 1, 1, 2 }, { 2, 0, 3, 1 }, { 4, 5, 0, 5 }, { 5, 6, 7, 0 } };
        RotateMatrixBy90Degrees r = new RotateMatrixBy90Degrees();
        r.rotateMatrix(input);
    }
}
