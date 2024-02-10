package com.dsa.basic_1_5.basic_recursion;

public class PrintFibonacciSeries {

	public static int[] generateFibonacciNumbers(int n) {
		int a[] = new int[n];
		if (n == 1) {
			a[0] = 0;
			return a;
		}
		if (n == 2) {
			a[0] = 0;
			a[1] = 1;
			return a;
		}
		
		a[0] = 0;
		a[1] = 1;
		generateFibonacciNumbers(a, n, 2);
		return a;
	}

	private static void generateFibonacciNumbers(int[] a, int n, int count) {
		if (count == n) {
			return;
		}

		int currFibNo = a[count-2] + a[count-1];
		a[count] = currFibNo;
		count++;
	    generateFibonacciNumbers(a, n, count);
	}

	public static void main(String[] args) {
		int a[] = generateFibonacciNumbers(5);
		for (int i : a) {
			System.out.print(i + " ");
		}
	}

}
