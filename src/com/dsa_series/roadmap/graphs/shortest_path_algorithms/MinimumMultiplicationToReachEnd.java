package com.dsa_series.roadmap.graphs.shortest_path_algorithms;

public class MinimumMultiplicationToReachEnd {
    public int minimumMultiplications(int[] arr, int start, int end) {
        if (start == end) {
            return 0;
        }

        int n = arr.length;
        int mod = 100000;
        int[] minSteps = new int[mod];
        Arrays.fill(minSteps, Integer.MAX_VALUE);
        Queue<int[]> q = new LinkedList<>();
        minSteps[start] = 0;
        // Add the initial node to queue
        q.add(new int[] { 0, start });
        while (!q.isEmpty()) {
            int[] p = q.poll();
            int steps = p[0];
            int val = p[1];
            for (int a : arr) {
                int num = (val * a) % mod;
                if (num == end)
                    return steps + 1;

                if (steps + 1 < minSteps[num]) {
                    minSteps[num] = steps + 1;
                    q.add(new int[] { steps + 1, num });
                }
            }
        }
        return -1;
    }
}
