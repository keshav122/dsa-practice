package com.roadmap.graphs.theory_and_traversals;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ConnectedComponents {
    public int findNumberOfComponent(int E, int V, List<List<Integer>> edges) {
        // To store adjacency list
        List<Integer>[] adjLists = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adjLists[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            adjLists[edges.get(i).get(0)].add(edges.get(i).get(1));
            adjLists[edges.get(i).get(1)].add(edges.get(i).get(0));
        }

        boolean[] visited = new boolean[V];
        int count = 0;
        for (int i = 0; i < V; i++) {
            // If the node is not visited
            if (!visited[i]) {
                count++;
                bfs(i, adjLists, visited);
                // dfs(i, adjLists,visited)
            }
        }
        return count;
    }

    // BFS traversal
    private void bfs(int node, List<Integer>[] adjLists, boolean[] visited) {
        visited[node] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        while (!q.isEmpty()) {
            int i = q.poll();
            // Traverse its unvisited neighbours
            for (int adjNodes : adjLists[i]) {
                if (!visited[adjNodes]) {
                    visited[adjNodes] = true;
                    q.add(adjNodes);
                }
            }
        }
    }

    // DFS Traversal
    private void dfs(int node, List<Integer>[] adjLists, boolean[] visited) {
        visited[node] = true;
        for (int it : adjLists[node]) {
            if (!visited[it]) {
                dfs(it, adjLists, visited);
            }
        }
    }
}
