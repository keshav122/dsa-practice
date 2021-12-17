package com.cn.guidedpaths.dsa.arrays.mixedproblems;

import java.util.Arrays;

public class MinimumNumberOfPlatforms {
	/*
	 * The issue with this approach is that in case there is a train arriving at
	 * same time at which the departure is scheduled for the previous train then
	 * the platform is not empty and and extra platform will be required but in
	 * count of array 'a' +1 and -1 will add up to 0 resulting in no addition of
	 * platform required .
	 * 
	 * Sample Input : 4 100 200 300 400 200 300 400 500
	 * 
	 * Expected Output : 2 , Actual O/p : 1
	 * 
	 */
	public static int calculateMinPatforms_Trial1(int at[], int dt[], int n) {
		int a[] = new int[2400];
		for (int i = 0; i < n; i++) {
			a[at[i]]++;
		}
		for (int i = 0; i < n; i++) {
			a[dt[i]]--;
		}
		int maxSize = 0;
		int val = 0;
		for (int i = 0; i < 2400; i++) {
			val += a[i];
			maxSize = Math.max(maxSize, val);
		}

		return maxSize == 0 ? 1 : maxSize;

	}

	public static int calculateMinPatforms(int at[], int dt[], int n) {

		Arrays.sort(at);
		Arrays.sort(dt);
		int i = 1, j = 0, platformRequired = 1, result = 1;
		while (i < n && j < n) {
			if (at[i] <= dt[j]) {
				platformRequired++;
				i++;
			} else {
				platformRequired--;
				j++;
			}

			result = Math.max(platformRequired, result);
		}
		return result;

	}
}
