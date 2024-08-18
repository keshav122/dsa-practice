package com.roadmap.basic_strings;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
    // This code will fail for leetcode testcases
    public boolean isomorphicString(String s, String t) {
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            sMap.merge(s.charAt(i), 1, Integer::sum);
            tMap.merge(t.charAt(i), 1, Integer::sum);
        }

        // This map will store the number of times each frequency
        Map<Integer, Integer> freqCountMap = new HashMap<>();
        for (Map.Entry<Character, Integer> entry : sMap.entrySet()) {
            if (freqCountMap.containsKey(entry.getValue())) {
                freqCountMap.put(entry.getValue(), freqCountMap.get(entry.getValue()) + 1);
            } else {
                freqCountMap.put(entry.getValue(), 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : tMap.entrySet()) {
            if (freqCountMap.containsKey(entry.getValue())) {
                freqCountMap.put(entry.getValue(), freqCountMap.get(entry.getValue()) - 1);
            } else {
                freqCountMap.put(entry.getValue(), 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : freqCountMap.entrySet()) {
            if (entry.getValue() != 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "egg";
        String t = "abd";
        IsomorphicStrings i = new IsomorphicStrings();
        System.out.println(i.isomorphicString(s, t));
    }
}
