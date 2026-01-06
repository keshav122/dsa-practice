package com.leetcode_practice.problems.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityFrequencyCharacters_3692 {
    public String majorityFrequencyGroup(String s) {
        int[] hash = new int[26];
        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i) - 'a']++;
        }

        // freq -- 1 -> {a,b}
        Map<Integer, List<Character>> map = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            if (hash[i] != 0) {
                map.computeIfAbsent(hash[i], k -> new ArrayList<>()).add((char) (i + 'a'));
            }
        }

        int maxSize = 0;
        int maxFreq = 0;
        for (Map.Entry<Integer, List<Character>> entry : map.entrySet()) {
            if (entry.getValue().size() > maxSize || (entry.getValue().size() == maxSize) && entry.getKey() > maxFreq) {
                maxFreq = entry.getKey();
                maxSize = entry.getValue().size();
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Character ch : map.get(maxFreq)) {
            sb.append(ch);
        }
        return sb.toString();

    }
}
