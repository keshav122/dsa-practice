/*Author: keshav122 */
package com.dsa_series.roadmap.sliding_window_and_two_pointers.counting_subarrays_substrings_problems;

public class BinarySubarraysWithSum {
    public int numSubarraysWithSum_BF(int[] nums, int goal) {
        int n = nums.length, count = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                if (sum == goal) {
                    count++;
                }
                if (sum > goal) {
                    break;
                }
            }
        }
        return count;
    }

    public int numSubarraysWithSum(int[] nums, int goal) {
        return numSubarraysWithSumLessEqualToGoal(nums, goal) - numSubarraysWithSumLessEqualToGoal(nums, goal - 1);
    }

    public int numSubarraysWithSumLessEqualToGoal(int[] nums, int goal) {
        if (goal < 0)
            return 0;
        int n = nums.length;
        int count = 0, l = 0, r = 0, sum = 0;
        while (r < n) {
            sum += nums[r];
            while (sum > goal) {
                sum -= nums[l];
                l++;
            }
            count += (r - l + 1);
            r++;
        }
        return count;
    }
}
