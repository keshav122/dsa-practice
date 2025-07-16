package com.dsa_series.roadmap.graphs.additional_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BridgesInGraph {

    private int timer = 1;

    private void dfs(int node, int parent, int[] vis, List<Integer>[] adj, int[] tin, int[] low,
            List<List<Integer>> bridges) {
        // Mark the nodes as visited
        vis[node] = 1;
        // Time of insertion and the lowest time of
        // insert for node will be the current time
        tin[node] = low[node] = timer;
        timer++;
        for (int it : adj[node]) {
            // Skip the parent
            if (it == parent)
                continue;

            if (vis[it] == 0) {
                // Recursive DFS call
                dfs(it, node, vis, adj, tin, low, bridges);

                // Post recursive DFS call , update the lowest time of insertion for the node
                low[node] = Math.min(low[it], low[node]);

                // If the lowest time of insertion of the node is found to be greater than
                // the time of insertion of the neighbor
                if (low[it] > tin[node]) {
                    bridges.add(Arrays.asList(it, node));
                }
            }
            // If neighbor is already visited
            else {
                low[node] = Math.min(low[it], low[node]);
            }
        }

    }

    public List<List<Integer>> criticalConnections(int V, List<List<Integer>> E) {
        // Adjacency List
        List<Integer>[] adj = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }

        // Add all the edges to the adjacency list
        for (List<Integer> it : E) {
            int u = it.get(0), v = it.get(1);
            adj[u].add(v);
            adj[v].add(u);
        }

        // Visited array
        int[] vis = new int[V];

        // To store the time of insertion (discovery time) of nodes
        int[] tin = new int[V];

        // To store the lowest time of insertion of nodes
        int[] low = new int[V];

        // To store the bridges of the graph
        List<List<Integer>> bridges = new ArrayList<>();

        // Start a DFS traversal from node 0 with its parent as -1
        dfs(0, -1, vis, adj, tin, low, bridges);
        return bridges;

    }
}
