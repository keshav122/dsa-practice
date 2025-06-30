package com.roadmap.graphs.shortest_path_algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import com.roadmap.binary_search.FAQs.MinimizeMaxDistToGasStations.Pair;

public class PrintShortestPath {

    public List<Integer> shortestPath(int n, int m, int[][] edges) {
        List<List<int[]>> adjList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            adjList.get(edges[i][0]).add(new int[] { edges[i][1], edges[i][2] });
            adjList.get(edges[i][1]).add(new int[] { edges[i][0], edges[i][2] });
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int[] dist = new int[n + 1];
        int[] parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dist[i] = (int) (1e9);
            parent[i] = i;
        }

        dist[1] = 0;
        pq.add(new int[] { 0, 1 });
        while (pq.size() != 0) {
            int[] it = pq.poll();
            int distance = it[0];
            int node = it[1];

            for (int[] p : adjList.get(node)) {
                int adjNode = p[0];
                int edgeWeight = p[1];
                if (distance + edgeWeight < dist[adjNode]) {
                    dist[adjNode] = distance + edgeWeight;
                    pq.add(new int[] { distance + edgeWeight, adjNode });
                    parent[adjNode] = node;
                }
            }
        }

        List<Integer> path = new ArrayList<>();
        if (dist[n] == (int) (1e9)) {
            path.add(-1);
            return path;
        }

        int node = n;
        while (parent[node] != node) {
            path.add(node);
            node = parent[node];
        }
        path.add(1);
        Collections.reverse(path);
        path.add(0, dist[n]);
        return path;
    }
}