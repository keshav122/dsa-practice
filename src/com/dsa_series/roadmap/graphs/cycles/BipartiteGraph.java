package com.dsa_series.roadmap.graphs.cycles;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BipartiteGraph {
    public boolean isBipartite(int V, List<Integer>[] adj) {
        int[] color = new int[V];
        Arrays.fill(color, -1);
        for (int i = 0; i < V; i++) {
            if (color[i] == -1) {
                if (!bfs(i, V, color, adj)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean bfs(int start, int V, int[] color, List<Integer>[] adj) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        color[start] = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            for (int adjacent : adj[node]) {
                if (color[adjacent] == -1) {
                    color[adjacent] = 1 - color[node];
                    q.offer(adjacent);
                } else if (color[node] == color[adjacent]) {
                    return false;
                }
            }
        }
        return true;
    }
}

class BipartiteGraphUsingDFS {
    public boolean isBipartite(int V, List<Integer>[] adj) {
        int[] color = new int[V];
        Arrays.fill(color, -1);
        for (int i = 0; i < V; i++) {
            if (color[i] == -1) {
                if (!dfs(i, color, adj, 0)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean dfs(int start, int[] color, List<Integer>[] adj, int currentColor) {
        color[start] = currentColor;
        for (int adjacent : adj[start]) {
            if (color[adjacent] == -1) {
                if (!dfs(adjacent, color, adj, 1 - currentColor))
                    return false;
            } else if (currentColor == color[adjacent])
                return false;
        }
        return true;
    }
}