package com.problems.medium;

public class NumberOfSubSequencesThatSatisyTheGivenCondition_1498 {
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int i = 0;
        int j = n - 1;
        int subSequences = 0;
        int modulo = 1000000007;
        int[] pow = new int[n];
        pow[0] = 1;
        for (int k = 1; k < n; k++) {
            pow[k] = (pow[k - 1] * 2) % modulo;
        }

        while (i <= j) {
            if (nums[i] + nums[j] <= target) {
                subSequences = (subSequences + pow[j - i]) % modulo;
                i++;
            } else {
                j--;
            }
        }
        return subSequences;

    }
}
