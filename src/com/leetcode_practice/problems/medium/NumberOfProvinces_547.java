package com.leetcode_practice.problems.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NumberOfProvinces_547 {
    public int findCircleNum(int[][] isConnected) {
        int V = isConnected.length;
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    adjList.get(i + 1).add(j + 1);
                    adjList.get(j + 1).add(i + 1);
                }
            }
        }

        int provinces = 0;
        boolean[] vis = new boolean[V + 1];
        for (int i = 1; i <= V; i++) {
            if (!vis[i]) {
                provinces++;
                bfs(i, vis, adjList);
            }
        }
        return provinces;
    }

    private void bfs(int node, boolean[] vis, List<List<Integer>> adjList) {
        vis[node] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        while (!q.isEmpty()) {
            int p = q.poll();
            for (int neighbor : adjList.get(p)) {
                if (!vis[neighbor]) {
                    vis[neighbor] = true;
                    q.add(neighbor);
                }
            }
        }
    }

     public int findCircleNum_WithoutAdjList(int[][] isConnected) {
        int V = isConnected.length;
        int provinces = 0;
        boolean[] vis = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                provinces++;
                dfs(i, vis, isConnected);
            }
        }
        return provinces;
    }

    private void dfs(int i, boolean[] vis, int[][] g){
       vis[i] = true;
       for(int j = 0; j< g.length; j++){
        if(g[i][j] == 1 && !vis[j]){
           dfs(j, vis,g);
        }
       }
  }
}
