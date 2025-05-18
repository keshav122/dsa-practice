/*Author: keshav122 */
package com.roadmap.graphs.traversal_problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NumberOfProvinces {
    @SuppressWarnings("unchecked")
    public int numProvinces(int[][] adj) {
        int V = adj.length;
        List<Integer>[] adjLists = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adjLists[i] = new ArrayList<>();
        }
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (i != j && adj[i][j] == 1) {
                    adjLists[i].add(j);
                    adjLists[j].add(i);
                }
            }
        }

        boolean[] vis = new boolean[V];
        int cnt = 0;
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                cnt++;
                bfs(i, adjLists, vis);

            }
        }
        return cnt;
    }

    private void bfs(int node, List<Integer>[] adjLists, boolean[] vis) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);

        while (!q.isEmpty()) {
            int current = q.poll();
            for (Integer it : adjLists[current]) {
                if (!vis[it]) {
                    vis[it] = true;
                    q.add(it);
                }
            }
        }
    }
}
