package com.dsa.strings.easy;

import java.util.ArrayList;
import java.util.List;

public class RemoveOutMostParenthesis {

	public String removeOuterParentheses(String s) {
		List<String> parenthesis = new ArrayList<>();
		int count = 0;
		int i = 0;
		int lastPointer = i;
		while (i < s.length()) {
			if (s.charAt(i) == '(') {
				count++;
			} else {
				count--;
			}
			if (count == 0) {
				parenthesis.add(s.substring(lastPointer, i + 1));
				lastPointer = i + 1;
			}
			i++;
		}
		StringBuilder sb = new StringBuilder();
		for (String str : parenthesis) {
			sb.append(str.substring(1, str.length() - 1));
		}
		return sb.toString();
	}

	// LC Solution in answers - TODO understand the intuition and logic behind this
	public String removeOuterParentheses_optimised(String s) {
		StringBuilder sb = new StringBuilder();
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if ((ch == '(' && count++ > 0) || (ch == ')' && count-- > 1)) {
				sb.append(ch);
			}
		}
		return sb.toString();
	}

}
