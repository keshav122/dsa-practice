package com.roadmap.stacks_and_queues.monotonic_stack;

import java.util.Arrays;

public class NextGreaterElement {
    public int[] nextLargerElement_BF(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        for (int i = n - 2; i >= 0; i--) {
            int currEle = arr[i];
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > currEle) {
                    ans[i] = arr[j];
                    break;
                }
            }
        }
        return ans;

    }
}
