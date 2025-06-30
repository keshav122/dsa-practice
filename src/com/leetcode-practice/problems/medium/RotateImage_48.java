package com.leetcode-practice.problems.medium;

import java.util.HashMap;
import java.util.Map;

public class RotateImage_48 {

	public void rotate(int[][] matrix) {
		int n = matrix.length;
		Map<Integer, int[]> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			int a[] = new int[n];
			for (int j = 0; j < n; j++) {
				a[j] = matrix[n - i - 1][j];
			}
			map.put(i, a);
		}

		for (int i = 0; i < n; i++) {
			int a[] = map.get(i);
			for (int j = 0; j < n; j++) {
				matrix[j][i] = a[j];
			}
		}
	}
	
	public void rotate_optimal(int[][] matrix) {
		int n = matrix.length;
		   for(int i = 0; i<= n -2 ; i++) {
			   for(int j = i+1 ; j <= n-1; j++) {
				   int temp = matrix[i][j];
				   matrix[i][j] = matrix[j][i];
				   matrix[j][i] = temp;
			   }
		   }
		   
		   for(int i = 0; i< n ; i++) {
			   for(int j = 0, k = n-1; j <= k; j++,k--) {
				   int temp = matrix[i][j];
				   matrix[i][j] = matrix[i][k];
				   matrix[i][k] = temp;
			   }
		   }
	}
}
