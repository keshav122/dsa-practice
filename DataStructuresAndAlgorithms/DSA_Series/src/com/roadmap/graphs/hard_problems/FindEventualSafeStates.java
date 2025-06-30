package com.roadmap.graphs.hard_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindEventualSafeStates {
    public int[] eventualSafeNodes(int V, int[][] adj) {
        boolean[] vis = new boolean[V];
        boolean[] pathVis = new boolean[V];
        boolean[] check = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfsCheck(i, adj, vis, pathVis, check);
            }
        }

        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (check[i])
                temp.add(i);
        }
        int[] safeNodes = new int[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            safeNodes[i] = temp.get(i);
        }
        return safeNodes;
    }

    private boolean dfsCheck(
            int node, int[][] adj, boolean[] vis, boolean[] pathVis, boolean[] check) {
        // Mark the node as visited
        vis[node] = true;
        // Add the node to current path
        pathVis[node] = true;
        // Mark the node as potentially unsafe
        check[node] = false;
        for (int adjacent : adj[node]) {
            if (!vis[adjacent]) {
                if (dfsCheck(adjacent, adj, vis, pathVis, check)) {
                    /* Return true since a cycle was detected */
                    return true;
                }
            } else if (pathVis[adjacent]) {
                /* Return true since a cycle was detected */
                return true;
            }
        }
        check[node] = true;
        pathVis[node] = false;
        return false;
    }
}

class FindEventualSafeStatesUsingBFS {
    @SuppressWarnings("unchecked")
    public int[] eventualSafeNodes(int V, int[][] adj) {
        ArrayList<Integer>[] reverseAdj = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            reverseAdj[i] = new ArrayList<>();
        }

        for (int i = 0; i < V; i++) {
            for (int it : adj[i]) {
                reverseAdj[it].add(i);
            }
        }
        int[] result = topologicalSort(V, reverseAdj);
        Arrays.sort(result);
        return result;
    }

    private int[] topologicalSort(int V, List<Integer>[] reverseAdj) {
        int[] indegree = new int[V];
        for (int i = 0; i < V; i++) {
            for (int it : reverseAdj[i]) {
                indegree[it]++;
            }
        }
        int[] ans = new int[V];
        int idx = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0)
                q.add(i);
        }

        while (!q.isEmpty()) {
            int node = q.poll();
            ans[idx++] = node;
            for (int adjacent : reverseAdj[node]) {
                indegree[adjacent]--;
                if (indegree[adjacent] == 0)
                    q.add(adjacent);
            }
        }

        return Arrays.copyOfRange(ans, 0, idx);
    }
}
