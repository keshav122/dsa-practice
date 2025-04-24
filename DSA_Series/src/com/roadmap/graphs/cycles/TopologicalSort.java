package com.roadmap.graphs.cycles;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class TopologicalSort {
    public int[] topoSort(int V, List<Integer>[] adj) {
        boolean[] vis = new boolean[V];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs(i, vis, adj, st);
            }
        }
        int[] ans = new int[V];
        for (int i = 0; i < V; i++) {
            ans[i] = st.pop();
        }
        return ans;
    }

    private void dfs(int node, boolean[] vis, List<Integer>[] adj, Stack<Integer> st) {
        vis[node] = true;
        for (int adjacent : adj[node]) {
            if (!vis[adjacent]) {
                dfs(adjacent, vis, adj, st);
            }
        }
        st.push(node);
    }
}

// KAHN's Algorithm
class TopologicalSortUsingBFS {
    public int[] topoSort(int V, List<Integer>[] adj) {
        int[] inDegree = new int[V];
        int[] ans = new int[V];
        for (int i = 0; i < V; i++) {
            for (int it : adj[i]) {
                inDegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }
        // Pointer to store elements in resultant array
        int index = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            ans[index++] = node;
            for (int it : adj[node]) {
                inDegree[it]--;
                if (inDegree[it] == 0)
                    q.add(it);
            }
        }
        return ans;
    }
}
