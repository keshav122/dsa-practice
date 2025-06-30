package com.dsa_series.roadmap.graphs.hard_problems;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WordLadderI {
    public int wordLadderLength(String startWord, String targetWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(startWord, 1));
        wordSet.remove(startWord);
        while (!q.isEmpty()) {
            Pair p = q.poll();
            String word = p.word;
            int steps = p.steps;
            if (word.equals(targetWord))
                return steps;

            for (int i = 0; i < word.length(); i++) {
                char[] replacedCharArr = word.toCharArray();
                for (char c = 'a'; c <= 'z'; c++) {
                    replacedCharArr[i] = c;
                    String replacedString = new String(replacedCharArr);
                    if (wordSet.contains(replacedString)) {
                        wordSet.remove(replacedString);
                        q.add(new Pair(replacedString, steps + 1));
                    }
                }
            }
        }
        return 0;
    }
}

class Pair {
    String word;
    int steps;

    Pair(String word, int steps) {
        this.word = word;
        this.steps = steps;
    }
}
