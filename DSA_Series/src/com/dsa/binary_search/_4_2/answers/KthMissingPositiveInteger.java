package com.dsa.binary_search._4_2.answers;

import java.util.ArrayList;
import java.util.List;

public class KthMissingPositiveInteger {

	public static int missingK(int[] vec, int n, int k) {
		List<Integer> missingList = new ArrayList<>();
		if (vec[0] > 1) {
			for (int a = 1; a < vec[0]; a++) {
				missingList.add(a);
			}

		}

		if (missingList.size() >= k) {
			return missingList.get(k - 1);
		}
		for (int i = 1; i < n; i++) {
			if (vec[i] - vec[i - 1] > 1) {
				for (int a = vec[i - 1] + 1; a < vec[i]; a++) {
					missingList.add(a);
				}
				if (missingList.size() >= k) {
					return missingList.get(k - 1);
				}
			}
		}
		if (missingList.size() < k) {
			return vec[n - 1] + (k - missingList.size());
		}
		return missingList.get(k - 1);
	}

	public static int missingK_1(int[] vec, int n, int k) {
		int missingCount = 0;
		for (int i = 0; i < n; i++) {
			if (i == 0) {
				missingCount += vec[i] - 1;
			} else {
				missingCount += vec[i] - vec[i - 1] - 1;
			}

			if (missingCount >= k) {
				int j = i;
				for (int a = vec[i]; a >= 1; a--) {
					if (j >= 0 && vec[j] == a) {
						j--;
					} else {
						missingCount--;
					}
					if (missingCount == k - 1)
						return a;
				}
			}
		}
		if (missingCount < k) {
			return vec[n - 1] + (k - missingCount);
		}
		return 0;
	}

	public int missingKEasyBF(int[] vec, int n, int k) {
		for (int i : vec) {
			if (i > k) {
				return k;
			} else {
				k++;
			}
		}
		return k;
	}

	public int missingKBinarySearch(int[] vec, int n, int k) {
		int low = 0;
		int high = n - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			int missing = vec[mid] - (mid + 1);
			if (missing < k) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}

		return high + 1 + k; // or low + k as high + 1 = low
	}
}
