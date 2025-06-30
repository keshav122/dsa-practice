package com.cn.guidedpaths.dsa.strings.introduction;

public class LeftAndRightRotationOfString {
	public static String leftRotate(String str, int d) {
		String res = "";
		d = d % str.length();
		res += str.substring(d);
		res += str.substring(0, d);
		return res;

	}

	public static String rightRotate(String str, int d) {
		String res = "";
		d = d % str.length();
		res += str.substring(str.length() - d);
		res += str.substring(0, str.length() - d);
		return res;
	}

}
