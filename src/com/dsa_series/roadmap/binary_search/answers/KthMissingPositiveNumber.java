/*Author: keshav122 */
package com.dsa_series.roadmap.binary_search.answers;

public class KthMissingPositiveNumber {

    public static int findKthPositive_BF(int[] arr, int k) {
        int n = arr.length;
        if (arr[n - 1] - n < k) {
            return n + k;
        }
        for (int i = 0; i < n; i++) {
            if (arr[i] - (i + 1) >= k) {
                if (i >= 1) {
                    return k + i;
                } else {
                    return k;
                }

            }
        }
        return -1;
    }

    public static int findKthPositive(int[] arr, int k) {
        int n = arr.length;
        if (arr[n - 1] - n < k) {
            return k + n;
        }
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] - (mid + 1) < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        // return arr[low] + (k - (arr[low] - low));
        return low + k;
    }
}