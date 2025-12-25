package com.leetcode_practice.problems.medium;

public class BestTimeToBuyAndSellStockUsingStrategy_3652 {
    public long maxProfit_originalSol(int[] prices, int[] strategy, int k) {
        int n = prices.length;
        long[] strategicPriceSumPrefix = new long[n];
        long[] prefixSum = new long[n];
        prefixSum[0] = prices[0];
        strategicPriceSumPrefix[0] = prices[0] * strategy[0];
        for (int i = 1; i < n; i++) {
            strategicPriceSumPrefix[i] = strategicPriceSumPrefix[i - 1] + prices[i] * strategy[i];
            prefixSum[i] = prefixSum[i - 1] + prices[i];
        }
        long originalSum = strategicPriceSumPrefix[n - 1];
        int i = 0;
        long maxSum = originalSum;
        while (i + k <= n) {
            int l = i;
            int r = i + k - 1;
            long lSum = l > 0 ? strategicPriceSumPrefix[l - 1] : 0;
            long rSum = strategicPriceSumPrefix[r];
            long removedSum = (rSum - lSum);
            long gainedSum = prefixSum[r] - prefixSum[i + (k / 2) - 1];
            long modifiedSum = gainedSum - removedSum;
            maxSum = Math.max(maxSum, originalSum + modifiedSum);
            i++;
        }
        return maxSum;
    }

    public long maxProfit_betterPhrased(int[] prices, int[] strategy, int k) {
        int n = prices.length;
        long[] strategicPriceSumPrefix = new long[n];
        long[] prefixSum = new long[n];
        prefixSum[0] = prices[0];
        strategicPriceSumPrefix[0] = prices[0] * strategy[0];
        for (int i = 1; i < n; i++) {
            strategicPriceSumPrefix[i] = strategicPriceSumPrefix[i - 1] + prices[i] * strategy[i];
            prefixSum[i] = prefixSum[i - 1] + prices[i];
        }
        long originalSum = strategicPriceSumPrefix[n - 1];
        int i = 0;
        long maxDelta = 0;
        for (int l = 0; l <= n - k; l++) {
            int r = l + k - 1;
            int mid = (l + (k / 2) - 1);
            long oldFirst = strategicPriceSumPrefix[mid] - (l > 0 ? strategicPriceSumPrefix[l - 1] : 0);
            long oldSecond = strategicPriceSumPrefix[r] - strategicPriceSumPrefix[mid];
            long newSecond = prefixSum[r] - prefixSum[mid];
            long delta = newSecond - (oldFirst + oldSecond);
            maxDelta = Math.max(maxDelta, delta);
        }
        return originalSum + maxDelta;
    }
}
