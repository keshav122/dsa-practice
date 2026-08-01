/*Author: keshav122 */
package com.dsa_series.roadmap.beginnerproblems.basic_strings;

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

    public boolean isomorphicString_better(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        Map<Character, Character> revMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            char ch1 = t.charAt(i);
            if ((map.containsKey(ch) && map.get(ch) != ch1) || (revMap.containsKey(ch1) && revMap.get(ch1) != ch))
                return false;
            else {
                map.put(ch, ch1);
                revMap.put(ch1, ch);
            }
        }
        return true;
    }

    public boolean isomorphicString_optimal(String s, String t) {
        // Arrays to store last seen positions of characters in string s and t
        int[] m1 = new int[256];
        int[] m2 = new int[256];

        for (int i = 0; i < s.length(); i++) {
            if (m1[s.charAt(i)] != m2[t.charAt(i)])
                return false;
            m1[s.charAt(i)] = i + 1;
            m2[t.charAt(i)] = i + 1;
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
