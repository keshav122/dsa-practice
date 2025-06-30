/*Author: keshav122 */
package com.roadmap.recursion.FAQs_Hard;

import java.util.ArrayList;
import java.util.List;

public class MColoringProblem {
    boolean graphColoring(int[][] edges, int m, int n) {
        // Creating adjacency list for the graph
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        // To keep a track of the colors used
        int[] colors = new int[n];
        return checkPossibleColoring(0, m, n, adj, colors);
    }

    private boolean checkPossibleColoring(int node, int m, int n, List<List<Integer>> adj, int[] colors) {
        // If all nodes are colored , return true
        if (n == node)
            return true;

        for (int i = 1; i <= m; i++) {
            if (isColoringPossible(i, node, colors, adj)) {
                colors[node] = i;
                // Try to color the next node recursively
                if (checkPossibleColoring(node + 1, m, n, adj, colors))
                    return true;
                colors[node] = 0;
            }
        }
        return false;
    }

    private boolean isColoringPossible(int color, int node, int[] colors, List<List<Integer>> adj) {
        // Check adjacent nodes
        for (int neighbourNodes : adj.get(node)) {
            if (colors[neighbourNodes] == color) {
                return false;
            }
        }
        return true;
    }
}
