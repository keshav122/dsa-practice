package com.roadmap.graphs.shortest_path_algorithms;

public class PathWithMinimumEffort {
  int[] delRow = { -1, 0, 1, 0 };
  int[] delCol = { 0, -1, 0, 1 };

  // Function to check if a cell is valid
  boolean isValid(int row, int col, int n, int m) {
    // Return false if the cell is invalid
    if (row < 0 || row >= n)
      return false;
    if (col < 0 || col >= m)
      return false;

    // Return true if the cell is valid
    return true;
  }

  public int MinimumEffort(List<List<Integer>> heights) {
    int n = heights.size();
    int m = heights.get(0).size();

    int[][] maxDiff = new int[n][m];
    for (int[] row : maxDiff)
      Arrays.fill(row, Integer.MAX_VALUE);

    PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

    maxDiff[0][0] = 0;
    pq.add(new int[] { 0, 0, 0 });
    while (!pq.isEmpty()) {
      int[] p = pq.poll();
      int diff = p[0];
      int row = p[1];
      int col = p[2];

      if (row == n - 1 && col == m - 1)
        return diff;

      for (int i = 0; i < 4; i++) {
        int newRow = row + delRow[i];
        int newCol = col + delCol[i];

        if (isValid(newRow, newCol, n, m)) {
          int currDiff = Math.abs(heights.get(newRow).get(newCol) - heights.get(row).get(col));
          int currMax = Math.max(currDiff, diff);
          if (currMax < maxDiff[newRow][newCol]) {
            maxDiff[newRow][newCol] = currMax;
            pq.add(new int[] { currMax, newRow, newCol });
          }
        }
      }
    }
    return -1;
  }
}
