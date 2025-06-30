package com.roadmap.graphs.theory_and_traversals;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TraversalTechniques {
    public List<Integer> dfsOfGraph(int V, List<Integer> adj[]) {
        List<Integer> ans = new ArrayList<>();
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, ans, visited, adj);
            }
        }
        return ans;
    }

    public void dfs(int i, List<Integer> dfs, boolean[] visited, List<Integer> adj[]) {
        visited[i] = true;
        dfs.add(i);
        for (Integer it : adj[i]) {
            if (!visited[it]) {
                dfs(it, dfs, visited, adj);
            }
        }

    }

    public List<Integer> bfsOfGraph(int V, List<Integer> adj[]) {
        List<Integer> ans = new ArrayList<>();
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                visited[i] = true;
                bfs(i, ans, visited, adj);
            }
        }

        return ans;
    }

    public void bfs(int i, List<Integer> bfs, boolean[] visited, List<Integer> adj[]) {
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        while (!q.isEmpty()) {
            Integer node = q.poll();
            bfs.add(node);
            for (Integer it : adj[node]) {
                if (!visited[it]) {
                    visited[it] = true;
                    q.add(it);
                }
            }
        }

    }
}
