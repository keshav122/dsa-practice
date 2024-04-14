package com.dsa.arrays_3_3_hard;

//Questions that can be asked
// - Given a row and column print the value -- It is (R-1) C (col -1) where C : combination (P&C)
// - Print a nth row of the pascal triangle
// - Print the complete pascal triangle
public class PrintPascalsTriangle {

	public static int[][] pascalTriangle(int N) {
		int res[][] = new int[N][N];
		int oneRow[] = new int[1];
		oneRow[0] = 1;
		res[0] = oneRow;
		if (N == 1) {
			return res;
		}
		int secondRow[] = new int[2];
		secondRow[0] = 1;
		secondRow[1] = 1;
		res[1] = secondRow;
		if (N == 2) {
			return res;
		}
		for (int i = 2; i < N; i++) {
			int currRow[] = new int[i + 1];
			currRow[0] = 1;
			// for loop
			for (int j = 1; j < i; j++) {
				int lastRow[] = res[i - 1];
				currRow[j] = lastRow[j - 1] + lastRow[j];
			}
			currRow[i] = 1;
			res[i] = currRow;
		}
		return res;
	}

	// print value at row & col
	public static long pascalTriangleValue(int row, int col) {
		// the value is (R-1) C (col -1)
		return nCr(row - 1, col - 1);
	}

	public static int[] returnRowOfPascalTriangleBF(int row) {
		int ans[] = new int[row];
		for (int i = 1; i <= row; i++) {
			ans[i - 1] = (int) nCr(row - 1, i - 1);
		}
		return ans;
	}

	// We observe that lets for row 5 : 1 4 6 4 1
	// 1, 4/1 , 4 * 3/1* 2 , 4 * 3 * 2/ 1* 2* 3, 4 *3 * 2*1 /1*2*3*4
	// If we take ans = 1 as the first number , then the next number is ans*
	// (n-i)/i;

	public static int[] returnRowOfPascalTriangle(int row) {
		int ans[] = new int[row];
		int a = 1;
		ans[0] = 1;
		for (int i = 1; i < row; i++) {
			a = a * (row - i);
			a /= i;
			ans[i] = a;
		}
		return ans;
	}

	public static int[][] pascalTriangleOptimal(int N) {
		int res[][] = new int[N][N];
		for (int i = 1; i <= N; i++) {
			res[i - 1] = returnRowOfPascalTriangle(i);
		}
		return res;
	}

	private static long nCr(int n, int r) {
		// This comes by the observation that the numerator & deno always go upto r
		// places
		// 7C2 = 7! / 2! * 5! = ((7 * 6) * 5!)/ 2 * 5! = (7 * 6)/ (2 * 1);
		// Similarly , 10C3 = 10! / 3! * 7! = ((10 * 9 * 8) * 7!)/ 3! * 7! = (10 * 9 *
		// 8)/ (3 * 2 * 1);
		long res = 1;
		for (int i = 0; i < r; i++) {
			res *= (n - i);
			res /= (i + 1);
		}
		return res;
	}

	public static void main(String[] args) {
		int a[] = returnRowOfPascalTriangle(5);
		for (int i : a) {
			System.out.print(i + " ");
		}
	}
}
