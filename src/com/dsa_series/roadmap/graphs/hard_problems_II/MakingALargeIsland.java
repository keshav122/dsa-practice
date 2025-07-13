package com.dsa_series.roadmap.graphs.hard_problems_II;

import java.util.Arrays;

public class MakingALargeIsland {
    public int largestIsland(int[][] grid) {
        int n = grid.length;

    }
}

class DisjointSet {
    int[] size;
    int[] parent;
    int[] rank;

    public DisjointSet(int n) {
        size = new int[n + 1];
        rank = new int[n + 1];
        parent = new int[n + 1];
        Arrays.fill(size, 1);
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    int findUltParent(int node) {
        if (parent[node] == node) {
            return parent[node];
        }
        return (parent[node] = findUltParent(parent[node]));
    }

    void unionBySize(int u, int v) {
        int ult_u = findUltParent(u);
        int ult_v = findUltParent(v);
        if (ult_u == ult_v)
            return;
        if (ult_u < ult_v) {
            parent[ult_u] = ult_v;
            size[ult_v] += size[ult_u];
        } else {
            parent[ult_v] = ult_u;
            size[ult_u] += size[ult_v];
        }
    }

    void unionByRank(int u, int v) {
        int ult_u = findUltParent(u);
        int ult_v = findUltParent(v);
        if (ult_u == ult_v)
            return;
        if (ult_u < ult_v) {
            parent[ult_u] = ult_v;
            rank[ult_v]++;
        } else {
            parent[ult_v] = ult_u;
            rank[ult_u]++;
        }
    }
}