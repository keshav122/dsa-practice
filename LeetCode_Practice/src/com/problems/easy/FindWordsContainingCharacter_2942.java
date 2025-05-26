package com.problems.easy;

import java.util.ArrayList;
import java.util.List;

public class FindWordsContainingCharacter_2942 {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = 0; j < word.length(); j++) {
                if (word.charAt(j) == x) {
                    ans.add(i);
                    break;
                }
            }
        }
        return ans;
    }
}
