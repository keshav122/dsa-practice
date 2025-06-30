package com.leetcode-practice.problems.medium;

import java.util.LinkedList;
import java.util.List;

public class SpiralMatrix_54 {

	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> list = new LinkedList<>();
		int rowLen = matrix.length;
		int colLen = matrix[0].length;
		int[] ans = new int[rowLen * colLen];
		int i = 0, top = 0, right = colLen - 1, bottom = rowLen - 1, left = 0;
		while (i < ans.length) {
			// Traversal from L-R
			for (int j = left; j <= right; j++) {
				list.add(matrix[top][j]);
				i++;
			}
			top++;
			if(top> bottom) {
				break;
			}
			// Traversal from Top - bottom
			for (int j = top; j <= bottom; j++) {
				list.add(matrix[j][right]);
				i++;
			}
			right--;
			if(left > right) {
				break;
			}
			// Traversal from R-L
			for (int j = right; j >= left; j--) {
				list.add(matrix[bottom][j]);
				i++;
			}
			bottom--;
			if(top> bottom) {
				break;
			}
			// Traversal from Bottom - top
			for (int j = bottom; j >= top; j--) {
				list.add(matrix[j][left]);
				i++;
			}
			left++;
			if(left > right) {
				break;
			}
		}

		return list;
	}
}
