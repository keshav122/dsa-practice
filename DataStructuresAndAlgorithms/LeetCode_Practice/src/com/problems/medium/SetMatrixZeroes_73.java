package com.problems.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetMatrixZeroes_73 {

	// To avoid setting un required values to zero , we can set the
	// value to -1 , so that it doesn't interferes with other values
	public void setZeroes_Brute(int[][] matrix) {
		int rowLen = matrix.length;
		int colLen = matrix[0].length;
		for (int i = 0; i < rowLen; i++) {
			for (int j = 0; j < colLen; j++) {
				if (matrix[i][j] == 0) {
					// set all rows to -1
					for (int k = 0; k < colLen; k++) {
						if (matrix[i][k] != 0) {
							matrix[i][k] = -1;
						}

					}
					// set all cols to -1
					for (int k = 0; k < rowLen; k++) {
						if (matrix[k][j] != 0) {
							matrix[k][j] = -1;
						}
					}
				}
			}
		}

		for (int i = 0; i < rowLen; i++) {
			for (int j = 0; j < colLen; j++) {
				if (matrix[i][j] == -1) {
					matrix[i][j] = 0;
				}
			}
		}
	}

	public void setZeroes_better(int[][] matrix) {
		//we will keep a row array & a column array to track the zero 
		int rows[] = new int[matrix.length];
		int cols[] = new int[matrix[0].length];
		for (int i = 0; i < rows.length; i++) {
			for (int j = 0; j < cols.length; j++) {
				if (matrix[i][j] == 0) {
					rows[i] = 1;
					cols[j] = 1;
				}
			}
		}
		
		
		for (int i = 0; i < rows.length; i++) {
			for (int j = 0; j < cols.length; j++) {
				if (rows[i] == 1 || cols[j] == 1) {
					matrix[i][j] = 0;
				}
			}
		}
	}
	public void setZeroes(int[][] matrix) {
		List<Integer> rows = new ArrayList<>();
		List<Integer> cols = new ArrayList<>();
		int rowLen = matrix.length;
		int colLen = matrix[0].length;
		for (int i = 0; i < rowLen; i++) {
			for (int j = 0; j < colLen; j++) {
				if (matrix[i][j] == 0) {
					rows.add(i);
					cols.add(j);
				}
			}
		}

		// Setting rows to 0
		for (int i = 0; i < rows.size(); i++) {
			int index = rows.get(i);
			for (int j = 0; j < colLen; j++) {
				matrix[index][j] = 0;
			}
		}

		// Setting cols to 0
		for (int i = 0; i < cols.size(); i++) {
			int index = cols.get(i);
			for (int j = 0; j < rowLen; j++) {
				matrix[j][index] = 0;
			}
		}
	}

	public void setZeroes_1(int[][] matrix) {
		Set<Integer> rows = new HashSet<>();
		Set<Integer> cols = new HashSet<>();
		int rowLen = matrix.length;
		int colLen = matrix[0].length;
		for (int i = 0; i < rowLen; i++) {
			for (int j = 0; j < colLen; j++) {
				if (matrix[i][j] == 0) {
					rows.add(i);
					cols.add(j);
				}
			}
		}

		for (Integer index : rows) {
			for (int j = 0; j < colLen; j++) {
				matrix[index][j] = 0;
			}
		}

		// Setting cols to 0
		for (Integer index : cols) {
			for (int j = 0; j < rowLen; j++) {
				matrix[j][index] = 0;
			}
		}
	}

	public void setZeroes_optimal(int[][] matrix) {
		//we will maintain the 0th row and column as our arrays to track zeroes
		
		//int cols[] = {0}; -> matrix[0]{...}
		//int rows[] = {0}; -> matrix{..}[0]
		int rowLen = matrix.length;
		int colLen = matrix[0].length;
		int col0 = 1;
		for (int i = 0; i < rowLen; i++) {
			for (int j = 0; j < colLen; j++) {
				if (matrix[i][j] == 0) {
					matrix[i][0] = 0;
					if(j != 0) {
						matrix[0][j] = 0;
					}else {
						col0 = 0;
					}
					
				}
			}
		}
		
		
		for (int i = 1; i < rowLen; i++) {
			for (int j = 1; j < colLen; j++) {
				if (matrix[i][j] != 0) {
					if(matrix[0][j] == 0 || matrix[i][0] == 0) {
						matrix[i][j] = 0;
					}
				}
			}
		}
		
		if(matrix[0][0] == 0) {
			for(int j = 0; j< colLen ; j++) matrix[0][j] = 0;
		}
		
		if(col0 == 0) {
			for(int i = 0; i< rowLen ; i++) matrix[i][0] = 0;
		}
	}

	public static void main(String[] args) {
		int[][] matrix = { { 0, 1, 2, 0 }, { 3, 4, 5, 2 }, { 1, 3, 1, 5 } };
		SetMatrixZeroes_73 s = new SetMatrixZeroes_73();
		s.setZeroes(matrix);
		int rowLen = matrix.length;
		int colLen = matrix[0].length;
		for (int i = 0; i < rowLen; i++) {
			for (int j = 0; j < colLen; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}
