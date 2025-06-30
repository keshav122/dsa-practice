package com.dsa_series.roadmap.graphs.minimum_spanning_tree;

import java.util.Arrays;

public class DisjointSet {
    // To store the rank of each node
    private int[] rank;

    /* To store the size of components that each node belongs to */
    private int[] size;

    // To store the ultimate parent of each node
    private int[] parent;

    public DisjointSet(int n) {

        rank = new int[n + 1];
        parent = new int[n + 1];
        size = new int[n + 1];
        Arrays.fill(size, 1);

        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }
    }

    // Helper function to find ultimate parent along with path compression
    public int findUPar(int node) {
        // Base case
        if (node == parent[node]) {
            return node;
        }

        return parent[node] = findUPar(parent[node]);
    }

    /* Function to determine if two nodes are in the same component or not */
    public boolean find(int u, int v) {
        return (findUPar(u) == findUPar(v));
    }

    /* Function to perform union of two nodes based on rank */
    public void unionByRank(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);

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
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);

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
