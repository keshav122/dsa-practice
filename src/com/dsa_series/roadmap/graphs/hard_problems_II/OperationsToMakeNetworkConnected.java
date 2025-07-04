package com.dsa_series.roadmap.graphs.hard_problems_II;

import java.util.Arrays;

public class OperationsToMakeNetworkConnected {

    public int solve(int n, int[][] Edge) {
        int size = Edge.length;

        // Return -1 if connecting all edges is not possible
        // To connect n vertices you would require at least n-1 edges
        if (size < n - 1)
            return -1;

        DisjointSet ds = new DisjointSet(n);
        for (int i = 0; i < size; i++) {
            ds.unionByRank(Edge[i][0], Edge[i][1]);
        }

        // To store count of required edges
        int count = 0;

        // Finding the number of components
        for (int i = 0; i < n; i++) {
            if (ds.parent[i] == i)
                count++;
        }

        return count - 1;
    }

}

class DisjointSet {
    // To store the parents of each node
    int[] parent;

    // To store the number of connected components to each node
    int[] size;

    // To store the rank of each node
    int[] rank;

    public DisjointSet(int n) {
        rank = new int[n + 1];
        parent = new int[n + 1];
        size = new int[n + 1];

        Arrays.fill(size, 1);
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }
    }

    public int findUltimateParent(int node) {
        if (node == parent[node]) {
            return node;
        }
        return parent[node] = findUltimateParent(parent[node]);
    }

    // Function To determine if two nodes are in the same component or not
    public boolean find(int u, int v) {
        return findUltimateParent(u) == findUltimateParent(v);
    }

    public void unionByRank(int u, int v) {
        int ultimateParent_u = findUltimateParent(u);
        int ultimateParent_v = findUltimateParent(v);

        if (ultimateParent_u == ultimateParent_v)
            return;

        if (rank[ultimateParent_u] < rank[ultimateParent_v]) {
            parent[ultimateParent_u] = ultimateParent_v;
        } else if (rank[ultimateParent_v] < rank[ultimateParent_u]) {
            parent[ultimateParent_v] = ultimateParent_u;
        }
        // both have the same rank
        // join any node to the other and
        // increment the rank of the parent node
        else {
            parent[ultimateParent_v] = ultimateParent_u;
            rank[ultimateParent_u]++;
        }
    }

    public void unionBySize(int u, int v) {
        int ultimateParent_u = findUltimateParent(u);
        int ultimateParent_v = findUltimateParent(v);

        if (ultimateParent_u == ultimateParent_v)
            return;

        if (size[ultimateParent_u] < size[ultimateParent_v]) {
            parent[ultimateParent_u] = ultimateParent_v;
            size[ultimateParent_v] += size[ultimateParent_u];
        } else {
            parent[ultimateParent_v] = ultimateParent_u;
            size[ultimateParent_u] += size[ultimateParent_v];
        }
    }
}
