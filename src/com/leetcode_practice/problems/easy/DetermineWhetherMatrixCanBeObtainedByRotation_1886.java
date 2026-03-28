package com.leetcode_practice.problems.easy;

public class DetermineWhetherMatrixCanBeObtainedByRotation_1886 {
    public boolean findRotation(int[][] mat, int[][] target) {
        int n = mat.length;
        if (isEqual(mat, target, n))
            return true;
        int[][] temp = new int[n][n];
        for (int turns = 1; turns < 4; turns++) {
            for (int i = n - 1; i >= 0; i--) {
                int[] a = mat[i];
                for (int j = 0; j < n; j++) {
                    temp[j][n - 1 - i] = a[j];
                }
            }

            if (isEqual(temp, target, n))
                return true;
            for (int k = 0; k < n; k++) {
                for (int l = 0; l < n; l++) {
                    mat[k][l] = temp[k][l];
                }
            }
        }
        return false;
    }

    private boolean isEqual(int[][] mat, int[][] target, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] != target[i][j])
                    return false;
            }
        }
        return true;
    }
}

class DeterminWhetherMatrixCanBeObtainedByRotation_1886_Solution_better {
    public boolean findRotation(int[][] mat, int[][] target) {
        int n = mat.length;
        for (int r = 0; r < 4; r++) {
            if (isEqual(mat, target, n))
                return true;
            mat = rotate(mat);
        }

        return false;
    }

    private int[][] rotate(int[][] mat) {
        int n = mat.length;
        int[][] res = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res[j][n - 1 - i] = mat[i][j];
            }
        }

        return res;
    }

    private boolean isEqual(int[][] a, int[][] b, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] != b[i][j])
                    return false;
            }
        }
        return true;
    }
}
