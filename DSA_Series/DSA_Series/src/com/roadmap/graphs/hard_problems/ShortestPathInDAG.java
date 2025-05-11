public class ShortestPathInDAG {
    public int[] shortestPath(int N, int M, int[][] edges) {
        List<List<Pair>> adjWeightedList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            adjWeightedList.add(new ArrayList<>());
        }
        for (int[] a : edges) {
            adjWeightedList.get(a[0]).add(new Pair(a[1], a[2]));
        }
        boolean[] vis = new boolean[N];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < N; i++) {
            if (!vis[i]) {
                dfs(i, vis, adjWeightedList, st);
            }
        }

        int[] dist = new int[N];
        Arrays.fill(dist, (int) 1e9);
        dist[0] = 0;
        while (!st.isEmpty()) {
            int node = st.pop();
            for (Pair p : adjWeightedList.get(node)) {
                if (dist[node] + p.weight < dist[p.node]) {
                    dist[p.node] = dist[node] + p.weight;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            if (dist[i] == (int) 1e9) {
                dist[i] = -1;
            }
        }
        return dist;
    }

    private void dfs(int node, boolean[] vis, List<List<Pair>> adjWeightedList, Stack<Integer> st) {
        vis[node] = true;
        for (Pair p : adjWeightedList.get(node)) {
            if (!vis[p.node]) {
                dfs(p.node, vis, adjWeightedList, st);
            }
        }
        st.add(node);
    }
}

class Pair {
    int node;
    int weight;

    Pair(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }
}