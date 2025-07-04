package com.dsa_series.roadmap.graphs.minimum_spanning_tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MST_Kruskal_Algorithm {

    public int spanningTree(int V, List<List<List<Integer>>> adj) {
        // To store the edges
        List<int[]> edges = new ArrayList<>();

        // Getting all edges from adjacency list
        for (int i = 0; i < V; i++) {
            for (List<Integer> it : adj.get(i)) {
                int u = i;
                int v = it.get(0);
                int wt = it.get(1);
                edges.add(new int[] { wt, u, v });
            }
        }

        DisjointSet ds = new DisjointSet(V);
        edges.sort(Comparator.comparingInt(a -> a[0]));

        int sum = 0;
        for (int[] it : edges) {
            int wt = it[0];
            int u = it[1];
            int v = it[2];

            if (!ds.find(u, v)) {
                sum += wt;
                ds.unionBySize(u, v);
            }
        }
        return sum;
    }
}

class DisjointSet {
    int[] size;
    int[] rank;
    int[] parent;

    public DisjointSet(int n) {
        size = new int[n + 1];
        parent = new int[n + 1];
        rank = new int[n + 1];

        Arrays.fill(size, 1);
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }
    }

    public int findUltPar(int node) {
        if (node == parent[node]) {
            return node;
        }
        return parent[node] = findUltPar(parent[node]);
    }

    public boolean find(int u, int v) {
        return findUltPar(u) == findUltPar(v);
    }

    public void unionByRank(int u, int v) {
        int ulp_u = findUltPar(u);
        int ulp_v = findUltPar(v);

        if (ulp_u == ulp_v)
            return;

        if (rank[ulp_u] < rank[ulp_v]) {
            parent[ulp_u] = ulp_v;
            rank[ulp_v]++;
        } else if (rank[ulp_v] < rank[ulp_u]) {
            parent[ulp_v] = ulp_u;
            rank[ulp_u]++;
        } else {
            parent[ulp_u] = ulp_v;
            rank[ulp_v]++;
        }
    }

    public void unionBySize(int u, int v) {
        int ulp_u = findUltPar(u);
        int ulp_v = findUltPar(v);

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
