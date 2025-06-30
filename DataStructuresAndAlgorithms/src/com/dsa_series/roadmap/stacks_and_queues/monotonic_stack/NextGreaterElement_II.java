package com.roadmap.stacks_and_queues.monotonic_stack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement_II {
    public int[] nextGreaterElements_BF(int[] arr) {
        int n = arr.length;
        int[] nge = new int[n];
        Arrays.fill(nge, -1);
        for (int i = 0; i < n; i++) {
            // look to the right
            for (int j = i + 1; j < i + n - 1; j++) {
                int index = j % n;
                if (arr[index] > arr[i]) {
                    nge[i] = arr[index];
                    break;
                }
            }
        }
        return nge;
    }

    public int[] nextGreaterElements_better(int[] arr) {
        int n = arr.length;
        int[] nge = new int[n];
        Arrays.fill(nge, -1);
        for (int i = 0; i < n; i++) {
            // look to the right
            for (int j = i + 1; j < i + n - 1; j++) {
                int index = j % n;
                if (arr[index] > arr[i]) {
                    nge[i] = arr[index];
                    break;
                }
            }
        }
        return nge;
    }

    public int[] nextGreaterElements_Optimal(int[] arr) {
        int n = arr.length;
        int[] nge = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 2 * n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[i % n] >= st.peek()) {
                st.pop();
            }

            if (i < n) {
                nge[i] = (st.isEmpty()) ? -1 : st.peek();
            }
            st.push(arr[i % n]);
        }
        return nge;
    }
}
