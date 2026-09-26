package com.dsa_series.roadmap.hashing.contest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupWordsByAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<List<Character>, List<String>> charStringMap = new HashMap<>();
        for (String str : strs) {
            List<Character> li = new ArrayList<>();
            for (int i = 0; i < str.length(); i++) {
                li.add(str.charAt(i));
            }
            Collections.sort(li);
            if (charStringMap.containsKey(li)) {
                charStringMap.get(li).add(str);
            } else {
                List<String> temp = new ArrayList<>();
                temp.add(str);
                charStringMap.put(li, temp);
            }
        }
        Collection<List<String>> valuesSet = charStringMap.values();
        List<List<String>> res = new ArrayList<>(valuesSet);
        return res;
    }

    public List<List<String>> groupAnagramsOptimal(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        for (String str : strs) {
            String key = getStringForWord(str);
            List<String> li = map.containsKey(key) ? map.get(key) : new ArrayList<>();
            li.add(str);
            map.put(key, li);
        }
        for (List<String> value : map.values()) {
            res.add(value);
        }
        return res;
    }

    private String getStringForWord(String word) {
        int[] hash = new int[26];
        for (int i = 0; i < word.length(); i++) {
            hash[word.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            sb.append(hash[i]).append("#");
        }
        return sb.toString();
    }
}
