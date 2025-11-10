/*Author: keshav122 */
package com.dsa_series.roadmap.stacks_and_queues.FAQs;

import java.util.Stack;

public class StockSpanProblem {
    public int[] stockSpan(int[] arr, int n) {
        int[] pge = previousGreaterElement(arr, n);
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = i - pge[i];
        }
        return res;
    }

    public int[] previousGreaterElement(int[] arr, int n) {
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            int currElement = arr[i];
            while (!st.isEmpty() && arr[st.peek()] <= currElement) {
                st.pop();
            }
            ans[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return ans;
    }
}
