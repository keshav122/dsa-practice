package com.leetcode_practice.problems.easy;

public class CheckIfAWordOccursAsAnPrefixofAnySentence_1455 {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (words[i].startsWith(searchWord)) {
                return i + 1;
            }
        }
        return -1;
    }

    public int isPrefixOfWord_betterSpace(String sentence, String searchWord) {
        int i = 0, n = sentence.length();
        int wordIdx = 1;

        while (i < n) {
            int j = i;
            int k = 0;
            // prefix match
            while (j < n && sentence.charAt(j) != ' ' && k < searchWord.length()
                    && sentence.charAt(j) == searchWord.charAt(k)) {
                j++;
                k++;
            }

            if (k == searchWord.length())
                return wordIdx;

            // move to next word
            while (i < n && sentence.charAt(i) != ' ')
                i++;
            i++;// skip space
            wordIdx++;
        }
        return -1;
    }

}
