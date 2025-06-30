package com.dsa_series.roadmap.binary_search.answers;

public class FindTheSmallestDivisor {
    public int smallestDivisor_BF(int[] nums, int limit) {
        for (int i = 1; i <= 10000000; i++) {
            int sum = getSum(nums, i);
            if (sum <= limit) {
                return i;
            }
        }
        return -1;
    }

    public int smallestDivisor(int[] nums, int limit) {
        int low = 1;
        int high = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = (low + high) / 2;
            int sum = getSum(nums, mid);
            if (sum <= limit) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public int getSum(int[] nums, int divisor) {
        int sum = 0;
        for (int num : nums) {
            if (num % divisor == 0) {
                sum += num / divisor;
            } else {
                sum += (num / divisor) + 1;
            }

        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        int limit = 8;
        FindTheSmallestDivisor f = new FindTheSmallestDivisor();
        System.out.println(f.smallestDivisor_BF(arr, limit));
    }
}
