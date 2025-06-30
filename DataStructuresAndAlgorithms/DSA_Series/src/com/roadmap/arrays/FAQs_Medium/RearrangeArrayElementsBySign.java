package com.roadmap.arrays.FAQs_Medium;

public class RearrangeArrayElementsBySign {
    public int[] rearrangeArray(int[] nums) {
        int[] ans = new int[nums.length];
        int positiveIntegerPtr = 0;
        int negativeIntegerPtr = 1;
        for (int num : nums) {
            if (num > 0) {
                ans[positiveIntegerPtr] = num;
                positiveIntegerPtr += 2;
            } else {
                ans[negativeIntegerPtr] = num;
                negativeIntegerPtr += 2;
            }
        }
        return ans;
    }
}
