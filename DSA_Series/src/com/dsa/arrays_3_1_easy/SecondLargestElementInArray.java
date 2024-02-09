package com.dsa.arrays_3_1_easy;

public class SecondLargestElementInArray {

	public static int[] getSecondOrderElements(int n, int[] a) {
		int ans[] = new int[2];
		if (a.length == 2) {
			ans[0] = Math.max(a[0], a[1]);
			ans[1] = Math.min(a[0], a[1]);
			return ans;
		}
		int largest = a[0];
		int secondLargest = a[0];
		int smallest = a[0];
		int secondSmallest = a[0];

		for (int i = 1; i < n; i++) {
			if (a[i] > largest) {
				secondLargest = largest;
				largest = a[i];

			} else if (a[i] > secondLargest) {
				secondLargest = a[i];
			}

			if (a[i] < smallest) {
				secondSmallest = smallest;
				smallest = a[i];
			} else if ((secondSmallest == smallest && a[i] > smallest) || (a[i] < secondSmallest)) {
				secondSmallest = a[i];
			}

		}
		ans[0] = secondLargest;
		ans[1] = secondSmallest;
		return ans;
	}

	public static int[] getSecondOrderElements_Way2(int n, int[] a) {
		int ans[] = new int[2];
		if (a.length == 2) {
			ans[0] = Math.max(a[0], a[1]);
			ans[1] = Math.min(a[0], a[1]);
			return ans;
		}
		int largest = a[0];
		int smallest = a[0];

		for (int i = 1; i < n; i++) {
			largest = Math.max(largest, a[i]);
			smallest = Math.min(smallest, a[i]);
		}

		int secondLargest = Integer.MIN_VALUE;
		int secondSmallest = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			if (a[i] > secondLargest && a[i] != largest) {
				secondLargest = a[i];
			}
			if (a[i] < secondSmallest && a[i] != smallest) {
				secondSmallest = a[i];
			}
		}
		ans[0] = secondLargest;
		ans[1] = secondSmallest;
		return ans;

	}

	public static void main(String[] args) {
		int[] v = { 41, 467, 334, 500, 169, 724, 478, 358, 962, 464 };

		int ans[] = getSecondOrderElements_Way2(v.length, v);
		for (int i : ans) {
			System.out.print(i + " ");
		}
	}
}
