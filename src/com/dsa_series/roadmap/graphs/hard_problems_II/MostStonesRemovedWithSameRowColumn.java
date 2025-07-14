package com.dsa_series.roadmap.graphs.hard_problems_II;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MostStonesRemovedWithSameRowColumn {
    public int maxRemove(int[][] stones, int n) {
        int maxRow = 0;
        int maxCol = 0;
        for (int i = 0; i < n; i++) {
            maxRow = Math.max(maxRow, stones[i][0]);
            maxCol = Math.max(maxCol, stones[i][1]);
        }
        DisjointSet ds = new DisjointSet(maxRow + maxCol + 1);
        Map<Integer, Integer> stoneNodes = new HashMap<>();

        // Iterate on all stones
        for (int[] stone : stones) {
            int nodeRow = stone[0];
            // Converted column number
            int nodeColumn = maxRow + stone[1] + 1;
            ds.unionBySize(nodeRow, nodeColumn);

            // Add the nodes to the map
            stoneNodes.put(nodeRow, 1);
            stoneNodes.put(nodeColumn, 1);
        }

        // Count connected components
        int k = 0;
        for (int key : stoneNodes.keySet()) {
            if (key == ds.findUltParent(key)) {
                k++;
            }
        }
        return n - k;
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
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }
    }

    int findUltParent(int node) {
        if (parent[node] == node) {
            return node;
        }
        return (parent[node] = findUltParent(parent[node]));
    }

    public void unionByRank(int u, int v) {
        int ulp_u = findUltParent(u);
        int ulp_v = findUltParent(v);

        // Return if nodes already belong to the same component
        if (ulp_u == ulp_v)
            return;

        if (rank[ulp_u] < rank[ulp_v]) {
            // Update the parent
            parent[ulp_u] = ulp_v;
        } else if (rank[ulp_v] < rank[ulp_u]) {
            // Update the parent
            parent[ulp_v] = ulp_u;
        }
        /*
         * If both have the same rank , join any node to the other and
         * increment the rank of the parent node
         */
        else {
            // Update the parent
            parent[ulp_v] = ulp_u;
            // Update the rank
            rank[ulp_u]++;
        }
    }

    public void unionBySize(int u, int v) {
        int ulp_u = findUltParent(u);
        int ulp_v = findUltParent(v);

        if (ulp_u == ulp_v)
            return;
        if (size[ulp_u] < size[ulp_v]) {
            parent[ulp_u] = ulp_v;
            size[ulp_v] += size[ulp_u];
        } else {
            parent[ulp_v] = ulp_u;
            size[ulp_u] += size[ulp_v];
        }
    }
}