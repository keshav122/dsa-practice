package com.problems.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetMatrixZeroes_73 {

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

	//TODO This is not working yet ..Check solution from CN
	public void setZeroes_Way2(int[][] matrix) {
		int rowLen = matrix.length;
		int colLen = matrix[0].length;
		boolean isColZero = (matrix[0][0] == 0) ;
		for (int i = 0; i < rowLen; i++) {
			for (int j = 0; j < colLen; j++) {
				if (matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}

		for (int j = 1; j < colLen; j++) {
			if (matrix[0][j] == 0) {
				for (int i = 0; i < rowLen; i++) {
					matrix[i][j] = 0;
				}
			}
		}
		
		for (int i = 1; i < rowLen; i++) {
			if (matrix[i][0] == 0) {
				for (int j = 0; j < colLen; j++) {
					matrix[i][j] = 0;
				}
			}
		}
		
		if(matrix[0][0] == 0) {
			for (int j = 0; j < colLen; j++) {
				matrix[0][j] = 0;
			}
		}
		
		if(isColZero) {
			for (int i = 0; i < rowLen; i++) {
				matrix[i][0] = 0;
			}
		}
	}
	
	public static void main(String[] args) {
		int [][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
		SetMatrixZeroes_73 s = new SetMatrixZeroes_73();
		s.setZeroes_Way2(matrix);
		int rowLen = matrix.length;
		int colLen = matrix[0].length;
		for (int i = 0; i < rowLen; i++) {
			for (int j = 0; j < colLen; j++) {
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
	}
}
