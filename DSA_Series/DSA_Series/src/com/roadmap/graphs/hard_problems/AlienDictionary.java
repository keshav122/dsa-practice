public class AlienDictionary {
    // Follow up for this question - when it is not possible to determine the order
    // if there are strings like {abcd , abc } - evrything matches upto c so abc
    // should have been prior to abcd
    // 2nd case if there is a cyclic dependency - {abc, bat, ade} - Because of
    // cyclic dependency topo sort is not possible
    public String findOrder(String[] dict, int N, int K) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < N - 1; i++) {
            String str1 = dict[i];
            String str2 = dict[i + 1];
            int len = Math.min(str1.length(), str2.length());
            for (int ptr = 0; ptr < len; ptr++) {
                if (str1.charAt(ptr) != str2.charAt(ptr)) {
                    adjList.get(str1.charAt(ptr) - 'a').add(str2.charAt(ptr) - 'a');
                    break;
                }
            }
        }
        List<Integer> topo = topoSort(K, adjList);
        StringBuilder sb = new StringBuilder();
        for (int it : topo) {
            char alphabet = (char) (it + (int) ('a'));
            sb.append(alphabet);
        }
        return sb.toString();
    }

    private List<Integer> topoSort(int K, List<List<Integer>> adjList) {
        int[] inDegree = new int[K];
        for (int i = 0; i < K; i++) {
            for (Integer it : adjList.get(i)) {
                inDegree[it]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < K; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }
        List<Integer> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.poll();
            ans.add(node);
            for (Integer it : adjList.get(node)) {
                inDegree[it]--;
                if (inDegree[it] == 0) {
                    q.add(it);
                }
            }
        }
        return ans;
    }

}
