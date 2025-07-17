/*Author: keshav122 */
package com.dsa_series.roadmap.graphs.shortest_path_algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class NumberOfWaysToArriveAtDestination {
    public int countPaths(int n, List<List<Integer>> roads) {
        int mod = 1000000007;
        List<int[]>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (List<Integer> road : roads) {
            adj[road.get(0)].add(new int[] { road.get(1), road.get(2) });
            adj[road.get(1)].add(new int[] { road.get(0), road.get(2) });
        }
        long[] minTime = new long[n];
        Arrays.fill(minTime, Long.MAX_VALUE);
        int[] ways = new int[n];

        int paths = 0;
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        minTime[0] = 0;
        ways[0] = 1;
        pq.add(new long[] { 0, 0 });

        while (!pq.isEmpty()) {
            long[] p = pq.poll();
            long time = p[0];
            int node = (int) p[1];

            for (int[] neighbor : adj[node]) {
                int adjNode = neighbor[0];
                int travelTime = neighbor[1];

                if (time + travelTime < minTime[adjNode]) {
                    minTime[adjNode] = time + travelTime;
                    ways[adjNode] = ways[node];
                    pq.add(new long[] { minTime[adjNode], adjNode });
                } else if (time + travelTime == minTime[adjNode]) {
                    ways[adjNode] = (ways[adjNode] + ways[node]) % mod;
                }

            }

        }
        return ways[n - 1] % mod;
    }
}
