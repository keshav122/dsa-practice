package com.leetcode-practice.contest.biweekly.count_118;

public class MinimumCoins {

	public int minimumCoins(int[] prices) {
		int coin = prices[0];
		int i = 1;
		int n = prices.length;
		boolean canSkip = true;
		while (i < n) {
			// get cost of next i elements (upto the end of array) in the array
			long cost = getCost(prices, i + 1, n);
			long currentIndexPrice = prices[i];
			if(!canSkip) {
				coin += currentIndexPrice;
				i += i;
				canSkip = true;
			}else {
				if(currentIndexPrice <= cost) {
					coin += currentIndexPrice;
					i += i;
					canSkip = true;
				}else {
					i++;
					canSkip = false;
				}
			}
		}
		return coin;
	}

	private long getCost(int[] prices, int freeLen, int n) {

		int j = freeLen;
		long cost = 0;
		while (j < Math.min(j + freeLen - 1, n)) {
			cost += prices[j];
			j++;
		}
		return cost;
	}

	public static void main(String[] args) {
		int prices[] = {1,2,3,4};
		MinimumCoins m = new MinimumCoins();
		System.out.println(m.minimumCoins(prices));
	}
}
