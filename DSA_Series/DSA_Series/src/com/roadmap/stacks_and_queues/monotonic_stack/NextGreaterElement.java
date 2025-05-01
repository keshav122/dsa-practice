package com.roadmap.stacks_and_queues.monotonic_stack;

import java.util.Arrays;
import java.util.Stack;

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

    public int[] nextLargerElement(int[] arr) {
        int n = arr.length;
        int[] nge = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            int currElement = arr[i];
            while (!st.isEmpty() && st.peek() <= currElement) {
                st.pop();
            }
            if (st.isEmpty()) {
                nge[i] = -1;
            } else {
                nge[i] = st.peek();
            }
            st.push(currElement);
        }
        return nge;
    }

}
