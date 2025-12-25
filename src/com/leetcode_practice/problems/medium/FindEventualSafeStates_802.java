package com.leetcode_practice.problems.medium;

import java.util.ArrayList;
import java.util.List;

public class FindEventualSafeStates_802 {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;
        boolean[] vis = new boolean[V];
        boolean[] pathVis = new boolean[V];
        boolean[] check = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfsCheck(i, vis, pathVis, check, graph);
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (check[i]) {
                ans.add(i);
            }
        }
        return ans;
    }

    private boolean dfsCheck(int node, boolean[] vis, boolean[] pathVis, boolean[] check, int[][] adj) {
        vis[node] = true;
        pathVis[node] = true;
        check[node] = false;
        for (int neighbor : adj[node]) {
            if (!vis[neighbor]) {
                if (dfsCheck(neighbor, vis, pathVis, check, adj)) {
                    return true;
                }
            } else if (pathVis[neighbor]) {
                return true;
            }
        }
        pathVis[node] = false;
        check[node] = true;
        return false;
    }
}
