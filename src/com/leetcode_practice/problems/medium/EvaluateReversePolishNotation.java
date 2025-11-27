package com.leetcode_practice.problems.medium;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int secondNo = st.pop();
                int firstNo = st.pop();
                st.push(operation(token, firstNo, secondNo));
            } else {
                st.push(Integer.parseInt(token));
            }
        }
        return st.peek();
    }

    private int operation(String op, int firstNo, int secondNo) {
        switch (op) {
            case "+":
                return firstNo + secondNo;
            case "-":
                return firstNo - secondNo;
            case "*":
                return firstNo * secondNo;
            case "/":
                return firstNo / secondNo;
            default:
                return 0;
        }
    }
}
