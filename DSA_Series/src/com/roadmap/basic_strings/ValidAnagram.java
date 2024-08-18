package com.roadmap.basic_strings;

public class ValidAnagram {
    public boolean anagramStrings(String s, String t) {
        if (s.length() != t.length())
            return false;
        int[] charArr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            charArr[s.charAt(i) - 'a']++;
            charArr[t.charAt(i) - 'a']--;
        }
        for (int i : charArr) {
            if (i != 0)
                return false;
        }
        return true;
    }
}
