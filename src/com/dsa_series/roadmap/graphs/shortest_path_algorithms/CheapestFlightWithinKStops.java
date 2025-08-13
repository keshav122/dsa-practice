/*Author: keshav122 */
package com.dsa_series.roadmap.graphs.shortest_path_algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CheapestFlightWithinKStops {
    public int CheapestFlight(int n, int[][] flights, int src, int dst, int K) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Adding edges to the graph
        for (int[] flight : flights) {
            adj.get(flight[0]).add(new int[] { flight[1], flight[2] });
        }

        int[] minDist = new int[n];
        Arrays.fill(minDist, Integer.MAX_VALUE);

        /*
         * Queue storing the elements of
         * the form {stops, {node, dist}}
         */
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { 0, src, 0 });
        while (!q.isEmpty()) {
            int[] p = q.poll();
            int stops = p[0];
            int node = p[1];
            int dist = p[2];
            /*
             * If the number of stops taken exceed k,
             * skip and move to the next element
             */
            if (stops > K)
                continue;

            for (int[] neighbor : adj.get(node)) {
                int adjNode = neighbor[0];
                int edgeWeight = neighbor[1];

                if (dist + edgeWeight < minDist[adjNode] && stops <= K) {
                    minDist[adjNode] = dist + edgeWeight;
                    q.add(new int[] { stops + 1, adjNode, dist + edgeWeight });
                }
            }
        }

        if (minDist[dst] == Integer.MAX_VALUE)
            return -1;
        return minDist[dst];
    }
}
