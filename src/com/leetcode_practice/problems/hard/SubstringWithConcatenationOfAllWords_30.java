package com.leetcode_practice.problems.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringWithConcatenationOfAllWords_30 {
    public List<Integer> findSubstring(String s, String[] words) {
        Map<String, Integer> wordsFreq = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        int wordLen = words[0].length();
        int substringLen = words.length * wordLen;
        for (String word : words) {
            wordsFreq.merge(word, 1, Integer::sum);
        }

        // This logic is important
        for (int r = 0; r + substringLen <= s.length(); r++) {
            Map<String, Integer> map = new HashMap<>();
            for (int i = r; i < r + substringLen; i += wordLen) {
                String word = s.substring(i, i + wordLen);
                map.merge(word, 1, Integer::sum);
            }
            if (equalFreq(wordsFreq, map)) {
                ans.add(r);
            }
        }
        return ans;
    }

    private boolean equalFreq(Map<String, Integer> wordsFreq, Map<String, Integer> map) {
        if (wordsFreq.size() != map.size())
            return false;
        for (Map.Entry<String, Integer> entry : wordsFreq.entrySet()) {
            String key = entry.getKey();
            if (!map.containsKey(key) || !wordsFreq.get(key).equals(map.get(key))) {
                return false;
            }
        }
        return true;
    }

    public List<Integer> findSubstring_Optimal(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        if (s.isEmpty() || words.length == 0)
            return ans;
        int wordLen = words[0].length();
        int totalWords = words.length;

        // Build frequency map
        Map<String, Integer> wordsFreq = new HashMap<>();
        for (String word : words) {
            wordsFreq.merge(word, 1, Integer::sum);
        }

        for (int offset = 0; offset < wordLen; offset++) {
            int left = offset, right = offset;
            Map<String, Integer> window = new HashMap<>();
            int count = 0;// number of valid words in current window
            while (right + wordLen <= s.length()) {
                String word = s.substring(right, count);
                right += wordLen;

                if (wordsFreq.containsKey(word)) {
                    window.merge(word, 1, Integer::sum);
                    if (window.get(word) <= wordsFreq.get(word)) {
                        count++;
                    }

                    while (window.get(word) > wordsFreq.get(word)) {
                        String leftword = s.substring(left, left + wordLen);
                        left += wordLen;
                        window.put(leftword, window.get(leftword) - 1);
                        if (window.get(leftword) < wordsFreq.get(leftword)) {
                            count--;
                        }
                    }

                    if (count == totalWords) {
                        ans.add(left);
                    }
                } else {
                    window.clear();
                    count = 0;
                    left = right;
                }
            }
        }
        return ans;
    }
}
