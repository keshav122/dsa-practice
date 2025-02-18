package com.roadmap.sliding_window_and_two_pointers.counting_subarrays_substrings_problems;

import java.util.Stack;

public class MaximumRectangles {
    public int maximalAreaOfSubMatrixOfAll1(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int maxArea = 0;
        int[][] prefixSum = new int[rows][cols];
        for (int j = 0; j < cols; j++) {
            int sum = 0;
            for (int i = 0; i < rows; i++) {
                sum += matrix[i][j];
                if (matrix[i][j] == 0)
                    sum = 0;
                prefixSum[i][j] = sum;
            }
        }

        for (int i = 0; i < rows; i++) {
            maxArea = Math.max(maxArea, largestHistogram(prefixSum[i]));
        }
        return maxArea;
    }

    public int largestHistogram(int[] heights) {
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
