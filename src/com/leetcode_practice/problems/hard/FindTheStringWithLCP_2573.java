package com.leetcode_practice.problems.hard;

import java.util.Arrays;

public class FindTheStringWithLCP_2573 {
    public String findTheString(int[][] lcp) {
        int n = lcp.length;

        // Step 1 : Basic validation
        for (int i = 0; i < n; i++) {
            if (lcp[i][i] != n - i)
                return "";
            for (int j = 0; j < n; j++) {
                if (lcp[i][j] != lcp[j][i])
                    return "";
                if (lcp[i][j] > Math.min(n - i, n - j))
                    return "";
            }
        }

        // Step 2 : DSU for equality constraints
        DSU dsu = new DSU(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int k = lcp[i][j];
                for (int d = 0; d < k; d++) {
                    dsu.union(i + d, j + d);
                }
            }
        }

        // Step 3 : Assign characters
        char[] res = new char[n];
        Arrays.fill(res, '#');

        int[] groupChar = new int[n];
        Arrays.fill(groupChar, -1);
        int nextChar = 0;

        for (int i = 0; i < n; i++) {
            int root = dsu.find(i);
            if (groupChar[root] == -1) {
                if (nextChar >= 26)
                    return "";
                groupChar[root] = nextChar++;
            }
            res[i] = (char) ('a' + groupChar[root]);
        }

        // Step 4 : Recompute LCP using DP
        int[][] computed = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (res[i] == res[j]) {
                    if (i == n - 1 || j == n - 1) {
                        computed[i][j] = 1;
                    } else {
                        computed[i][j] = 1 + computed[i + 1][j + 1];
                    }
                } else {
                    computed[i][j] = 0;
                }
            }
        }

        // Compare matrices
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (computed[i][j] != lcp[i][j])
                    return "";
            }
        }
        return new String(res);

    }

    class DSU {
        int[] parent;

        DSU(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++)
                parent[i] = i;
        }

        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        void union(int a, int b) {
            int pa = find(a);
            int pb = find(b);
            if (pa != pb) {
                parent[pa] = pb;
            }
        }

    }
}
