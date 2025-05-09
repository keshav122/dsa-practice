public class Course_Schedule_II {
    public int[] findOrder(int N, int[][] arr) {
        List<Integer>[] adjList = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            adjList[i] = new ArrayList<>();
        }
        // for [a,b] , b must has to be done before a can be done
        // that means to reach b a has to there , therefore the link b-> a
        for (int[] a : arr) {
            adjList[a[1]].add(a[0]);
        }

        int[] res = topoSort(N, adjList);
        if (res.length < N)
            return new int[] {};
        return res;
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
