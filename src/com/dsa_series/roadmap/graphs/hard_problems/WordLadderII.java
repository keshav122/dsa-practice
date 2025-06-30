package com.dsa_series.roadmap.graphs.hard_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadderII {
    public List<List<String>> findSequences(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        Queue<List<String>> q = new LinkedList<>();
        ArrayList<String> list = new ArrayList<>();
        list.add(beginWord);
        q.add(list);
        List<String> usedOnLevel = new ArrayList<>();
        usedOnLevel.add(beginWord);
        int level = 0;
        List<List<String>> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            List<String> li = q.poll();
            if (li.size() > level) {
                level++;
                // erasing all the words that has been used on previous levels to transform
                for (String s : usedOnLevel) {
                    wordSet.remove(s);
                }
            }
            String word = li.get(li.size() - 1);
            if (word.equals(endWord)) {
                if (ans.size() == 0)
                    ans.add(li);
                else if (ans.get(0).size() == li.size())
                    ans.add(li);
            }
            for (int i = 0; i < word.length(); i++) {
                char[] replacedCharArr = word.toCharArray();
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    replacedCharArr[i] = ch;
                    String replacedString = new String(replacedCharArr);
                    if (wordSet.contains(replacedString)) {
                        li.add(replacedString);
                        List<String> temp = new ArrayList<>(li);
                        q.add(temp);
                        usedOnLevel.add(replacedString);
                        li.remove(li.size() - 1);
                    }
                }
            }
        }
        return ans;
    }

    public List<List<String>> findSequences_Official(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ans = new ArrayList<>();
        Queue<List<String>> q = new LinkedList<>();
        Set<String> wordSet = new HashSet<>(wordList);
        q.add(new ArrayList<>(Arrays.asList(beginWord)));
        // Erase starting word from set if it exists
        wordSet.remove(beginWord);

        // Set to store the words that must be deleted
        // after traversal of a level is complete
        Set<String> toErase = new HashSet<>();

        while (!q.isEmpty()) {
            int size = q.size();
            // Traversing all words in current level
            for (int i = 0; i < size; i++) {
                List<String> seq = q.poll();
                // Last added word in sequence
                String word = seq.get(seq.size() - 1);
                // If the last word same as end word
                if (word.equals(endWord)) {
                    if (ans.size() == 0) {
                        ans.add(new ArrayList<>(seq));
                    } else if (ans.get(0).size() == seq.size()) {
                        ans.add(new ArrayList<>(seq));
                    }
                }

                for (int pos = 0; pos < word.length(); pos++) {
                    char original = word.charAt(pos);
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        char[] wordArray = word.toCharArray();
                        wordArray[pos] = ch;
                        String newWord = new String(wordArray);
                        if (wordSet.contains(newWord)) {
                            seq.add(newWord);
                            q.add(new ArrayList<>(seq));
                            toErase.add(newWord);
                            seq.remove(seq.size() - 1);
                        }
                    }
                    String beforePos = word.substring(0, pos);
                    String afterPos = word.substring(pos + 1);
                    word = beforePos + original + afterPos;
                }
            }
            // Erase all the words in set after
            // traversal of a level is completed
            for (String it : toErase)
                wordSet.remove(it);
            toErase.clear();

            if (!ans.isEmpty())
                break;
        }
        return ans;
    }
}
