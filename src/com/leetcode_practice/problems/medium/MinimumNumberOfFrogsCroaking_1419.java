package com.leetcode_practice.problems.medium;

import java.util.HashMap;
import java.util.Map;

public class MinimumNumberOfFrogsCroaking_1419 {
    public int minNumberOfFrogs(String croakOfFrogs) {
        int maxCount = 0;
        Map<Character, String> previousChar = new HashMap<>();
        previousChar.put('r', "c");
        previousChar.put('o', "cr");
        previousChar.put('a', "cro");
        previousChar.put('k', "croa");
        Map<String, Integer> strFreqMap = new HashMap<>();
        for (int i = 0; i < croakOfFrogs.length(); i++) {
            char ch = croakOfFrogs.charAt(i);
            if (ch == 'c') {
                strFreqMap.put("c", strFreqMap.getOrDefault("c", 0) + 1);
            } else {
                String prev = previousChar.get(ch);
                if (strFreqMap.containsKey(prev) && strFreqMap.get(prev) > 0) {
                    strFreqMap.put(prev, strFreqMap.get(prev) - 1);
                    String newStr = prev + ch;
                    if (ch != 'k') {
                        strFreqMap.put(newStr, strFreqMap.getOrDefault(newStr, 0) + 1);
                    }
                } else {
                    return -1;
                }
            }
            int sum = 0;
            for (Integer value : strFreqMap.values()) {
                sum += value;
            }
            maxCount = Math.max(sum, maxCount);
        }
        for (Integer value : strFreqMap.values()) {
            if (value != 0)
                return -1;
        }
        return maxCount;
    }

    // GPT
    public int minNumberOfFrogs_optimal(String croak) {
        int c = 0, r = 0, o = 0, a = 0;
        int frogs = 0, maxFrogs = 0;

        for (char ch : croak.toCharArray()) {
            switch (ch) {
                case 'c':
                    c++;
                    frogs++;
                    maxFrogs = Math.max(maxFrogs, frogs);
                    break;
                case 'r':
                    if (c == 0)
                        return -1;
                    c--;
                    r++;
                    break;
                case 'o':
                    if (r == 0)
                        return -1;
                    r--;
                    o++;
                    break;
                case 'a':
                    if (o == 0)
                        return -1;
                    o--;
                    a++;
                    break;
                case 'k':
                    if (a == 0)
                        return -1;
                    a--;
                    frogs--; // frog finished croaking
                    break;
                default:
                    return -1;
            }
        }

        if (c != 0 || r != 0 || o != 0 || a != 0)
            return -1;
        return maxFrogs;
    }

}
