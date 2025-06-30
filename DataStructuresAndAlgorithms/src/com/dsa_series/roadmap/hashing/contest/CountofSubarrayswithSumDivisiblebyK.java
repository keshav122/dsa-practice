package com.roadmap.hashing.contest;

public class CountofSubarrayswithSumDivisiblebyK {

    public int subarraySumDivisbleByK_BF(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        Map<Integer, Integer> sumFreqMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                if (sum % k == 0)
                    count++;
            }
        }
        return count;
    }

    // Not appropriate
    public int subarraySumDivisbleByK(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        Map<Integer, Integer> sumFreqMap = new HashMap<>();
        sumFreqMap.put(0, 1);
        int sum = 0, maxSum = 0, minSum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            maxSum = Math.max(maxSum, sum);
            minSum = Math.min(minSum, sum);
            int low = (minSum / k) - 1000;
            int high = (maxSum / k) + 1000;

            for (int j = low; j <= high; j++) {
                if (sumFreqMap.containsKey(sum - (j * k))) {
                    count += sumFreqMap.get(sum - (j * k));
                }
            }
            sumFreqMap.merge(sum, 1, Integer::sum);
        }
        return count;
    }
}
