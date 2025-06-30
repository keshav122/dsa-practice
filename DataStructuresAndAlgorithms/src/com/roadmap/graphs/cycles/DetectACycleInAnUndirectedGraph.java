package com.roadmap.graphs.cycles;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DetectACycleInAnUndirectedGraph {
    public boolean detectCycleBFS(int sourceNode, List<Integer>[] adj, boolean[] vis) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { sourceNode, -1 });
        vis[sourceNode] = true;
        while (!q.isEmpty()) {
            int node = q.peek()[0];
            int parent = q.peek()[1];
            q.poll();
            for (Integer adjacentNode : adj[node]) {
                if (!vis[adjacentNode]) {
                    vis[adjacentNode] = true;
                    q.add(new int[] { adjacentNode, node });
                } else if (adjacentNode != parent) {
                    // Either the adjacent node will not be visited or it will be visited
                    // because it was the parent of this node i.e. from where this node came
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isCycle(int V, List<Integer>[] adj) {
        boolean[] vis = new boolean[V];
        boolean ans = false;
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                ans = detectCycleBFS(i, adj, vis);
                if (ans)
                    break;
            }
        }
        return ans;
    }
}

class DetectACycleInAnUndirectedGraphDFS {
    public boolean isCycle(int V, List<Integer>[] adj) {
        boolean[] vis = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                if (dfs(i, -1, vis, adj))
                    return true;
            }
        }
        return false;
    }

    private boolean dfs(int node, int parentNode, boolean[] vis, List<Integer>[] adj) {
        vis[node] = true;
        for (Integer adjacentNode : adj[node]) {
            if (!vis[adjacentNode]) {
                if (dfs(adjacentNode, node, vis, adj))
                    return true;
            } else if (adjacentNode != parentNode) {
                return true;
            }
        }
        return false;
    }
}
