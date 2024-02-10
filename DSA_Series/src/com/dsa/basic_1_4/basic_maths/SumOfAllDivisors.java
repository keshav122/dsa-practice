package com.dsa.basic_1_4.basic_maths;

public class SumOfAllDivisors {

	public static int sumOfAllDivisors(int n) {
		int totalSum = 0;
		for (int i = 1; i <= n; i++) {
          totalSum += getSumForNum(i);
		}
		return totalSum;
	}

	private static int getSumForNum(int n) {
		int sum = 0;
		for (int i = 1; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				sum += i;
				int quotient = n / i;
				if (quotient != i) {
					sum += quotient;
				}
			}
		}

		return sum;
	}
}
