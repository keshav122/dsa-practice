package com.codestudio.cn.guidedpaths.dsa.arrays.mixedproblems;

public class SellingStock {
	public static long getMaximumProfit(int n, long[] values) {
		long ans = 0;
		for (int i = 1; i < n; i++) {
			if (values[i] > values[i - 1]) {
				ans += values[i] - values[i - 1];
			}
		}

		return ans;
	}
}

