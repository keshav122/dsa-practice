package com.dsa.binary_search._4_3.twoDArray;

public class PeakArray {

	public int[] findPeakGrid_BruteForce(int[][] mat) {
		int n = mat.length;
		int m = mat[0].length;
		int[] ans = new int[2];
		boolean isGreaterThanTop, isGreaterThanBottom, isGreaterThanLeft, isGreaterThanRight;
		for (int row = 0; row < n; row++) {
			for (int col = 0; col < m; col++) {
				if(row > 0) {
					isGreaterThanTop = mat[row][col] > mat[row - 1][col];
				}else {
					isGreaterThanTop = true;
				}
				if(row < n-1) {
					isGreaterThanBottom = mat[row][col] > mat[row + 1][col];
				}else {
					isGreaterThanBottom = true;
				}
				
				if(col > 0) {
					isGreaterThanLeft = mat[row][col] > mat[row][col - 1];
				}else {
					isGreaterThanLeft = true;
				}
				
				if(col < m-1) {
					isGreaterThanRight = mat[row][col] > mat[row][col + 1];
				}else {
					isGreaterThanRight = true;
				}
	
				if (isGreaterThanTop && isGreaterThanBottom && isGreaterThanLeft && isGreaterThanRight) {
					ans[0] = row;
					ans[1] = col;
					return ans;
				}
			}
		}
		return ans;
	}
	
	public int[] findPeakGrid_Better(int[][] mat) {
		int n = mat.length;
		int m = mat[0].length;
		int[] ans = new int[2];
		ans[0] = -1;
		ans[1] = -1;
		int low = 0;
		int high = m-1;
		while(low <= high) {
			int mid = (low + high)/2;
			int row = maxElementIndex(mat,mid,n);
			int left = mid -1 > 0 ? mat[row][mid-1] : -1;
			int right = mid + 1 < m ? mat[row][mid+1]: -1;
			if(mat[row][mid] > left && mat[row][mid] > right) {
				ans[0] = row;
				ans[1] = mid;
				return ans;
			}else if(mat[row][mid] < left) {
				high = mid-1;
			}else {
				low = mid +1;
			}
		}
		return ans;
	}

	private int maxElementIndex(int[][] mat, int mid, int n) {
		int maxEl = mat[0][mid];
		int maxIndex = 0;
		for(int i = 1 ; i< n ; i++) {
			if(mat[i][mid] > maxEl) {
				maxEl = mat[i][mid];;
				maxIndex = i;
			}
		}
		return maxIndex;
	}

	public static void main(String[] args) {
		int[][] mat = {{11,27,32,31,14},{26,4,11,25,1},{25,17,30,19,28}};
		PeakArray p = new PeakArray();
		int[] ans = p.findPeakGrid_BruteForce(mat);
		System.out.println(ans[0] + " " + ans[1]);
	}
}
