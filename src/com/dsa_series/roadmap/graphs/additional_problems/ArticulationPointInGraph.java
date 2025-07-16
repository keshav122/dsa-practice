package com.dsa_series.roadmap.graphs.additional_problems;

import java.util.ArrayList;
import java.util.Arrays;

public class ArticulationPointInGraph {
    private int timer = 1;

    private void dfs(int node, int parent, boolean[] vis, int[] tin, int[] low, boolean[] mark,
            ArrayList<ArrayList<Integer>> adj) {
        // Mark the nodes as visited
        vis[node] = true;
        // Time of insertion and the lowest time of
        // insert for node will be the current time
        tin[node] = low[node] = timer;
        timer++;

        // To count the number of children of the node
        int child = 0;
        for (int it : adj.get(node)) {
            // Skip the parent
            if (it == parent)
                continue;

            if (!vis[it]) {
                // Recursive DFS call
                dfs(it, node, vis, tin, low, mark, adj);

                // Post recursive DFS call , update the lowest time of insertion for the node
                low[node] = Math.min(low[it], low[node]);

                // If the lowest time of insertion of the node is found to be greater than
                // the time of insertion of the neighbor
                if (low[it] >= tin[node] && parent != -1) {
                    mark[node] = true;
                }
                child++;
            }
            // If neighbor is already visited
            else {
                // Different than bridges in graph
                // Comparing with tin[it] rather than low[it]
                // Because we do not want a route passing through that node
                low[node] = Math.min(low[node], tin[it]);
            }
        }

        // If the node is a starting node
        // and has more than one child
        if (child > 1 && parent == -1) {
            mark[node] = true;
        }

    }

    public ArrayList<Integer> articulationPoints(int n,
            ArrayList<ArrayList<Integer>> adj) {
        // Visited array
        boolean[] vis = new boolean[n];

        // To store the time of insertion (discovery time) of nodes
        int[] tin = new int[n];

        // To store the lowest time of insertion of nodes
        int[] low = new int[n];

        // To mark if a node is an articulation point
        boolean[] mark = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                dfs(i, -1, vis, tin, low, mark, adj);
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (mark[i]) {
                ans.add(i);
            }
        }
        if (ans.size() == 0) {
            return new ArrayList<>(Arrays.asList(-1));
        }
        return ans;
    }
}
