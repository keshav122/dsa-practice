package com.dsa_series.roadmap.arrays.logic_building;

public class FindMissingNumber {

    public int missingNumber_BF(int[] nums) {
        int n = nums.length;
        for (int i = 0; i <= n; i++) {
            boolean numberFound = false;
            for (int j = 0; j < n; j++) {
                if (nums[j] == i) {
                    numberFound = true;
                    break;
                }
            }
            if (!numberFound)
                return i;
        }
        return 0;
    }

    public int missingNumber_better(int[] nums) {
        int n = nums.length;
        int[] presenceArray = new int[n + 1];

        // If the element is present increment the presence array
        for (int i = 0; i < n; i++) {
            presenceArray[nums[i]]++;
        }

        // If the element is not present return the number
        for (int i = 0; i <= n; i++) {
            if (presenceArray[i] == 0)
                return i;
        }
        return -1;
    }

    public int missingNumber_OptimalSumBased(int[] nums) {
        int sum = 0;
        int n = nums.length;
        int naturalSum = ((n + 1) * n) / 2;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        return Math.abs(naturalSum - sum);
    }

    // Slightly better as for large nums we won't require long to store
    public int missingNumber_OptimalXOR(int[] nums) {
        int xor1 = 0, xor2 = 0;
        for (int i = 0; i < nums.length; i++) {
            xor1 ^= (i + 1);// Xor up to [1...N]
            xor2 ^= nums[i];// XOR of array elements
        }
        return xor1 ^ xor2;
    }
}
