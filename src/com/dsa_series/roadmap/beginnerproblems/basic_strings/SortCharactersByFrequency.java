/*Author: keshav122 */
package com.dsa_series.roadmap.beginnerproblems.basic_strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SortCharactersByFrequency {
    public List<Character> frequencySort(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            freqMap.merge(s.charAt(i), 1, Integer::sum);
        }
        Set<Character> charSet = freqMap.keySet();
        List<Character> resCharacters = new ArrayList<>();
        resCharacters.addAll(charSet);
        resCharacters.sort((a, b) -> {
            if (freqMap.get(a) == freqMap.get(b)) {
                return a - b;
            } else {
                return freqMap.get(b) - freqMap.get(a);
            }
        });
        return resCharacters;
    }
}
