package com.cn.guidedpaths.dsa.basicalgorithms.twopointerstechnique;

public class RemoveConsecutiveDuplicatesFromString {

	public static String removeConsecutive(StringBuilder str) {
		int i = 0;
		int j = 1;
		while (i < str.length() - 1) {
			if (str.charAt(j) == str.charAt(i)) {
				str.deleteCharAt(j);
			} else {
				i++;
				j++;
			}
		}
		return str.toString();
	}
}
