package com.dsa_series.roadmap.graphs.additional_problems;

import java.util.ArrayList;
import java.util.Stack;

public class KosarajuAlgorithm {

    private void dfs(int node, int[] vis, ArrayList<ArrayList<Integer>> adj, Stack<Integer> st) {
        vis[node] = 1;
        for (int it : adj.get(node)) {
            if (vis[it] == 0) {
                dfs(it, vis, adj, st);
            }
        }
        st.push(node);
    }

    // Helper function to perform DFS for finding number of SCCs
    private void helperDFS(int node, int[] vis, ArrayList<ArrayList<Integer>> adjT) {
        vis[node] = 1;
        for (int it : adjT.get(node)) {
            if (vis[it] == 0) {
                helperDFS(it, vis, adjT);
            }
        }
    }

    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] vis = new int[V];
        Stack<Integer> st = new Stack<>();

        // initial DFS to store the nodes in stack based on their finishing time
        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                dfs(i, vis, adj, st);
            }
        }

        // To store the reversed graph
        ArrayList<ArrayList<Integer>> adjT = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjT.add(new ArrayList<>());
        }

        // Reverse all the edges of original graph to reversed graph
        for (int i = 0; i < V; i++) {
            // Mark the node as unvisited
            vis[i] = 0;
            for (int it : adj.get(i)) {
                adjT.get(it).add(i);
            }
        }

        // To store the count of SCCs
        int count = 0;
        while (!st.isEmpty()) {
            int node = st.pop();

            if (vis[node] == 0) {
                count++;
                helperDFS(node, vis, adjT);
            }
        }
        return count;

    }
}
