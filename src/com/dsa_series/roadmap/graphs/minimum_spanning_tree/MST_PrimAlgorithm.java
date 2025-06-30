package com.dsa_series.roadmap.graphs.minimum_spanning_tree;

public class MST_PrimAlgorithm {
    public int spanningTree(int V, List<List<List<Integer>>> adj) {
        int weightSum = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        boolean[] visited = new boolean[V];
        pq.add(new int[] { 0, 0 });

        while (!pq.isEmpty()) {
            int[] p = pq.poll();
            int weight = p[0];
            int node = p[1];

            if (visited[node])
                continue;
            visited[node] = true;
            weightSum += weight;

            for (List<Integer> it : adj.get(node)) {
                int adjNode = it.get(0);
                int edgeWt = it.get(1);

                if (!visited[adjNode]) {
                    pq.add(new int[] { edgeWt, adjNode });
                }
            }
        }

        return weightSum;
    }
}
