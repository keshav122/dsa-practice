package com.dsa.arrays_3_2_medium;

public class SpiralMatrix {

	public static int[] spiralMatrix(int[][] MATRIX) {
		int rowLen = MATRIX.length;
		int colLen = MATRIX[0].length;
		int[] ans = new int[rowLen * colLen];
		int i = 0, top = 0, right = colLen - 1, bottom = rowLen - 1, left = 0;
		while (i < ans.length) {
			// Traversal from L-R
			for (int j = left; j <= right; j++) {
				ans[i] = MATRIX[top][j];
				i++;
			}
			top++;
			if(top> bottom) {
				break;
			}
			// Traversal from Top - bottom
			for (int j = top; j <= bottom; j++) {
				ans[i] = MATRIX[j][right];
				i++;
			}
			right--;
			if(left > right) {
				break;
			}
			// Traversal from R-L
			for (int j = right; j >= left; j--) {
				ans[i] = MATRIX[bottom][j];
				i++;
			}
			bottom--;
			if(top> bottom) {
				break;
			}
			// Traversal from Bottom - top
			for (int j = bottom; j >= top; j--) {
				ans[i] = MATRIX[j][left];
				i++;
			}
			left++;
			if(left > right) {
				break;
			}
		}

		return ans;
	}

	public static void main(String[] args) {
		int[][] matrix = {{1,3,7,9},{10,12,15,17},{19,20,21,50}};
		int a[] = spiralMatrix(matrix);
		for (int j = 0; j < a.length; j++) {
			System.out.print(a[j] + " ");
		}
	}
}
