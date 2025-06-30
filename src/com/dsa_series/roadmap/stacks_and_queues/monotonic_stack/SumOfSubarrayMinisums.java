package com.dsa_series.roadmap.stacks_and_queues.monotonic_stack;

import java.util.Stack;

public class SumOfSubarrayMinisums {
    public int sumSubarrayMins_BF(int[] arr) {
        int n = arr.length;
        int MODULO = 1000000007;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int min = arr[i];
            for (int j = i; j < n; j++) {
                min = Math.min(arr[j], min);
                sum += (min % MODULO);
            }
        }
        return sum % MODULO;
    }

    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[] nse = nextSmallerElement(arr, n);
        int[] psee = previousSmallerOrEqualElement(arr, n);
        int mod = (int) (1e9 + 7);
        long sum = 0;
        for (int i = 0; i < n; i++) {
            int right = nse[i] - i;
            int left = i - psee[i];
            long freq = left * right * 1L;
            int val = (int) ((freq * arr[i]) % mod);
            sum = (sum + val) % mod;
        }
        return (int) sum;
    }

    private int[] nextSmallerElement(int[] arr, int n) {
        int[] nse = new int[n];
        Stack<Integer> st = new Stack<Integer>();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            nse[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return nse;
    }

    private int[] previousSmallerOrEqualElement(int[] arr, int n) {
        int[] psee = new int[n];
        Stack<Integer> st = new Stack<Integer>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }
            psee[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return psee;
    }
}
