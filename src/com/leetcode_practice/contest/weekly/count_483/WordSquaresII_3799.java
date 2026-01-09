package com.leetcode_practice.contest.weekly.count_483;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordSquaresII_3799 {

    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> result = new ArrayList<>();
        if (words == null || words.length == 0) {
            return result;
        }

        // Creating maps for quick lookup
        Map<Character, List<String>> startMap = new HashMap<>();
        Map<String, List<String>> startEndMap = new HashMap<>();

        for (String word : words) {
            char start = word.charAt(0);
            char end = word.charAt(3);
            startMap.computeIfAbsent(start, k -> new ArrayList<>()).add(word);
            startEndMap.computeIfAbsent("" + start + end, k -> new ArrayList<>()).add(word);
        }

        // Backtracking function to build squares
        for (String top : words) {
            backtrack(result, top, startMap, startEndMap);
        }

        // Sorting result lexicographically
        result.sort((a, b) -> {
            for (int i = 0; i < 4; i++) {
                int cmp = a.get(i).compareTo(b.get(i));
                if (cmp != 0) {
                    return cmp;
                }
            }
            return 0;
        });
        return result;
    }

    private void backtrack(List<List<String>> result, String top, Map<Character, List<String>> startMap,
            Map<String, List<String>> startEndMap) {
        List<String> square = new ArrayList<>();
        square.add(top);
        // Now choose left , right , bottom based on constraints
        char top0 = top.charAt(0);
        char top3 = top.charAt(3);

        // Choose left word
        for (String left : startMap.getOrDefault(top0, Collections.emptyList())) {
            if (left.equals(top))
                continue;

            char left3 = left.charAt(3);
            // Choose right word
            for (String right : startMap.getOrDefault(top3, Collections.emptyList())) {
                if (right.equals(top) || right.equals(left))
                    continue;
                char right3 = right.charAt(3);

                // Choose bottom word
                String bottomKey = "" + left3 + right3;
                for (String bottom : startEndMap.getOrDefault(bottomKey, Collections.emptyList())) {
                    if (bottom.equals(top) || bottom.equals(left) || bottom.equals(right))
                        continue;
                    List<String> validSquare = new ArrayList<>(Arrays.asList(top, left, right, bottom));
                    result.add(validSquare);
                }
            }
        }

    }
}
