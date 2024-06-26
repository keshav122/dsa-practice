package com.dsa.binary_search._4_3.twoDArray;

import java.util.ArrayList;

public class SearchA2DMatrixII {

	public boolean searchMatrix_BS(int[][] matrix, int target) {
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
		while (i < m) {
			if (matrix[0][i] <= target && matrix[n - 1][i] >= target) {
				for (int j = 0; j < n; j++) {
					if (matrix[j][i] == target) {
						return true;
					}else if(matrix[j][i] > target) {
						break;
					}
				}
				i++;
			} else {
				i++;
			}
		}
		return false;
	}
	
	
	public static boolean findInMatrix_Better_Arraylist(int x, ArrayList<ArrayList<Integer>> arr)
    {
        int n = arr.size();
		int m = arr.get(0).size();
		int row = 0 , col = m-1;
		while(row < n && col >= 0) {
			if(arr.get(row).get(col) == x) {
				return true;
			}else if(arr.get(row).get(col) < x) {
				row++;
			}else {
				col--;
			}
		}
		return false;
    }	
	public boolean searchMatrix_Optimal(int[][] matrix, int target) {
		int n = matrix.length;
		int m = matrix[0].length;
		int row = 0 , col = m-1;
		while(row < n && col >= 0) {
			if(matrix[row][col] == target) {
				return true;
			}else if(matrix[row][col] < target) {
				row++;
			}else {
				col--;
			}
		}
		return false;
		
	}
	
	
	public static void main(String[] args) {
		int[][] matrix = {{1,3,5,7,9},{2,4,6,8,10},{11,13,15,17,19},{12,14,16,18,20},{21,22,23,24,25}};
		SearchA2DMatrixII obj = new SearchA2DMatrixII();
		System.out.println(obj.searchMatrix_Optimal(matrix, 13));
	}
}
