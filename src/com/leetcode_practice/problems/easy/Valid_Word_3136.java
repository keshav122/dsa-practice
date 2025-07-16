package com.leetcode_practice.problems.easy;

import java.util.Arrays;
import java.util.List;

public class Valid_Word_3136 {

    public boolean isValid_BF(String word) {
        if (word.length() < 3)
            return false;
        boolean containsVowel = false, containsConsonant = false;
        List<Character> vowelList = Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            boolean isLowerCase = (c - 'a') >= 0 && (c - 'a') <= 26;
            boolean isUpperCase = (c - 'A') >= 0 && (c - 'A') <= 26;
            if (isLowerCase) {
                if (vowelList.contains(c)) {
                    containsVowel = true;
                } else {
                    containsConsonant = true;
                }
            }
            if (isUpperCase) {
                if (vowelList.contains(c)) {
                    containsVowel = true;
                } else {
                    containsConsonant = true;
                }
            }

            boolean isDigit = (c - '0') >= 0 && (c - '0') <= 9;
            if (!(isLowerCase || isUpperCase || isDigit)) {
                return false;
            }
        }
        return containsVowel && containsConsonant;
    }

    public boolean isValid(String word) {
        if (word.length() < 3)
            return false;
        boolean containsVowel = false, containsConsonant = false;
        String vowel = "aeiouAEIOU";
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!Character.isLetterOrDigit(c)) {
                return false;
            }
            if (Character.isLetter(c)) {
                if (vowel.indexOf(c) >= 0) {
                    containsVowel = true;
                } else {
                    containsConsonant = true;
                }
            }
        }
        return containsVowel && containsConsonant;
    }

    public static boolean isValidOptimized(String word) {
        if (word.length() < 3)
            return false;
        boolean containsVowel = false, containsConsonant = false;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!Character.isLetterOrDigit(c)) {
                return false;
            }
            if (Character.isLetter(c)) {
                switch (c) {
                    case 'a':
                    case 'e':
                    case 'i':
                    case 'o':
                    case 'u':
                    case 'A':
                    case 'E':
                    case 'I':
                    case 'O':
                    case 'U':
                        containsVowel = true;
                        break;
                    default:
                        containsConsonant = true;
                }
            }
        }
        return containsVowel && containsConsonant;
    }
}
