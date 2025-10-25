/*Author: keshav122 */
package com.dsa_series.roadmap.binary_search.TwoDimensionalArrays;

public class SearchInA2DMatrixII {
    public boolean searchMatrix_BF(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean searchMatrix_Better(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        for (int i = 0; i < n; i++) {
            if (matrix[i][0] <= target && matrix[i][m - 1] >= target) {
                if (isPresent(matrix[i], target)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean searchMatrix_Optimal(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int row = 0;
        int col = m - 1;
        while (row < n && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                row++;
            } else {
                col--;
            }
        }
        return false;
    }

    public static boolean isPresent(int[] arr, int target) {
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

    public static void main(String[] args)

    {
        int[][] matrix = { { -414, -328 }, { -408, -327 }, { -336, -292 }, { -262, -207 }, { -202, -102 },
                { -167, -43 }, { -128, -21 }, { -57, 2 }, { 8, 45 }, { 63, 112 }, { 91, 206 }, { 120, 214 },
                { 178, 218 }, { 235, 309 }, { 318, 325 }, { 389, 462 }, { 425, 495 }, { 473, 507 }, { 484, 598 },
                { 532, 674 }, { 577, 753 }, { 598, 789 }, { 695, 839 }, { 735, 919 }, { 797, 988 }, { 859, 1009 },
                { 947, 1071 } };
        SearchInA2DMatrix search2 = new SearchInA2DMatrix();
        int target = 988;
        System.out.println(searchMatrix_Optimal(matrix, target));
    }
}
