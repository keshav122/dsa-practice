package com.dsa_series.roadmap.graphs.cycles;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DetectACycleInADirectedGraph {
    public boolean isCyclic(int N, List<Integer>[] adj) {
        boolean[] vis = new boolean[N];
        boolean[] pathVis = new boolean[N];
        for (int i = 0; i < N; i++) {
            if (!vis[i]) {
                if (dfs(i, vis, pathVis, adj)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(int node, boolean[] vis, boolean[] pathVis, List<Integer>[] adj) {
        vis[node] = true;
        pathVis[node] = true;
        for (int adjacent : adj[node]) {
            if (pathVis[adjacent])
                return true;
            else if (!vis[adjacent]) {
                if (dfs(adjacent, vis, pathVis, adj))
                    return true;
            }
        }
        pathVis[node] = false;
        return false;
    }
}

// The concept is that topological sort is only valid for DAGs(Directed Acyclic
// Graph)
// So if we try to generate the topological sort list and if its size is less
// than the numbers of elements
// than it is a cyclic graph
class DetectACycleInADirectedGraphUsingBFS {
    public boolean isCyclic(int N, List<Integer>[] adj) {
        int[] inDegree = new int[N];
        for (int i = 0; i < N; i++) {
            for (int it : adj[i]) {
                inDegree[it]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < N; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            int node = q.poll();
            count++;
            for (int adjacent : adj[node]) {
                inDegree[adjacent]--;
                if (inDegree[adjacent] == 0) {
                    q.add(adjacent);
                }
            }
        }
        if (count < N) {
            return true;
        }
        return false;
    }

}