package com.leetcode_practice.problems.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class IsGraphBipartite_785 {
    public boolean isBipartite(int[][] graph) {
        int V = graph.length;
        int[] colored = new int[V];
        Arrays.fill(colored, -1);
        for (int i = 0; i < V; i++) {
            if (colored[i] == -1) {
                if (!check(i, V, colored, graph)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean check(int start, int V, int[] colored, int[][] graph) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        colored[start] = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            int[] neighbors = graph[node];
            for (int i = 0; i < neighbors.length; i++) {
                if (colored[neighbors[i]] == -1) {
                    q.add(neighbors[i]);
                    colored[neighbors[i]] = 1 - colored[node];
                } else if (colored[neighbors[i]] == colored[node]) {
                    return false;
                }
            }
        }
        return true;
    }
}

class DFSSolution {
    public boolean isBipartite(int[][] graph) {
        int V = graph.length;
        int[] colored = new int[V];
        Arrays.fill(colored, -1);
        for (int i = 0; i < V; i++) {
            if (colored[i] == -1) {
                if (!dfs(i, 0, colored, graph)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean dfs(int node, int color, int[] colored, int[][] graph) {
        colored[node] = color;
        int[] neighbors = graph[node];
        for (int i = 0; i < neighbors.length; i++) {
            if (colored[neighbors[i]] == -1) {
                if (!dfs(neighbors[i], 1 - color, colored, graph))
                    return false;
            } else if (colored[neighbors[i]] == color) {
                return false;
            }
        }
        return true;
    }
}