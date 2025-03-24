package com.dsa.binary_search._4_2.answers;

public class FindSqRootInLogN {

	public static int sqrtN(long N) {
		if (N <= 1)
			return (int) N;
		long low = 1;
		long high = N - 1;
		while (low <= high) {
			long mid = (low + high) / 2;
			long square = mid * mid;
			if (square == N || ((mid + 1) * (mid + 1) > N && (square) < N)) {
				return (int) mid;
			} else if (square < N) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}

		return -1;
	}

	public static int sqrtN_1(long N) {
		long low = 1;
		long high = N - 1;
		long ans = 1;
		while (low <= high) {
			long mid = (low + high) / 2;
			long square = mid * mid;
			if (square == N) {
				return (int) mid;
			} else if (square < N) {
				ans = mid;
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}

		return (int) ans;
	}

	// If we carefully observe we will understand that in binary search the low &
	// high are alwys part of the
	// ans . In this case the low is in a region where a probable ans can be there
	// whereas the high is in a region where no ans is possible
	// As they move and cross each other low goes to the first index where the
	// answer is not possible
	// whereas the high moves to the first index where the ans is possible
	// That is why high is the ans .using this we can avoid the use of ans variable
	public static int sqrtN_2(long N) {
		long low = 1;
		long high = N - 1;
		while (low <= high) {
			long mid = (low + high) / 2;
			long square = mid * mid;
			if (square == N) {
				return (int) mid;
			} else if (square < N) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}

		return (int) high;
	}
}

# Author: keshav122
