package com.roadmap.stacks_and_queues.monotonic_stack;

import java.util.Stack;

public class RemoveKDigits {
    public String removeKdigits(String nums, int k) {
        // The intuition is a greedy one - to keep the smallest digits at the start.
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < nums.length(); i++) {
            while (!st.isEmpty() && k > 0 && st.peek() - '0' > nums.charAt(i) - '0') {
                st.pop();
                k--;
            }
            st.push(nums.charAt(i));
        }
        while (k > 0) {
            st.pop();
            k--;
        }

        if (st.isEmpty())
            return "0";
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }

        String reversed = sb.toString();
        // In case the string has leading zeroes , it will have the zeroes at the end in
        // the reversed string
        for (int i = reversed.length() - 1; i >= 0; i--) {
            if (reversed.charAt(i) == '0') {
                reversed = reversed.substring(0, i);
            } else {
                break;
            }
        }

        if (reversed.length() == 0)
            return "0";
        StringBuilder ans = new StringBuilder();
        for (int i = reversed.length() - 1; i >= 0; i--) {
            ans.append(reversed.charAt(i));
        }
        return ans.toString();
    }
}
