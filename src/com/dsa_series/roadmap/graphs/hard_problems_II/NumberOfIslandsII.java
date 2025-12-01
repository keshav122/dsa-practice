/*Author: keshav122 */
package com.dsa_series.roadmap.graphs.hard_problems_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberOfIslandsII {
    // delRow and delCol
    int[] delRow = { -1, 0, 1, 0 };
    int[] delCol = { 0, 1, 0, -1 };

    boolean isValid(int i, int j, int n, int m) {
        return (i >= 0 && i < n && j >= 0 && j < m);
    }

    public List<Integer> numOfIslands(int n, int m, int[][] A) {
        DisjointSet ds = new DisjointSet(n * m);
        boolean[][] vis = new boolean[n][m];
        int count = 0;
        List<Integer> ans = new ArrayList<>();
        for (int[] a : A) {
            int row = a[0];
            int col = a[1];
            if (vis[row][col]) {
                ans.add(count);
                continue;
            }

            vis[row][col] = true;
            count++;

            for (int ind = 0; ind < 4; ind++) {
                int newRow = row + delRow[ind];
                int newCol = col + delCol[ind];
                if (isValid(newRow, newCol, n, m) && vis[newRow][newCol]) {

                    // Get the node and adjacent node number
                    int nodeNumber = row * m + col;
                    int adjNodeNo = newRow * m + newCol;

                    if (ds.findUltParent(nodeNumber) != ds.findUltParent(adjNodeNo)) {
                        count--;
                        ds.unionBySize(nodeNumber, adjNodeNo);
                    }
                }
            }
            ans.add(count);
        }
        return ans;
    }
}

class DisjointSet {
    private int[] size;
    private int[] rank;
    private int[] parent;

    public DisjointSet(int n) {
        size = new int[n + 1];
        rank = new int[n + 1];
        parent = new int[n + 1];
        Arrays.fill(size, 1);
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }
    }

    public int findUltParent(int node) {
        if (parent[node] == node) {
            return parent[node];
        }
        return (parent[node] = findUltParent(parent[node]));
    }

    public void unionByRank(int u, int v) {
        int ult_u = findUltParent(u);
        int ult_v = findUltParent(v);

        if (ult_u == ult_v)
            return;

        if (rank[ult_u] < rank[ult_v]) {
            parent[ult_u] = ult_v;
            rank[ult_v]++;
        } else if (rank[ult_u] > rank[ult_v]) {
            parent[ult_v] = ult_u;
            rank[ult_u]++;
        } else {
            parent[ult_u] = ult_v;
            rank[ult_v]++;
        }
    }

    public void unionBySize(int u, int v) {
        int ult_u = findUltParent(u);
        int ult_v = findUltParent(v);

        if (ult_u == ult_v)
            return;

        if (size[ult_u] < size[ult_v]) {
            parent[ult_u] = ult_v;
            size[ult_v] += size[ult_u];
        } else {
            parent[ult_v] = ult_u;
            size[ult_v] += size[ult_u];
        }
    }
}
