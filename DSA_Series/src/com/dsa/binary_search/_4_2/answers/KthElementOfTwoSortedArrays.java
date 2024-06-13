package com.dsa.binary_search._4_2.answers;

import java.util.Arrays;

public class KthElementOfTwoSortedArrays {

	public static int ninjaAndLadoos(int row1[], int row2[], int m, int n, int k) {
		int[] res = new int[n + m];
		int i = 0;
		while (i < m) {
			res[i] = row1[i];
			i++;
		}
		int j = 0;
		while (i < res.length && j < n) {
			res[i] = row2[j];
			i++;
			j++;
		}
		Arrays.sort(res);
		return res[k - 1];
	}

	public static int ninjaAndLadoos_Better(int row1[], int row2[], int m, int n, int k) {
		int count = 0;
		int i = 0;
		int j = 0;
		while (i < m && j < n) {
			if (row1[i] <= row2[j]) {
				count++;
				if (count == k) {
					return row1[i];
				}
				i++;
			} else {
				count++;
				if (count == k) {
					return row2[j];
				}
				j++;
			}
		}

		while (i < m) {
			count++;
			if (count == k) {
				return row1[i];
			}
			i++;
		}

		while (j < n) {
			count++;
			if (count == k) {
				return row2[j];
			}
			j++;
		}
		return 0;

	}

	public static void main(String[] args) {

	}
}
