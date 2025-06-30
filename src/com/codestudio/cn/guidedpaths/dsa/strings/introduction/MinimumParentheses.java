package com.codestudio.cn.guidedpaths.dsa.strings.introduction;

import java.util.Stack;

public class MinimumParentheses {

	public static int minimumParentheses(String pattern) {
		Stack<Character> st = new Stack<>();
		int count = 0;
		for (int i = 0; i < pattern.length(); i++) {
			char c = pattern.charAt(i);
			if (c == '(') {
				st.push(c);
			} else {
				if (st.isEmpty()) {
					count++;
				} else {
					st.pop();
				}
			}
		}
		return count + st.size();
	}
}
