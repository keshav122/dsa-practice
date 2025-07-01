package com.dsa_series.roadmap.graphs.shortest_path_algorithms;

import java.util.Arrays;

public class FindCityWithSmallestNumberOfNeighbors {
    public int findCity(int n, int m, int edges[][], int distanceThreshold) {
        int[][] adjMat = new int[n][n];
        for (int[] row : adjMat)
            Arrays.fill(row, (int) 1e9);

        for (int[] edge : edges) {
            adjMat[edge[0]][edge[1]] = edge[2];
            adjMat[edge[1]][edge[0]] = edge[2];
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    adjMat[i][j] = Math.min(adjMat[i][j], adjMat[i][k] + adjMat[k][j]);
                }
            }
        }

        int minCount = (int) 1e9;
        int ans = -1;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && adjMat[i][j] <= distanceThreshold) {
                    count++;
                }
            }

            if (count < minCount) {
                minCount = count;
                ans = i;
            } else if (count == minCount) {
                ans = i;
            }
        }
        return ans;
    }
}
