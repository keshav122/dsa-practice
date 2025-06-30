package com.dsa_series.roadmap.recursion.Hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhone {
    public List<String> letterCombinations(String digits) {
        Map<Character, String> letterCharMap = new HashMap<>();
        letterCharMap.put('2', "abc");
        letterCharMap.put('3', "def");
        letterCharMap.put('4', "ghi");
        letterCharMap.put('5', "jkl");
        letterCharMap.put('6', "mno");
        letterCharMap.put('7', "pqrs");
        letterCharMap.put('8', "tuv");
        letterCharMap.put('9', "wxyz");
        List<String> result = new ArrayList<>();
        generateLetterCombinations(digits, letterCharMap, result, 0, "");
        return result;
    }

    private void generateLetterCombinations(String digits, Map<Character, String> letterCharMap, List<String> result,
            int index, String currentString) {
        if (index == digits.length()) {
            result.add(currentString);
            return;
        }
        String input = letterCharMap.get(digits.charAt(index));
        for (int i = 0; i < input.length(); i++) {
            generateLetterCombinations(digits, letterCharMap, result, index + 1, currentString + input.charAt(i));
        }
    }
}
