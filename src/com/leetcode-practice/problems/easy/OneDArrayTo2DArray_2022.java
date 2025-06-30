package com.leetcode-practice.problems.easy;

public class OneDArrayTo2DArray_2022 {
  public int[][] construct2DArray(int[] original, int m, int n) {
    if (original.length != m * n) {
      return new int[0][0];
    }
    int[][] ans = new int[m][n];
    int i = 0;
    int k = 0;
    while (i < m) {
      for (int j = 0; j < n; j++) {
        ans[i][j] = original[k];
        k++;
      }
      i++;
    }
    return ans;
  }
}
