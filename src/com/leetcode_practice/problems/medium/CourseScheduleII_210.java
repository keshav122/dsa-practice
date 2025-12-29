package com.leetcode_practice.problems.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class CourseScheduleII_210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] adj = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] a : prerequisites) {
            int u = a[0];
            int v = a[1];
            adj[v].add(u);
        }

        int[] topo = topoSort(numCourses, adj);
        if (topo.length < numCourses)
            return new int[] {};
        return topo;
    }

    private int[] topoSort(int V, ArrayList<Integer>[] adj) {
        int[] indegree = new int[V];
        for (int i = 0; i < V; i++) {
            for (int it : adj[i]) {
                indegree[it]++;
            }
        }
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0)
                q.add(i);
        }
        int[] ans = new int[V];
        int idx = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            ans[idx++] = node;
            for (int neighbor : adj[node]) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    q.add(neighbor);
                }
            }
        }
        return Arrays.copyOfRange(ans, 0, idx);
    }
}
