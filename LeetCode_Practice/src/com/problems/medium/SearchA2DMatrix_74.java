package com.problems.medium;

public class SearchA2DMatrix_74 {

	// The most basic Brute Force is to search every element and if you find it
	// you can return true else false
	public boolean searchMatrix_MostBasicBF(int[][] matrix, int target) {
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

	public boolean searchMatrix_Better(int[][] matrix, int target) {
		int n = matrix.length;
		int m = matrix[0].length;
		int i = 0;
		while (i < n) {
			if (matrix[i][0] <= target && matrix[i][m - 1] >= target) {
				for (int j = 0; j < m; j++) {
					if (matrix[i][j] == target) {
						return true;
					}
				}
				return false;
			} else {
				i++;
			}
		}
		return false;
	}

	public boolean searchMatrix_MuchBetter(int[][] matrix, int target) {
		int n = matrix.length;
		int m = matrix[0].length;
		int low = 0;
		int high = n - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (matrix[mid][0] <= target && matrix[mid][m - 1] >= target) {
				return isTargetPresent(matrix[mid], target, m);
			} else if (matrix[mid][m - 1] < target) {
				low = mid + 1;
			} else if (matrix[mid][0] > target) {
				high = mid - 1;
			}
		}
		return false;
	}

	private boolean isTargetPresent(int[] arr, int target, int n) {
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
}
