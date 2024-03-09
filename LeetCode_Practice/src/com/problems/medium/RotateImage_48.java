package com.problems.medium;

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
}
