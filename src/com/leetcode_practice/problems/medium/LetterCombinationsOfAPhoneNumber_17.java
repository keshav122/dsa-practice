/*Author: keshav122 */
package com.leetcode_practice.problems.medium;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber_17 {
    public List<String> letterCombinations(String digits) {
        String[] combs = new String[] { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        List<String> letters = new ArrayList<>();
        if (digits.length() == 0)
            return letters;
        letterCombinations(0, "", digits, letters, combs);
        return letters;
    }

    private void letterCombinations(int index, String currString, String digits, List<String> letters, String[] combs) {
        if (index == digits.length()) {
            letters.add(currString);
            return;
        }
        String keypad = combs[digits.charAt(index) - '0'];
        for (int i = 0; i < keypad.length(); i++) {
            letterCombinations(index + 1, currString + keypad.charAt(i), digits, letters, combs);
        }
    }
}
