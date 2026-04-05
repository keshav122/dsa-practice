package com.leetcode_practice.problems.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SmallestStringWithSwaps_1202 {

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        List<List<Integer>> adjList = new ArrayList<>();
        int V = s.length();
        for (int i = 0; i < s.length(); i++) {
            adjList.add(new ArrayList<>());
        }
        for (List<Integer> li : pairs) {
            adjList.get(li.get(0)).add(li.get(1));
            adjList.get(li.get(1)).add(li.get(0));
        }

        boolean[] vis = new boolean[V];
        char[] res = new char[V];
        for (int i = 0; i < V; i++) {
            if (vis[i])
                continue;
            List<Integer> indices = new ArrayList<>();
            List<Character> chars = new ArrayList<>();
            dfs(i, adjList, vis, indices, chars, s);

            Collections.sort(indices);
            Collections.sort(chars);
            for (int j = 0; j < indices.size(); j++) {
                res[indices.get(j)] = chars.get(j);
            }
        }

        return new String(res);

    }

    private void dfs(int node, List<List<Integer>> adjList, boolean[] vis, List<Integer> indices, List<Character> chars,
            String s) {
        vis[node] = true;
        indices.add(node);
        chars.add(s.charAt(node));
        for (Integer it : adjList.get(node)) {
            if (!vis[it]) {
                dfs(it, adjList, vis, indices, chars, s);
            }
        }
    }
}

class SmallestStringWithSwaps_1202_DSU_Based {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n = s.length();
        DSU dsu = new DSU(n);

        // Step 1 : union
        for (List<Integer> p : pairs) {
            dsu.union(p.get(0), p.get(1));
        }

        // Step 2: group by parent
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int parent = dsu.find(i);
            map.computeIfAbsent(parent, k -> new ArrayList<>()).add(i);
        }

        char[] res = new char[n];
        // process each component
        for (List<Integer> indices : map.values()) {
            List<Character> chars = new ArrayList<>();

            for (int idx : indices) {
                chars.add(s.charAt(idx));
            }

            Collections.sort(indices);
            Collections.sort(chars);

            for (int j = 0; j < indices.size(); j++) {
                res[indices.get(j)] = chars.get(j);
            }
        }
        return new String(res);
    }
}

class DSU {
    int[] parent;

    DSU(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);// path compression
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