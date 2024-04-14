package com.dsa.arrays_3_3_hard;

public class SubarrayWithMaxProduct {

	public static int subarrayWithMaxProduct_bruteForce(int[] arr) {
		int maxProduct = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j < arr.length; j++) {
				int product = 1;
				for (int k = i; k <= j; k++) {
					product *= arr[k];
				}
				maxProduct = Math.max(maxProduct, product);
			}
		}
		return maxProduct;
	}

	public static int subarrayWithMaxProduct_better(int[] arr) {
		int maxProduct = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			int product = 1;
			for (int j = i; j < arr.length; j++) {
				product *= arr[j];
				maxProduct = Math.max(maxProduct, product);
			}
		}
		return maxProduct;
	}

	// It has two optimal solutions
	// One is observation based while the other is modification of kadane's
	// algorithm
	// The observation based is the one which you should tell as a solution if asked
	// in interview
	// Because the kadane's modified algo looks very crammed - You can watch Youtube
	// videos
	// to understand why striver was saying that
	// Observation 1 : If there are zero -ves OR even number of -ves, multiply all
	// the numbers
	// Observation 2 : If there are odd number of -ves , then our motive is to
	// remove
	// one -ve value and get the maximum product. The way to do that is to take both
	// the
	// prefix and suffix products and check which one is maximum.
	// Observation 3 : The way to tackle zeroes is that whenever we encounter a zero
	// from the next
	// element we will be starting a new subarray.
	public static int subarrayWithMaxProduct_Optimal(int[] arr) {
		int max = Integer.MIN_VALUE;
		int prefix = 1;
		int suffix = 1;
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			if (prefix == 0)
				prefix = 1;
			if (suffix == 0)
				suffix = 1;
			prefix = prefix * arr[i];
			suffix = suffix * arr[n - i - 1];
			max = Math.max(max, Math.max(prefix, suffix));
		}
		return max;
	}

	public static void main(String[] args) {
		int a[] = { 1, -2, 3, -4 };
		System.out.println(subarrayWithMaxProduct_Optimal(a));
	}
}
