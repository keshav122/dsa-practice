package com.dsa_series.roadmap.stacks_and_queues.monotonic_stack;

import java.util.Stack;

public class SumOfSubarrayRanges {
    public long subArrayRanges_BF(int[] nums) {
        int n = nums.length;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            int min = nums[i];
            int max = nums[i];
            for (int j = i; j < n; j++) {
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);
                sum += (max - min);
            }
        }
        return sum;
    }

    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        return sumMaxSubarray(nums, n) - sumMinSubarray(nums, n);
    }

    private long sumMaxSubarray(int[] nums, int n) {
        int[] nge = nextGreaterElement(nums, n);
        int[] psge = previousGreaterOrEqualElement(nums, n);
        long sum = 0;
        for (int i = 0; i < n; i++) {
            int left = i - psge[i];
            int right = nge[i] - i;
            long freq = left * right * 1L;
            long val = (freq * nums[i] * 1L);
            sum += val;
        }
        return sum;
    }

    private long sumMinSubarray(int[] nums, int n) {
        int[] nse = nextSmallerElement(nums, n);
        int[] psee = previousSmallerOrEqualElement(nums, n);
        long sum = 0;
        for (int i = 0; i < n; i++) {
            int left = i - psee[i];
            int right = nse[i] - i;
            long freq = left * right * 1L;
            long val = (freq * nums[i] * 1L);
            sum += val;
        }
        return sum;
    }

    private int[] nextSmallerElement(int[] nums, int n) {
        int[] nse = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peek()] >= nums[i]) {
                st.pop();
            }
            nse[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return nse;
    }

    private int[] previousSmallerOrEqualElement(int[] nums, int n) {
        int[] psee = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && nums[st.peek()] > nums[i]) {
                st.pop();
            }
            psee[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return psee;
    }

    private int[] nextGreaterElement(int[] nums, int n) {
        int[] nge = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peek()] <= nums[i]) {
                st.pop();
            }
            nge[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return nge;
    }

    private int[] previousGreaterOrEqualElement(int[] nums, int n) {
        int[] pgee = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && nums[st.peek()] < nums[i]) {
                st.pop();
            }
            pgee[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return pgee;
    }
}
