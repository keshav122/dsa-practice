public class ShortestPathInUndirectedGraph {
    public int[] shortestPath(int[][] edges, int N, int M) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
        }

        int[] dist = new int[N];
        Arrays.fill(dist, (int) (1e9));
        bfs(0, adjList, dist);
        for (int i = 0; i < N; i++) {
            if (dist[i] == (int) 1e9)
                dist[i] = -1;
        }
        return dist;
    }

    private void bfs(int source, List<List<Integer>> adjList, int[] dist) {
        dist[source] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        while (!q.isEmpty()) {
            int node = q.poll();
            for (int adjacent : adjList.get(node)) {
                if (dist[node] + 1 < dist[adjacent]) {
                    dist[adjacent] = dist[node] + 1;
                    q.add(adjacent);
                }
            }
        }
    }
}
