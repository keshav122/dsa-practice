package com.problems.medium;

public class AppendCharacterToStringToMakeSubsequnce_2486 {

	//TODO Not yet working correctly try for s: "ajkhe" and t : "juh"
	public static int appendCharacters(String s, String t) {
		int sIndex = 0;
		int tIndex = 0;
		boolean isMatching = true;
		if(s.indexOf(t) != -1) return 0;
		while (tIndex < t.length() && sIndex < s.length()) {
			if (s.charAt(sIndex) == t.charAt(tIndex)) {
				sIndex++;
				tIndex++;
			} else {
				isMatching = false;
				tIndex++;
			}
		}

		
		if (isMatching) {
			if (tIndex == t.length())
				return 0;
			return t.length() - tIndex;
		} else {
			return t.length() - sIndex;
		}
	}

	public static void main(String[] args) {
		String s = "lbg";
		String t = "g";
		System.out.println(appendCharacters(s, t));
	}
}
