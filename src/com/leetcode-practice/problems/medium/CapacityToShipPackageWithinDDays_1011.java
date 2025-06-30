package com.leetcode-practice.problems.medium;

public class CapacityToShipPackageWithinDDays_1011 {

	public int shipWithinDays(int[] weights, int days) {
		int maxWt = weights[0];
		int sum = 0;
		for (int weight : weights) {
			sum += weight;
			maxWt = Math.max(weight, maxWt);
		}

	//	int minCap = Integer.MAX_VALUE; -- Not required
		int lowCap = maxWt;
		int highCap = sum;

		while (lowCap <= highCap) {
			int midCap = (lowCap + highCap) / 2;
			int dayReq = days(weights, midCap);
			if (dayReq <= days) {
			//	minCap = Math.min(midCap, minCap);
				highCap = midCap - 1;
			} else {
				lowCap = midCap + 1;
			}
		}
		return lowCap;
	}

	private static int days(int[] weights, int midCap) {
		int day = 1, load = 0;
		for (int weight : weights) {
			// If the sum of load and weight is more than the capacity
			// we will add the weight on the next day
			if (load + weight > midCap) {
				day++;
				load = weight;
			} else {
				load += weight;
			}
		}
		return day;
	}
}
