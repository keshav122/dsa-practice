package com.dsa.strings.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

	public boolean isAnagram_1(String s, String t) {
		if(s.length() != t.length()) return false;
		char[] sArr = s.toCharArray();
		char[] tArr = t.toCharArray();
		Arrays.sort(sArr);
		Arrays.sort(tArr);
		for(int i = 0; i < sArr.length;i++) {
			if(sArr[i] != tArr[i]) return false;
		}
		return true;
    }
	
	public boolean isAnagram_MapBasedSol(String s, String t) {
		if(s.length() != t.length()) return false;
		Map<Character,Integer> freqMap = new HashMap<>();
        for(int i = 0; i< s.length();i++) {
        	char tChar = t.charAt(i);
        	freqMap.merge(s.charAt(i), 1, Integer::sum);
        	if(freqMap.containsKey(tChar)) {
        		freqMap.put(tChar, freqMap.get(tChar) -1);
        	}else {
        		freqMap.put(tChar,-1);
        	}
        	
        }
        
        for(Map.Entry<Character,Integer> entry : freqMap.entrySet()) {
        	if(entry.getValue() != 0) return false;
        }
        return true;
    }
	
	public boolean isAnagram(String s, String t) {
		if(s.length() != t.length()) return false;
        int[] charArray = new int[26];
        for(int i = 0; i< s.length();i++) {
        	charArray[s.charAt(i)-'a']++;
        	charArray[t.charAt(i)-'a']--;
        }
        
        for(int i : charArray) {
        	if(i != 0) return false;
        }
        return true;
    }
	
	public boolean isAnagram_OnlineSOl(String s, String t) {
		Map<Integer, Integer> freqMap = new HashMap<>();
		s.chars().forEach(c -> freqMap.put(c, freqMap.getOrDefault(c, 0) + 1));
		t.chars().forEach(c -> freqMap.put(c, freqMap.getOrDefault(c, 0) - 1));
		return freqMap.values().stream().allMatch(x -> x == 0);
	}	
}

