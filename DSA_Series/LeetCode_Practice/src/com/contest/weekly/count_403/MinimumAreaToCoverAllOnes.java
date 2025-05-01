package com.contest.weekly.count_403;
/*
You are given a 2D binary array grid. Find a rectangle with horizontal and vertical sides with the smallest area, such that all the 1's in grid lie inside this rectangle.

Return the minimum possible area of the rectangle.

 */
public class MinimumAreaToCoverAllOnes {

    public int minimumArea(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] isTrue = new boolean[n+1][m+1];
        //checking rows
        for(int i = 1; i<= n;i++) {
        	for(int j = 1; j <= m; j++) {
        		if(grid[i-1][j-1] == 1) {
        			isTrue[i][0] = true;
        			break;
        		}
        	}
        }
        //checking cols
        for(int i = 1; i<= m;i++) {
        	for(int j = 1; j <= n; j++) {
        		if(grid[j-1][i-1] == 1) {
        			isTrue[0][i] = true;
        			break;
        		}
        	}
        }
        
        for(int i = 1; i<= n; i++) {
        	for(int j = 1; j <= m; j++) {
        		if((isTrue[0][j] && isTrue[i][0]) || grid[i-1][j-1] == 1) {
        			isTrue[i][j] = true;
        		}
        	}
        }

        int left = -1, right = -1, bottom = -1, top = 1;
        boolean isTrueFound = false;
        for(int i = 1; i<= n;i++) {
        	for(int j = 1; j <=m; j++) {
        		if(isTrue[i][j] && !isTrueFound) {
        			left = j;
        			top = i;
        			right = j;
        			bottom = i;
        			isTrueFound = true;
        		}else if(isTrue[i][j]) {
        			right = j;
        			bottom = i;
        		}
        	}
        }
        return (bottom - top + 1) * (right - left + 1);
        
    }
    
	public static void main(String[] args) {
		MinimumAreaToCoverAllOnes obj = new MinimumAreaToCoverAllOnes();
		int[][] input = {{0},{1}};
		System.out.println(obj.minimumArea(input));
	}
}
