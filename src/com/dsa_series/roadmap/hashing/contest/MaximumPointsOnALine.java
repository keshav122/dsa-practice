/*Author: keshav122 */
package com.dsa_series.roadmap.hashing.contest;

import java.util.HashMap;
import java.util.Map;

public class MaximumPointsOnALine {
    // Implemented after seeing editorial
    public int maximumPointsOnALine(int[][] points) {
        int n = points.length;

        // If there are 2 or fewer points all of them are on a line
        if (n <= 2)
            return n;

        int maxPointsOnLine = 0;

        // Loop through each point
        for (int i = 0; i < n; i++) {
            Map<String, Integer> slopeCount = new HashMap<>();// Map to store count of slopes
            int samePoints = 1; // Count the base point itself
            int currMax = 0;
            // Compare with every other point
            for (int j = i + 1; j < n; j++) {
                int dx = points[j][0] - points[i][0];// difference in x -coordinates
                int dy = points[j][1] - points[i][1];// difference in y-coordinates

                if (dx == 0 && dy == 0) {
                    // Same point, skip as we only care about unique points
                    samePoints++;
                    continue;
                }

                // Reduce the method to its simplest form
                int g = gcd(dy, dx);// Get the greatest common divisor
                if (g != 0) {
                    dy /= g;
                    dx /= g;
                }

                // Represent slope as a string (to handle negative signs consistently)
                String slope = dy + "/" + dx;
                slopeCount.put(slope, slopeCount.getOrDefault(slope, 0) + 1);
                currMax = Math.max(currMax, slopeCount.get(slope));
            }
            maxPointsOnLine = Math.max(maxPointsOnLine, currMax + samePoints); // Update result
        }
        return maxPointsOnLine; // Return the maximum number of points on a line
    }

    private int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
}
