package com.leetcode_practice.contest.weekly.count_480;

import java.util.Set;

public class ReverseWordsWithSameVowelCount_3775 {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        if (words.length == 1)
            return s;
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        int initVowelCount = getVowelCount(words[0], vowels);
        StringBuilder sb = new StringBuilder(words[0] + " ");
        int n = words.length;
        for (int i = 1; i < n; i++) {
            int vowelCnt = getVowelCount(words[i], vowels);
            if (vowelCnt == initVowelCount) {
                sb.append(new StringBuilder(words[i]).reverse().toString());
            } else {
                sb.append(words[i]);
            }
            if (i != n - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    private int getVowelCount(String word, Set<Character> vowels) {
        int cnt = 0;
        for (int i = 0; i < word.length(); i++) {
            if (vowels.contains(word.charAt(i))) {
                cnt++;
            }
        }
        return cnt;
    }

    public String reverseWords_optimal(String s) {
        StringBuilder sb = new StringBuilder();
        int n = s.length(), i = 0, firstVowelCount = 0;
        while (i < n && s.charAt(i) != ' ') {
            char c = s.charAt(i);
            if (isVowel(c)) {
                firstVowelCount++;
            }
            sb.append(c);
            i++;
        }
        if (i == n)
            return s;
        sb.append(s.charAt(i));
        i++;
        int currVowelCount = 0, currWordStart = i;
        while (i < n) {
            char c = s.charAt(i);
            if (c == ' ') {
                if (currVowelCount == firstVowelCount) {
                    for (int ind = i - 1; ind >= currWordStart; ind--) {
                        sb.append(s.charAt(ind));
                    }
                } else {
                    for (int j = currWordStart; j < i; j++) {
                        sb.append(s.charAt(j));
                    }
                }
                sb.append(c);
                currVowelCount = 0;
                currWordStart = i + 1;
            } else {
                if (isVowel(c)) {
                    currVowelCount++;
                }
            }
            i++;
        }

        if (currVowelCount == firstVowelCount) {
            for (int ind = n - 1; ind >= currWordStart; ind--) {
                sb.append(s.charAt(ind));
            }
        } else {
            for (int j = currWordStart; j < n; j++) {
                sb.append(s.charAt(j));
            }
        }
        return sb.toString();
    }

    private boolean isVowel(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
            return true;
        return false;
    }
}
