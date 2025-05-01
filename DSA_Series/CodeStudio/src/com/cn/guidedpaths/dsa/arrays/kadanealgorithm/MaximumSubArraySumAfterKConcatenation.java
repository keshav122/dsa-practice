package com.cn.guidedpaths.dsa.arrays.kadanealgorithm;

import java.util.ArrayList;

public class MaximumSubArraySumAfterKConcatenation {

	public static long maxSubSumKConcat(ArrayList<Integer> arr, int n, int k) {
		ArrayList<Integer> li = new ArrayList<>();
		for (int i = 0; i < k; i++) {
			li.addAll(arr);
		}

		long sum = 0;
		long maxSum = Long.MIN_VALUE;

		for (int i = 0; i < li.size(); i++) {
			sum += li.get(i);
			maxSum = Long.max(sum, maxSum);
			if (sum < 0) {
				sum = 0;
			}
		}
		return maxSum;
	}

	/*
	 * Kadane's Algorithm The main observation here is that the optimal subarray
	 * will have no prefix with negative sum. This is because we can remove the
	 * prefix with a negative sum from our optimal subarray and hence it will
	 * only increase our subarray sum/answer.
	 * 
	 * 
	 * 
	 * Please note, we don’t need to construct a new vector ‘CONCAT’. Since we
	 * are concatenating the given vector ‘K’ times so, ‘CONCAT[i] = ARR[i%N]’.
	 * We use this fact to solve the problem without using additional space.
	 * 
	 * 
	 * 
	 * The algorithm will be -
	 * 
	 * We will loop from 0 to ‘N * K’ (loop variable ‘i’). We initialize
	 * ‘CUR_SUM’ (to store sum of prefix elements) to 0 and ‘MAX_SUM’ (to store
	 * maximum subarray sum) to the minimum possible value. For each iteration,
	 * we will- Add ‘ARR[i % N]’ to ‘CUR_SUM’’. Update ‘MAX_SUM’ if it’s value
	 * is less than ‘CUR_SUM’’. If ‘CUR_SUM’’ becomes negative, we will reset it
	 * to 0. Finally, we return ‘MAX_SUM’ as our answer. Time Complexity O(N *
	 * K), where ‘N’ denotes the size of vector/list and ‘K’ is the given
	 * integer.
	 * 
	 * 
	 * 
	 * We are running a loop from 0 to ‘N * K’. So, the overall time complexity
	 * is O(N*K).
	 * 
	 * Space Complexity O(1).
	 * 
	 * Constant space is used.
	 */
	public static long maxSubSumKConcatOfficialSolution1(ArrayList<Integer> arr, int n, int k) {
		long maxSum = Long.MIN_VALUE;
		long curSum = 0;

		for (int i = 0; i < n * k; i++) {
			curSum += arr.get(i % n);

			maxSum = Math.max(maxSum, curSum);

			if (curSum < 0) {
				curSum = 0;
			}
		}

		return maxSum;
	}

	// O(N)
	/*
	 * Kadane for different cases Since ‘CONCAT’ is formed by concatenating
	 * ‘ARR’ ‘K’ times, we can break this problem into different cases to avoid
	 * redundant iterations and computations.
	 * 
	 * 
	 * 
	 * All the cases are-
	 * 
	 * If K = 1- We simply apply Kadane’s algorithm and return the maximum sum.
	 * Else, we find the sum of elements (‘ARR_SUM'). Now there are two cases-
	 * If 'ARR_SUM' <= 0 Then, we will find the maximum subarray sum for ‘K’ = 2
	 * irrespective of value of ‘K’ and return it as answer. This is because the
	 * maximum subarray can’t contain complete ‘ARR’. If we include the complete
	 * vector, then it will only decrease the subarray sum due to the negative
	 * total. If 'ARR_SUM' > 0 Then, we will find the maximum subarray sum for K
	 * = 2 and we return ‘MAX_SUBARRAY_SUM’ plus (K-2) times ‘ARR_SUM' as the
	 * answer. This is because ‘ARR_SUM' is greater than 0, including it ‘K-2’
	 * times will only increase the subarray sum. Time Complexity O(N), where
	 * 'N' denotes the size of the vector/list.
	 * 
	 * 
	 * 
	 * We will end up looping from 0 to 2 * 'N' to find maximum subarray sum
	 * when ‘K’ will be greater than 1. So, the overall time complexity is O(N).
	 * 
	 * Space Complexity O(1).
	 * 
	 * 
	 * 
	 * Constant space is used.
	 * 
	 * 
	 */
	public static long maxSubSumKConcatOfficial2(ArrayList<Integer> arr, int n, int k) {
		long maxSubSum;

		if (k == 1) {
			maxSubSum = kadane(arr, n, k);

			return maxSubSum;
		}

		int arrSum = 0;

		for (int i = 0; i < n; i++) {
			arrSum += arr.get(i);
		}

		if (arrSum <= 0) {
			// Finding the maximum subarray sum for k = 2.
			maxSubSum = kadane(arr, n, 2);
		} else {
			// Finding the maximum subarray sum for k = 2.
			maxSubSum = kadane(arr, n, 2);
			maxSubSum += (long) (k - 2) * (long) arrSum;
		}

		return maxSubSum;
	}

	public static long kadane(ArrayList<Integer> arr, int n, int k) {
		long maxSum = Long.MIN_VALUE;
		long curSum = 0;

		for (int i = 0; i < n * k; i++) {
			curSum += arr.get(i % n);
			maxSum = Math.max(maxSum, curSum);
			if (curSum < 0) {
				curSum = 0;
			}
		}

		return maxSum;
	}
}
