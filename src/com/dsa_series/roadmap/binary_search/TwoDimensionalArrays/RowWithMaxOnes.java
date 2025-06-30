package com.dsa_series.roadmap.binary_search.TwoDimensionalArrays;

public class RowWithMaxOnes {
    public int rowWithMax1s_BF(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int currentMaxRow = -1;
        int currentMinIndex = n;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1 && j < currentMinIndex) {
                    currentMinIndex = j;
                    currentMaxRow = i;
                }
            }
        }
        return currentMaxRow;
    }

    public static int rowWithMax1s(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int currentMaxRow = -1;
        int currentMinIndex = m;
        for (int i = 0; i < n; i++) {
            int index = leastOneIndex(mat[i], m);
            if (index < currentMinIndex) {
                currentMinIndex = index;
                currentMaxRow = i;

            }
        }
        return currentMaxRow;
    }

    public static int leastOneIndex(int[] arr, int arrLen) {
        int low = 0;
        int high = arrLen - 1;
        int ans = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == 1) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] a = { { 1, 1, 1 }, { 0, 0, 1 }, { 0, 0, 0 } };
        System.out.println(rowWithMax1s(a));
    }
}
