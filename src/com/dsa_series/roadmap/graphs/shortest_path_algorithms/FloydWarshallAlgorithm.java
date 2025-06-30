package com.dsa_series.roadmap.graphs.shortest_path_algorithms;

public class FloydWarshallAlgorithm {

    public void shortest_distance(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == -1) {
                    matrix[i][j] = (int) (1e9);
                }
                if (i == j)
                    matrix[i][j] = 0;
            }
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == (int) (1e9)) {
                    matrix[i][j] = -1;
                }
            }
        }
    }

    public void shortest_distance_better(int[][] matrix) {
        int n = matrix.length;
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    /* If k is not an intermediate node , skip the iteration */
                    if (matrix[i][k] == -1 || matrix[k][j] == -1) {
                        continue;
                    }
                    // If no direct edge from i to v is present
                    if (matrix[i][j] == -1) {
                        // Update the distance
                        matrix[i][j] = matrix[i][k] + matrix[k][j];
                    } else {
                        matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                    }

                }
            }
        }
    }
}
