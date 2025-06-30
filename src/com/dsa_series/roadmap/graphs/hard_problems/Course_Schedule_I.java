package com.dsa_series.roadmap.graphs.hard_problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Course_Schedule_I {
    public boolean canFinish(int N, int[][] arr) {
        List<Integer>[] adjList = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int[] a : arr) {
            adjList[a[0]].add(a[1]);
        }

        if (topoSort(N, adjList).length < N)
            return false;
        return true;
    }

    public int[] topoSort(int N, List<Integer>[] adj) {
        int[] indegree = new int[N];
        int[] ans = new int[N];
        for (int i = 0; i < N; i++) {
            for (int it : adj[i]) {
                indegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        int index = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            ans[index++] = node;
            for (int adjacent : adj[node]) {
                indegree[adjacent]--;
                if (indegree[adjacent] == 0) {
                    q.add(adjacent);
                }
            }
        }
        return Arrays.copyOfRange(ans, 0, index);
    }
}
