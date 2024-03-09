package com.contest;

public class Test_03_2 {

//	[[7,7,10,9],[10,5,10,3]]
//			54
	
//	[[7,6,3],[6,6,1]]
//			18
	 public int countSubmatrices(int[][] grid, int k) {
		    int rowLen = grid.length;
		    int colLen = grid[0].length;
		    int count = 0;
	        int left = 0, right = 0, top = 0, bottom = 0;
	        for(; right < colLen ; right++) {
	        	for(;bottom < rowLen ; bottom++) {
	        		int sum = 0;
	        		for(int rowIt = left; rowIt <= right ;rowIt++) {
	        			for(int colIt = top; colIt <= bottom ;colIt++) {
	        				sum += grid[rowIt][colIt];
	        			}
	        		}
	        		if(sum <=k) {
	        			count++;
	        		}
	        	}
	        }
	        
	        return count;
	    }
	
	public static void main(String[] args) {
		int a[][] = {{7,6,3},{6,6,1}};
		int k = 18;
		Test_03_2 s = new Test_03_2();
		System.out.println(s.countSubmatrices(a, k));
	}
}
