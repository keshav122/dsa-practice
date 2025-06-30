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
        // the rows becomes the columns and vice-versa
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Reverse it
        for (int i = 0; i < n; i++) {
            reverseArr(matrix[i], n);
        }

    }

    private void reverseArr(int[] arr, int n) {
        int i = 0;
        int j = n - 1;
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        int[][] input = { { 0, 1, 1, 2 }, { 2, 0, 3, 1 }, { 4, 5, 0, 5 }, { 5, 6, 7, 0 } };
        RotateMatrixBy90Degrees r = new RotateMatrixBy90Degrees();
        r.rotateMatrix(input);
    }
}
