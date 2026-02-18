
package com.dsa_series.roadmap.graphs.hard_problems;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class WordLadderII_GPTSolution {

    public List<List<String>> findSequences(String beginWord, String endWord, List<String> wordList) {

        List<List<String>> result = new ArrayList<>();
        Set<String> dict = new HashSet<>(wordList);

        if (!dict.contains(endWord))
            return result;

        // Phase 1: Build shortest-path DAG using BFS
        Map<String, List<String>> adj = new HashMap<>();
        Map<String, Integer> dist = new HashMap<>();

        bfs(beginWord, endWord, dict, adj, dist);

        if (!dist.containsKey(endWord))
            return result;

        // Phase 2: DFS to build all shortest paths
        List<String> path = new ArrayList<>();
        path.add(beginWord);

        dfs(beginWord, endWord, adj, dist, path, result);

        return result;
    }

    private void bfs(String beginWord,
            String endWord,
            Set<String> dict,
            Map<String, List<String>> adj,
            Map<String, Integer> dist) {

        Queue<String> q = new ArrayDeque<>();
        q.add(beginWord);
        dist.put(beginWord, 0);

        while (!q.isEmpty()) {

            int size = q.size();
            boolean foundEnd = false;

            for (int s = 0; s < size; s++) {

                String word = q.poll();
                int currentDist = dist.get(word);

                char[] arr = word.toCharArray();

                for (int i = 0; i < arr.length; i++) {

                    char original = arr[i];

                    for (char ch = 'a'; ch <= 'z'; ch++) {

                        if (ch == original)
                            continue;

                        arr[i] = ch;
                        String next = new String(arr);

                        if (!dict.contains(next))
                            continue;

                        // If first time discovered
                        if (!dist.containsKey(next)) {
                            dist.put(next, currentDist + 1);
                            q.add(next);
                        }

                        // If it's part of shortest path
                        if (dist.get(next) == currentDist + 1) {
                            adj.computeIfAbsent(word, k -> new ArrayList<>()).add(next);
                        }

                        if (next.equals(endWord)) {
                            foundEnd = true;
                        }
                    }

                    arr[i] = original;
                }
            }

            // Stop BFS once shortest level containing endWord is processed
            if (foundEnd)
                break;
        }
    }

    private void dfs(String word,
            String endWord,
            Map<String, List<String>> adj,
            Map<String, Integer> dist,
            List<String> path,
            List<List<String>> result) {

        if (word.equals(endWord)) {
            result.add(new ArrayList<>(path));
            return;
        }

        if (!adj.containsKey(word))
            return;

        for (String next : adj.get(word)) {
            path.add(next);
            dfs(next, endWord, adj, dist, path, result);
            path.remove(path.size() - 1);
        }
    }
}
