package com.dsa.strings.easy;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {

	public boolean isIsomorphic_BruteForce(String s, String t) {
		Map<Character, Character> sToTmapping = new HashMap<>();
		Map<Character, Character> tToSmapping = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char sChar = s.charAt(i);
			char tChar = t.charAt(i);
			boolean isOverRidingMapCheck1 = sToTmapping.containsKey(sChar) && sToTmapping.get(sChar) != tChar;
			boolean isOverRidingMapCheck2 = tToSmapping.containsKey(tChar) && tToSmapping.get(tChar) != sChar;
			if (isOverRidingMapCheck1 || isOverRidingMapCheck2) {
				return false;
			} else {
				sToTmapping.put(sChar, tChar);
				tToSmapping.put(tChar, sChar);
			}
		}
		return true;
	}

	public boolean isIsomorphic_Better(String s, String t) {
		char[] charMap = new char[26];
		for (int i = 0; i < s.length(); i++) {
			char sChar = s.charAt(i);
			char tChar = t.charAt(i);
			int sIndex = sChar - 'a';
			int tIndex = tChar - 'a';
			boolean firstCheck = charMap[sIndex] >= 'a' && charMap[sIndex] <= 'z' && charMap[sIndex] != tChar;
			boolean secondCheck = charMap[tIndex] >= 'a' && charMap[tIndex] <= 'z' && charMap[tIndex] != sChar;
			if (firstCheck || secondCheck) {
				return false;
			} else {
				charMap[sIndex] = tChar;
				charMap[tIndex] = sChar;
			}
		}
		return true;
	}
}
