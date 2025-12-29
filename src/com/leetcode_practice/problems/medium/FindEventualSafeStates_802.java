package com.leetcode_practice.problems.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

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

    public int[] eventualSafeNodes_better(int V, int[][] adj) {
        List<List<Integer>> revAdj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            revAdj.add(new ArrayList<>());
        }

        int[] indegree = new int[V];
        for (int i = 0; i < V; i++) {
            for (int it : adj[i]) {
                // original i -> it
                // rev : it -> i
                revAdj.get(it).add(i);
                indegree[i]++;
            }
        }

        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0)
                q.add(i);
        }
        List<Integer> safeNodes = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.poll();
            safeNodes.add(node);
            for (Integer neighbor : revAdj.get(node)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    q.add(neighbor);
                }
            }
        }
        Collections.sort(safeNodes);
        int[] ans = new int[safeNodes.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = safeNodes.get(i);
        }
        return ans;
    }

}
