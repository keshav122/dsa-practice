package com.dsa_series.roadmap.binary_search.answers;

public class CapacityToShipPackagesWithinDDays {
    public int shipWithinDays(int[] weights, int days) {
        int low = weights[0];
        int high = 0;
        for (int weight : weights) {
            low = Math.max(low, weight);
            high += weight;
        }

        int ans = -1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (possible(weights, days, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private boolean possible(int[] weights, int days, int capacity) {
        int currLoad = 0;
        int daysReq = 1;
        for (int weight : weights) {
            if (currLoad + weight > capacity) {
                daysReq++;
                currLoad = weight;
            } else {
                currLoad += weight;
            }
        }
        return daysReq <= days;
    }
}
