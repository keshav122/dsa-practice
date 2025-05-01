package com.roadmap.bit_manipulation;

import java.util.Arrays;
import java.util.HashMap;

public class SingleNumber_III {
    public int[] singleNumber(int[] nums) {
        int ans[] = new int[2];
        ans[0] = Integer.MIN_VALUE;
        ans[1] = Integer.MIN_VALUE;
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.merge(num, 1, Integer::sum);
        }
        // Iterate on the map
        for (HashMap.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() == 1) {
                if (ans[0] == Integer.MIN_VALUE) {
                    ans[0] = entry.getKey();
                } else {
                    ans[1] = entry.getKey();
                }
            }
        }
        Arrays.sort(ans);
        return ans;
    }

    public int[] singleNumber_better(int[] nums) {
        int ans[] = new int[2];
        int n = nums.length;
        Arrays.sort(nums);
        boolean firstValFound = false;
        int i = 0;
        while (i < n) {
            if (i < n - 1 && (nums[i] ^ nums[i + 1]) != 0) {
                if (!firstValFound) {
                    ans[0] = nums[i];
                    firstValFound = true;
                } else {
                    ans[1] = nums[i];
                }
                i++;
            } else if (i == n - 1) {
                ans[1] = nums[i];
                i++;
            } else {
                i += 2;
            }
        }

        Arrays.sort(ans);
        return ans;
    }

    public int[] singleNumber_Optimal(int[] nums) {
        long xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        int rightmostBit = (int) (xor ^ (xor - 1)) & (int) (xor);
        int b1 = 0, b2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & rightmostBit) > 0) {
                b1 = b1 ^ nums[i];
            } else {
                b2 = b2 ^ nums[i];
            }
        }
        int[] ans = new int[2];
        ans[0] = Math.min(b1, b2);
        ans[1] = Math.max(b1, b2);
        return ans;
    }
}
