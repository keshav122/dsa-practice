/*Author: keshav122 */
package com.dsa_series.roadmap.binary_search.answers;

public class KokoEatingBananas {
    public int minimumRateToEatBananas_BF(int[] nums, int h) {
        for (int i = 1; i <= 1000000000; i++) {
            int sum = getHours(nums, i);
            if (sum <= h) {
                return i;
            }
        }
        return 0;
    }

    public int minimumRateToEatBananas(int[] nums, int h) {
        int low = 1;
        int high = 1000000000;
        while (low <= high) {
            int mid = (low + high) / 2;
            int totalHoursReq = getHours(nums, mid);
            if (totalHoursReq <= h) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public int getHours(int[] nums, int hourRate) {
        int sum = 0;
        for (int num : nums) {
            if (num % hourRate == 0) {
                sum += num / hourRate;
            } else {
                sum += (num / hourRate) + 1;
            }

        }
        return sum;
    }
}
