package com.roadmap.graphs.shortest_path_algorithms;

public class Bellman_Ford_Algorithm {
    static int[] bellman_ford(int V,
            ArrayList<ArrayList<Integer>> edges, int S) {
        int[] dist = new int[V];
        Arrays.fill(dist, (int) 1e9);
        dist[S] = 0;
        for (int i = 0; i < V - 1; i++) {
            for (ArrayList<Integer> it : edges) {
                int u = it.get(0);
                int v = it.get(1);
                int wt = it.get(2);

                if (dist[u] != 1e9 && dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                }
            }
        }
        /*
         * An extra relaxation to check if the
         * graph consists of a negative cycle
         */
        for (ArrayList<Integer> it : edges) {
            int u = it.get(0);// node 1
            int v = it.get(1);// node 2
            int wt = it.get(2);// edge weight

            /*
             * If edge relaxation is possible,
             * negative cycle exists
             */
            if (dist[u] != 1e9 && dist[u] + wt < dist[v]) {
                return new int[] { -1 };
            }
        }
        return dist;
    }
}
