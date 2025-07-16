package com.dsa_series.roadmap.graphs.hard_problems_II;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MakingALargeIsland {

    int[] dr = { -1, 0, 1, 0 }; // delta rows
    int[] dc = { 0, -1, 0, 1 }; // delta cols

    public boolean isValid(int i, int j, int n) {
        return (i >= 0 && i < n && j >= 0 && j < n);
    }

    public int largestIsland(int[][] grid) {
        int n = grid.length;
        DisjointSet ds = new DisjointSet(n * n);
        // Step 1 - Connect the components
        addInitialIslands(grid, ds, n);
        // Step 2 - Check size by converting 0 to 1
        int maxSize = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 1)
                    continue;

                Set<Integer> components = new HashSet<>();
                for (int ind = 0; ind < 4; ind++) {
                    int newRow = row + dr[ind];
                    int newCol = col + dc[ind];
                    if (isValid(newRow, newCol, n) && grid[newRow][newCol] == 1) {
                        int nodeNo = newRow * n + newCol;
                        components.add(ds.findUltParent(nodeNo));
                    }
                }

                // To store the size of current largest island
                int sizeTotal = 0;
                for (int parent : components) {
                    sizeTotal += ds.size[ds.findUltParent(parent)];
                }
                maxSize = Math.max(maxSize, sizeTotal + 1);
            }
        }

        // Edge case where there are all 1s
        for (int cellNo = 0; cellNo < n * n; cellNo++) {
            maxSize = Math.max(maxSize, ds.size[ds.findUltParent(cellNo)]);
        }
        return maxSize;
    }

    void addInitialIslands(int[][] grid, DisjointSet ds, int n) {
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 0)
                    continue;
                for (int ind = 0; ind < 4; ind++) {
                    int newRow = row + dr[ind];
                    int newCol = col + dc[ind];
                    if (isValid(newRow, newCol, n) && grid[newRow][newCol] == 1) {
                        int node = row * n + col;
                        int adjNode = newRow * n + newCol;
                        ds.unionBySize(node, adjNode);
                    }
                }
            }
        }
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