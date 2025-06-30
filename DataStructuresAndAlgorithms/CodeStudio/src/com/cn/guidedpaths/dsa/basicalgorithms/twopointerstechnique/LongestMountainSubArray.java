package com.cn.guidedpaths.dsa.basicalgorithms.twopointerstechnique;

public class LongestMountainSubArray {

	public static int longestMountain(int arr[], int n) {
		if (n < 3) {
			return 0;
		}

		int i = 0;
		int startPointer = -1;
		int endPointer = -1;
		int maxLenMountain = 0;
		for (i = 0; i < arr.length - 1; i++) {
			if (arr[i + 1] > arr[i]) {
				// When a new mountain sub-array is found, there is a need to
				// set the variables endPointer, startPointer to -1 in order to
				// help calculate the length of new mountain sub-array

				if (endPointer != -1) {
					endPointer = -1;
					startPointer = -1;
				}

				// startPointer marks the starting index of a new mountain
				// sub-array. So set the
				// value of j to current index i.
				if (startPointer == -1) {
					startPointer = i;
				}

			} else {

				// Checks if next element is less than current element
				if (arr[i + 1] < arr[i]) {

					// Checks if starting element exists or not, if the starting
					// element of the mountain sub-array exists then
					// the index of ending element is stored in k
					if (startPointer != -1) {
						endPointer = i + 1;
					}

					// This condition checks if both starting index and ending
					// index exists or not, if yes,the length is calculated.
					if (endPointer != -1 && startPointer != -1) {

						// maxLenMountain holds the length of the longest
						// mountain sub-array.If the current length is
						// greater than the calculated length, then value of
						// maxLenMountain is updated.
						if (maxLenMountain < endPointer - startPointer + 1) {
							maxLenMountain = endPointer - startPointer + 1;
						}

					}
				}

				// Ignore if there is no increase or decrease in the value of the next element
				else {
					endPointer = -1;
					startPointer = -1;
				}
			}
		}

		// Checks and calculates the length if last element of the array is
		// the last element of a mountain sub-array
		if (endPointer != -1 && startPointer != -1) {
			if (maxLenMountain < endPointer - startPointer + 1)
				maxLenMountain = endPointer - startPointer + 1;
		}
		return maxLenMountain;

	}

	public static void main(String[] args) {
		int a[] = { 3, 1, 3 };
		int n = 3;
		System.out.println(longestMountain(a, n));
	}

}
