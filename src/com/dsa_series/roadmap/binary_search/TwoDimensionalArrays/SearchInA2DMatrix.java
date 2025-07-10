package com.dsa_series.roadmap.binary_search.TwoDimensionalArrays;

public class SearchInA2DMatrix {
    public boolean searchMatrix_BF(int[][] mat, int target) {
        int n = mat.length;
        int m = mat[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean searchMatrix(int[][] mat, int target) {
        int n = mat.length;
        int m = mat[0].length;
        for (int i = 0; i < n; i++) {
            if (mat[i][0] <= target && mat[i][m - 1] >= target) {
                return isPresent(mat[i], target);
            } else if (mat[i][0] >= target || mat[i][m - 1] > target) {
                return false;
            }
        }
        return false;
    }

    public boolean isPresent(int[] arr, int target) {
        int n = arr.length;
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == target) {
                return true;
            } else if (arr[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }

    public boolean searchMatrixOptimal(int[][] mat, int target) {
        int n = mat.length;
        int m = mat[0].length;
        int low = 0;
        int high = n * m - 1;
        while (low <= high) {
            int mid = (low + high) >> 1;
            // The intuition for row and column values can be obtained by
            // writing out indices if 2D matrix was converted into a flattened 1D matrix
            int row = mid / m;
            int col = mid % m;
            if (mat[row][col] == target) {
                return true;
            } else if (mat[row][col] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] mat = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
        SearchInA2DMatrix search = new SearchInA2DMatrix();
        System.out.println(search.searchMatrix(mat, 8));
    }
}
