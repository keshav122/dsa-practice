package com.problems.easy;

public class ValidPalindrome_125 {

	public boolean isPalindrome(String s) {
		String str = getLowerCaseAlphanumericString(s);
		int sI = 0;
		int eI = str.length() - 1;
		while (sI <= eI) {
			if (str.charAt(sI) != str.charAt(eI))
				return false;
			sI++;
			eI--;
		}
		return true;
	}

	private String getLowerCaseAlphanumericString(String s) {
		s = s.toLowerCase();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			boolean isAlphaNumericChar = (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
			if (isAlphaNumericChar)
				sb.append(c);
		}
		return sb.toString();
	}
}
