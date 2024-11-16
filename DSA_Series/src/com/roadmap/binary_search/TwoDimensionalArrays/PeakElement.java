package com.roadmap.binary_search.TwoDimensionalArrays;

public class PeakElement {

    public int[] findPeakGrid_BF(int[][] mat) {
        int[] ans = new int[2];
        int n = mat.length;
        int m = mat[0].length;
        for (int i = 0; i < n; i++) {
            boolean isGreaterThanLeft = false, isGreaterThanRight = false, isGreaterThanTop = false,
                    isGreaterThanBottom = false;
            for (int j = 0; j < m; j++) {
                isGreaterThanLeft = ((j == 0) || (j > 0 && mat[i][j] > mat[i][j - 1])) ? true : false;
                isGreaterThanRight = ((j == m - 1) || (j < m - 1 && mat[i][j] > mat[i][j + 1])) ? true : false;
                isGreaterThanTop = ((i == 0) || (i > 0 && mat[i][j] > mat[i - 1][j])) ? true : false;
                isGreaterThanBottom = ((i == n - 1) || (i < n - 1 && mat[i][j] > mat[i + 1][j])) ? true : false;

                if (isGreaterThanLeft && isGreaterThanRight && isGreaterThanTop && isGreaterThanBottom) {
                    ans[0] = i;
                    ans[1] = j;
                }
            }
        }
        return ans;
    }
}
