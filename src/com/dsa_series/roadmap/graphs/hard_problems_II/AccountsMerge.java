package com.dsa_series.roadmap.graphs.hard_problems_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountsMerge {

    static List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DisjointSet ds = new DisjointSet(n);

        // HashMap to store the pair : {mails, node}
        Map<String, Integer> mapMailNode = new HashMap<>();
        // Traverse on all the accounts
        for (int i = 0; i < n; i++) {
            // Starting from index 1 because index 0 is the name
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String mail = accounts.get(i).get(j);
                if (!mapMailNode.containsKey(mail)) {
                    mapMailNode.put(mail, i);
                } else {
                    // Otherwise join it with the previous component
                    // Unite the components
                    ds.unionBySize(i, mapMailNode.get(mail));
                }
            }
        }

        // To store the merged mails
        List<List<String>> mergedMail = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            mergedMail.add(new ArrayList<>());
        }

        // Iterate on the HashMap
        for (Map.Entry<String, Integer> entry : mapMailNode.entrySet()) {
            String mail = entry.getKey();
            int node = ds.findUltParent(entry.getValue());
            mergedMail.get(node).add(mail);
        }

        // To return the result
        List<List<String>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (mergedMail.get(i).isEmpty())
                continue;

            Collections.sort(mergedMail.get(i));
            List<String> temp = new ArrayList<>();
            // This is adding the name
            temp.add(accounts.get(i).get(0));
            temp.addAll(mergedMail.get(i));
            ans.add(temp);
        }
        ans.sort(Comparator.comparing(list -> list.get(0)));
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
        for (int i = 0; i < n; i++) {
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

        if (ult_u < ult_v) {
            parent[ult_u] = ult_v;
            rank[ult_v]++;
        } else if (ult_u > ult_v) {
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

        if (ult_u < ult_v) {
            parent[ult_u] = ult_v;
            size[ult_v] += size[ult_u];
        } else if (ult_v < ult_u) {
            parent[ult_v] = ult_u;
            size[ult_v] += size[ult_u];
        }
    }
}
