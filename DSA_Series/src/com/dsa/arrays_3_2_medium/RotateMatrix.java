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
	 
	 //Transpose the matrix and then reverse it
	 public static void rotateMatrix_Optimal(int [][]mat){
		   int n = mat.length;
		   for(int i = 0; i<= n -2 ; i++) {
			   for(int j = i+1 ; j <= n-1; j++) {
				   int temp = mat[i][j];
				   mat[i][j] = mat[j][i];
				   mat[j][i] = temp;
			   }
		   }
		   
		   for(int i = 0; i< n ; i++) {
			   for(int j = 0, k = n-1; j <= k; j++,k--) {
				   int temp = mat[i][j];
				   mat[i][j] = mat[i][k];
				   mat[i][k] = temp;
			   }
		   }
	 }
	 public static void main(String[] args) {
		 int [][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
			
		 rotateMatrix_Optimal(matrix);
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
