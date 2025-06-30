/*Author: keshav122 */
/*Author: keshav122 */
package com.problems.easy;

public class NthTribonacciNumber_1137 {

	public int tribonacci(int n) {
		int[] a = new int[n + 1];
		if (n == 0)
			return 0;
		if (n <= 2)
			return 1;

		a[0] = 0;
		a[1] = 1;
		a[2] = 1;
		for (int i = 3; i <= n; i++) {
			a[i] = a[i - 3] + a[i - 2] + a[i - 1];
		}
		return a[n];
	}
}
