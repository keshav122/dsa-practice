/*Author: keshav122 */
package com.dsa_series.roadmap.binary_search.answers;

//Improvements suggested
// Line 24-25: Suggest renaming variables for clarity (e.g., 'maxDay' could be 'currentMaxDay')
// Line 35: Add a comment explaining the binary search logic for clarity
// Line 49: Improve naming for clarity (consider 'daysToBloom' or 'bloomingDay')

public class MinimumDaysToMakeMBouquets {
    public int roseGardenBF(int n, int[] nums, int k, int m) {
        if (k * m > n)
            return -1;
        for (int day = 1; day < 1000000000; day++) {
            int bouquets = getBouquetCount(nums, day, n, k);
            if (bouquets >= m) {
                return day;
            }
        }
        return -1;
    }

    public int roseGarden(int n, int[] nums, int k, int m) {
        if (k * m > n)
            return -1;
        int minVal = Integer.MAX_VALUE;
        int maxVal = Integer.MIN_VALUE;
        for (int num : nums) {
            minVal = Math.min(num, minVal);
            maxVal = Math.max(num, maxVal);
        }
        int minDay = minVal;
        int maxDay = maxVal;
        while (minDay <= maxDay) {
            int mid = (minDay + maxDay) / 2;
            int bouquets = getBouquetCount(nums, mid, n, k);
            if (bouquets >= m) {
                maxDay = mid - 1;
            } else {
                minDay = mid + 1;
            }
        }
        return minDay;
    }

    private int getBouquetCount(int[] nums, int day, int n, int k) {
        int bouquetCount = 0;
        int roseCount = 0;
        for (int i = 0; i < n; i++) {
            // means that flower has already bloomed
            if (nums[i] <= day) {
                roseCount++;
            } else {
                roseCount = 0;
            }
            if (roseCount == k) {
                bouquetCount++;
                roseCount = 0;
            }
        }
        return bouquetCount;
    }

}
