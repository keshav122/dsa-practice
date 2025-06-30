package com.dsa_series.roadmap.graphs.shortest_path_algorithms;

public class Dijkstras_Algorithm {
    // Min-Heap Based Solution
    public int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        int[] dist = new int[V];
        Arrays.fill(dist, (int) 1e9);
        dist[S] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        pq.add(new Pair(0, S));

        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            int distance = p.weight;
            int node = p.node;

            for (ArrayList<Integer> neighbor : adj.get(node)) {
                int adjNode = neighbor.get(0);
                int edgeWt = neighbor.get(1);

                if (distance + edgeWt < dist[adjNode]) {
                    dist[adjNode] = distance + edgeWt;
                    pq.add(new Pair(dist[adjNode], adjNode));
                }
            }
        }

        return dist;
    }

    public int[] dijkstra_SetBased(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        TreeSet<Pair> set = new TreeSet<>(
                (a, b) -> {
                    if (a.weight != b.weight)
                        return Integer.compare(a.weight, b.weight);
                    return Integer.compare(a.node, b.node);
                });
        int[] dist = new int[V];
        Arrays.fill(dist, (int) 1e9);

        dist[S] = 0;
        set.add(new Pair(0, S));
        while (!set.isEmpty()) {
            Pair p = set.pollFirst();
            int distance = p.weight;
            int node = p.node;

            for (ArrayList<Integer> neighbor : adj.get(node)) {
                int adjNode = neighbor.get(0);
                int edgeWt = neighbor.get(1);

                if (distance + edgeWt < dist[adjNode]) {
                    set.remove(new Pair(dist[adjNode], adjNode));
                    dist[adjNode] = distance + edgeWt;
                    set.add(new Pair(dist[adjNode], adjNode));
                }
            }
        }
        return dist;
    }
}

class Pair {
    int weight;
    int node;

    Pair(int weight, int node) {
        this.weight = weight;
        this.node = node;
    }
}
