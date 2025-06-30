package com.roadmap.bit_manipulation;

import java.util.Arrays;
import java.util.HashMap;

public class SingleNumber_II {

    public int singleNumber_BF1(int[] nums) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.merge(num, 1, Integer::sum);
        }
        // Iterate on the map
        for (HashMap.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return -1;
    }

    public int singleNumber_Better1(int[] nums) {
        int ans = 0;
        for (int bitIndex = 0; bitIndex < 32; bitIndex++) {
            int count = 0;
            for (int num : nums) {
                if ((num & (1 << bitIndex)) != 0) {
                    count++;
                }
            }
            if (count % 3 == 1) {
                // Set the value 1 at bitIndex
                ans |= (1 << bitIndex);

            }
        }
        return ans;
    }

    public int singleNumber_BetterIIMyAttempt(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return nums[0];
        Arrays.sort(nums);
        int i = 0;
        while (i < n) {
            if (i < n - 1) {
                int val = nums[i] ^ nums[i + 1];
                if (val != 0) {
                    return nums[i];
                } else {
                    i += 3;
                }
            } else {
                return nums[n - 1];
            }

        }
        return -1;
    }

    public int singleNumber_BetterII(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 1; i < n; i += 3) {
            if (nums[i] != nums[i - 1]) {
                return nums[i - 1];
            }
        }
        return nums[n - 1];
    }

    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        for (int i = 0; i < nums.length; i++) {
            ones = (ones ^ nums[i]) & (~twos);
            twos = (twos ^ nums[i]) & (~ones);
        }
        return ones;
    }
}
