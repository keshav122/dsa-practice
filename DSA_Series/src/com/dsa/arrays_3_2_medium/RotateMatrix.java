package com.dsa.arrays_3_2_medium;

import java.util.HashMap;
import java.util.Map;

public class RotateMatrix {

	 public static void rotateMatrix(int [][]mat){
		   int n = mat.length;
	       Map<Integer, int[]> map = new HashMap<>();
	       for(int i = 0; i<n ; i++ ) {
	    	  int a[] = new int[n];
	    	  for(int j = 0; j< n ; j++) {
	    		  a[j] = mat[n-i-1][j];
	    	  }
	    	   map.put(i,a);
	       }
	       
	       for(int i = 0; i< n ; i++) {
	    	   int a[] = map.get(i);
	    	   for(int j = 0; j < n; j++) {
	    		   mat[j][i] = a[j];
	    	   }
	       }
	 }
	 
	 public static void main(String[] args) {
		 int [][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
			
			rotateMatrix(matrix);
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
