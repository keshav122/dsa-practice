/*Author: keshav122 */
package com.codestudio.cn.guidedpaths.dsa.arrays.prefixandsuffixsum;

import java.util.ArrayList;
import java.util.List;

public class InfiniteArray {
	private static int modulus = (int) (1e9 + 7);

	public static List<Integer> sumInRanges(int[] arr, int n, List<List<Long>> queries, int q) {
		List<Integer> res = new ArrayList<>();
		final int MODULO = 1000000007;
		long prefixArray[] = new long[n];
		prefixArray[0] = arr[0];
		for (int i = 1; i < n; i++) {
			prefixArray[i] = (arr[i] + prefixArray[i - 1]) % MODULO;
		}
		long sum = prefixArray[n - 1];
		for (List<Long> li : queries) {
			long leftindex = li.get(0) - 1;
			long rightindex = li.get(1) - 1;

			long mult = (rightindex - leftindex + 1) / n;
			mult = mult % MODULO;
			long val = (rightindex - leftindex + 1) % n;
			long finalSum = (mult * sum) % MODULO;
			if (val != 0) {
				int startIndex = (int) (leftindex % n);
				long remainingSum = 0;
				for (int i = 0; i < val; i++) {
					remainingSum = (remainingSum + arr[startIndex]) % MODULO;
					startIndex = (startIndex + 1) % n;
				}
				finalSum = (finalSum + remainingSum) % MODULO;
			}
			int ans = (int) finalSum;
			res.add(ans);
		}
		return res;

	}

	public static List<Integer> sumInRanges1(int[] arr, int n, List<List<Long>> queries, int q) {
		List<Integer> res = new ArrayList<>();
		final int MODULO = 1000000007;
		for (List<Long> li : queries) {
			long leftindex = li.get(0) - 1;
			long rightindex = li.get(1) - 1;
			long sum = 0;
			for (long i = leftindex; i < rightindex; i++) {
				sum += arr[(int) (i % n)];
				sum %= MODULO;
			}
			int ans = (int) sum;
			res.add(ans);
		}
		return res;
	}

	public static List<Integer> sumInRanges2(int[] arr, int n, List<List<Long>> queries, int q) {
		List<Integer> res = new ArrayList<>();
		final int MODULO = 1000000007;
		// One mistake I had declared it to be of type int here
		long prefixSum[] = new long[n];
		prefixSum[0] = arr[0];
		for (int i = 1; i < n; i++) {
			prefixSum[i] = (arr[i] + prefixSum[i - 1]) % MODULO;
			prefixSum[i] %= MODULO;
		}
		long mult = prefixSum[n - 1];

		for (List<Long> li : queries) {
			long leftindex = li.get(0) - 1;
			long rightindex = li.get(1) - 1;
			long leftMultiplier = ((leftindex - 1) / n) % MODULO;
			long rightMultiplier = (rightindex / n) % MODULO;
			long leftSum = 0;
			if (leftindex != 0) {
				leftSum = ((leftMultiplier * mult) + prefixSum[(int) ((leftindex - 1) % n)]);
			}

			long rightSum = ((rightMultiplier * mult) + prefixSum[(int) (rightindex % n)]);
			int ans = (int) ((rightSum - leftSum) % MODULO);
			res.add(ans);
		}
		return res;
	}

	// Time Complexity:O(Q*(R-L))
	// Space Complexity:O(1).
	// Where Q is the number of given queries, and L and R are the given
	public static List<Integer> sumInRanges_OfficialSolution1_BruteForceApproach(int[] arr, int n,
			List<List<Long>> queries, int q) {
		int modulus = (int) (1e9 + 7);
		List<Integer> ans = new ArrayList<>();

		for (List<Long> li : queries) {
			long leftIndex = li.get(0) - 1;
			long rightIndex = li.get(1) - 1;

			long sum = 0;
			for (int i = (int) leftIndex; i <= rightIndex; i++) {
				sum += arr[i % n];
				sum %= modulus;
			}
			ans.add((int) sum);

		}
		return ans;
	}

	public static List<Integer> sumInRanges_OfficialSolution2_PrefixSumApproach(int[] arr, int n,
			List<List<Long>> queries, int q) {

		List<Integer> ans = new ArrayList<>();

		long sumArray[] = new long[n + 1];
		for (int i = 1; i <= n; i++) {
			sumArray[i] = (sumArray[i - 1] + arr[i - 1]) % modulus;
		}
		for (List<Long> li : queries) {
			long leftIndex = li.get(0);
			long rightIndex = li.get(1);

			long leftSum = getPrefixSum(sumArray, n, leftIndex - 1);
			long rightSum = getPrefixSum(sumArray, n, rightIndex);
			// Why this modulus is added - ####Doubt
			long sum = (rightSum - leftSum+ modulus) % modulus;
			ans.add((int) sum);

		}
		return ans;
	}

	private static long getPrefixSum(long[] sumArray, int n, long x) {
		long count = (x / n) % modulus;
		long res = (count * sumArray[n]) % modulus;
		res = (res + sumArray[(int) (x % n)]) % modulus;
		return res;
	}

}

/*
 * Time Complexity:O(Q+N). Space Complexity:O(N). Where N is the size of the
 * given array, and Q is the number of queries given.
 * 
 */

class OfficialSolution {

	private static int mod = (int) 1e9 + 7;

	public static List<Integer> sumInRanges(int[] arr, int n, List<List<Long>> queries, int q) {

		// It stores answer for each query.
		List<Integer> ans = new ArrayList<>();

		// It store cumulative sum where sumArray[i] = sum(A[0]+..A[i]).
		long sumArray[] = new long[n + 1];

		for (int i = 1; i <= n; i++) {
			sumArray[i] = (sumArray[i - 1] + arr[i - 1]) % mod;
		}

		// Traversing the given queries.
		for (List<Long> range : queries) {

			long l = range.get(0);
			long r = range.get(1);

			// It stores the prefix sum from index 0 to index r in an infinite
			// array.
			long rsum = func(sumArray, r, n);

			// It stores the prefix sum from index 0 to index l-1 in an infinite
			// array.
			long lsum = func(sumArray, l - 1, n);

			// Add answer for each query.
			// Why mod was added in the final sum
			// Note: In most of the programming languages (like in C/C++) when
			// you perform the modular operation with negative numbers it gives
			// a negative result like -5%3 = -2, but what the result comes after
			// the modular operation should be in the range 0 to n-1 means the
			// -5%3 = 1. So for this convert it into a positive modular
			// equivalent.
			//
			//
			//
			// static int mod(int a, int m)
			// {
			// return (a%m + m) % m;
			// }
			// // This code is contributed by
			// //Shubham Singh(SHUBHAMSINGH10)
			ans.add((int) ((rsum - lsum + mod) % mod));

		}

		return ans;
	}

	// Function to calculate prefix sum upto index x of the infite array.
	private static long func(long sumArray[], long x, long n) {

		// Number of times the given array comes completely upto index x.
		long count = (x / n) % mod;

		long res = (count * sumArray[(int) n]) % mod;

		// Adding the remaining elements sum.
		res = (res + sumArray[(int) (x % n)]) % mod;

		return res;
	}
}
