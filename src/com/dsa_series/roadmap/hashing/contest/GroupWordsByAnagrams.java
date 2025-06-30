package com.dsa_series.roadmap.hashing.contest;

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
}
