package com.dsa_series.roadmap.stacks_and_queues.FAQs;

import java.util.Stack;

public class LargestRectangleArea {
    public int largestRectangleArea_BF(int[] heights) {
        int n = heights.length;
        int[] nse = findNSE(heights, n);
        int[] pse = findPSE(heights, n);
        int maximum = 0;
        for (int i = 0; i < n; i++) {
            maximum = Math.max(maximum, heights[i] * (nse[i] - pse[i] - 1));
        }
        return maximum;
    }

    private int[] findPSE(int[] heights, int n) {
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            ans[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return ans;
    }

    private int[] findNSE(int[] heights, int n) {
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            ans[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return ans;
    }

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && heights[st.peek()] > heights[i]) {
                int element = st.pop();
                int nse = i;
                int pse = st.isEmpty() ? -1 : st.peek();
                maxArea = Math.max(maxArea, heights[element] * (nse - pse - 1));
            }
            st.push(i);
        }
        while ((!st.isEmpty())) {
            int element = st.pop();
            int nse = n;
            int pse = st.isEmpty() ? -1 : st.peek();
            maxArea = Math.max(maxArea, heights[element] * (nse - pse - 1));
        }
        return maxArea;
    }
}
