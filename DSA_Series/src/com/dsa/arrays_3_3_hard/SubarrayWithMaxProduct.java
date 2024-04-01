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

	public static int subarrayWithMaxProduct_Optimal(int[] arr) {
		
	}
	
	public static void main(String[] args) {
		int a[] = {1,-2,3,-4};
		System.out.println(subarrayWithMaxProduct_Optimal(a));
	}
}
