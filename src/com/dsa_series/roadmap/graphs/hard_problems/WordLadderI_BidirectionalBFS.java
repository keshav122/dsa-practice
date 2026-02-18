package com.dsa_series.roadmap.graphs.hard_problems;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordLadderI_BidirectionalBFS {
    public int wordLadderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord))
            return 0;

        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();

        beginSet.add(beginWord);
        endSet.add(endWord);

        int level = 1;

        while (!beginSet.isEmpty() && !endSet.isEmpty()) {

            // Always expand the smaller frontier
            if (beginSet.size() > endSet.size()) {
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }

            Set<String> nextLevel = new HashSet<>();

            for (String word : beginSet) {

                char[] arr = word.toCharArray();

                for (int i = 0; i < arr.length; i++) {
                    char original = arr[i];

                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        arr[i] = ch;
                        String newWord = new String(arr);

                        if (endSet.contains(newWord)) {
                            return level + 1;
                        }

                        if (dict.contains(newWord)) {
                            nextLevel.add(newWord);
                            dict.remove(newWord); // mark visited
                        }
                    }

                    arr[i] = original;
                }
            }

            beginSet = nextLevel;
            level++;
        }

        return 0;
    }
}
