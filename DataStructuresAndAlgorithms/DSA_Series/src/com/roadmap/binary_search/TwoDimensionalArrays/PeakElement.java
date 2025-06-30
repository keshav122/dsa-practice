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

    public int[] findPeakGrid(int[][] mat) {
        int[] ans = new int[2];
        int n = mat.length;
        int m = mat[0].length;
        int low = 0;
        int high = m - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            // get the index of the max value in that column
            int index = getMaxIndex(mat, n, m, mid);
            int left = (mid - 1 >= 0) ? mat[index][mid - 1] : -1;
            int right = (mid < m - 1) ? mat[index][mid + 1] : -1;
            if (mat[index][mid] > left && mat[index][mid] > right) {
                ans[0] = index;
                ans[1] = mid;
                return ans;
            } else if (mat[index][mid] < left) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public int getMaxIndex(int[][] mat, int n, int m, int mid) {
        int index = 0;
        int maxVal = mat[0][mid];
        for (int i = 1; i < n; i++) {
            if (mat[i][mid] > maxVal) {
                index = i;
                maxVal = mat[i][mid];
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[][] mat = { { 10, 7 }, { 11, 17 } };
        PeakElement p = new PeakElement();
        int[] ans = p.findPeakGrid(mat);
        System.out.println(ans[0] + " " + ans[1]);
    }

}
