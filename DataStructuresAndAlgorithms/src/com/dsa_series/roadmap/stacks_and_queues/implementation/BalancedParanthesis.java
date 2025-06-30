package com.roadmap.stacks_and_queues.implementation;

import java.util.Stack;

public class BalancedParanthesis {
    public boolean isValid(String str) {
        Stack<Character> st = new Stack<>();
        int i = 0;
        while (i < str.length()) {
            char c = str.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                st.push(c);
            } else {
                if (st.isEmpty())
                    return false;
                else if ((c == ')' && st.peek() != '(') || (c == ']' && st.peek() != '[')
                        || (c == '}' && st.peek() != '{')) {
                    return false;
                } else {
                    st.pop();
                }

            }
            i++;
        }
        return (st.isEmpty());
    }
}
