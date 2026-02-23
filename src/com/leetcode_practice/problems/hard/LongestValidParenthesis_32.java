package com.leetcode_practice.problems.hard;

import java.util.Stack;

public class LongestValidParenthesis_32 {
    public int longestValidParentheses(String s) {
        int len = s.length();
        int maxLen = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if (isValid(s.substring(i, j + 1))) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }
        return maxLen;
    }

    private boolean isValid(String str) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (st.isEmpty()) {
                if (str.charAt(i) == ')') {
                    return false;
                } else {
                    st.push('(');
                }
            } else {
                if (st.peek() == '(') {
                    if (str.charAt(i) == '(') {
                        st.push('(');
                    } else {
                        st.pop();
                    }
                } else {
                    if (str.charAt(i) == '(') {
                        return false;
                    } else {
                        st.push(')');
                    }
                }
            }
        }
        return st.isEmpty();
    }

    public int longestValidParentheses_better(String s) {
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                st.push(i);
            } else {
                st.pop();
                if (st.isEmpty()) {
                    st.push(i);
                } else {
                    maxLen = Math.max(maxLen, i - st.peek());
                }
            }
        }
        return maxLen;
    }

    public int longestValidParentheses_DP(String s) {

    }

    public int longestValidParentheses_Optimal(String s) {
        int left = 0, right = 0, n = s.length(), maxLen = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }

            if (left == right) {
                maxLen = Math.max(maxLen, 2 * right);
            } else if (right > left) {
                left = right = 0;
            }
        }
        left = right = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }

            if (left == right) {
                maxLen = Math.max(maxLen, 2 * left);
            } else if (left > right) {
                left = right = 0;
            }
        }
        return maxLen;

    }
}
