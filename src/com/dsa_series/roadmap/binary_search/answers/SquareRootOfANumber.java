package com.dsa_series.roadmap.binary_search.answers;

public class SquareRootOfANumber {
    public long floorSqrt(long n) {
        long low = 1;
        long high = n - 1;
        while (low <= high) {
            long mid = (low + high) / 2;
            long product = mid * mid;
            if (product == n) {
                return mid;
            } else if (product < n) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public long floorSqrt1(long n) {
        long low = 1;
        long high = n;
        long ans = 1;
        while (low <= high) {
            long mid = (low + high) / 2;
            // if question check condition is found we update the answer
            // and eliminate the lower half because we want the maximum value
            if (mid * mid <= n) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    public long floorSqrt2(long n) {
        long low = 1;
        long high = n;
        while (low <= high) {
            long mid = (low + high) / 2;
            if (mid * mid <= n) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }
}
