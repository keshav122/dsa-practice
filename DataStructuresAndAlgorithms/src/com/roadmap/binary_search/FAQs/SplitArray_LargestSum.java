package com.roadmap.binary_search.FAQs;

//Same as Painter's Partition
//Same as Minimising Maximum Subarray sum for k subarrays
public class SplitArray_LargestSum {
    public int largestSubarraySumMinimized(int[] a, int k) {
        int low = 0;
        int high = 0;
        int ans = 0;
        for (int num : a) {
            low = Math.max(low, num);
            high += num;
        }
        while (low <= high) {
            int mid = (low + high) / 2;
            int partitions = getNumberOfPartitions(a, mid);
            if (partitions > k) {
                low = mid + 1;
            } else {
                ans = mid;
                high = mid - 1;
            }
        }
        return ans;
    }

    public int getNumberOfPartitions(int[] a, int sum) {
        int partition = 1;
        int currentSum = 0;
        for (int i = 0; i < a.length; i++) {
            if (currentSum + a[i] <= sum) {
                currentSum += a[i];
            } else {
                partition++;
                currentSum = a[i];
            }
        }
        return partition;
    }
}
