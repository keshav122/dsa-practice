package com.roadmap.binary_search.TwoDimensionalArrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MatrixMedian {
    public int findMedian_BF(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                list.add(matrix[i][j]);
            }
        }
        Collections.sort(list);
        int medianLen = (n * m) / 2;
        return list.get(medianLen);
    }

    // The thought process is that the (No. of elements <= median) would always be
    // greater than
    // required elements on left half (which is (n*m)/2)
    public int findMedian(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        int req = (m * n) / 2;
        for (int i = 0; i < n; i++) {
            low = Math.min(low, matrix[i][0]);
            high = Math.max(high, matrix[i][m - 1]);
        }
        while (low <= high) {
            int mid = (low + high) / 2;
            int numElements = elementsGreaterThanMid(matrix, mid, n, m);
            if (numElements <= req) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public int elementsGreaterThanMid(int[][] matrix, int mid, int n, int m) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            count += getUpperBound(matrix[i], mid, m);
        }
        return count;
    }

    private int getUpperBound(int[] arr, int target, int len) {
        int low = 0;
        int high = len - 1;
        int ans = len;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] <= target) {
                low = mid + 1;
            } else {
                ans = mid;
                high = mid - 1;
            }
        }
        return ans;
    }
}
