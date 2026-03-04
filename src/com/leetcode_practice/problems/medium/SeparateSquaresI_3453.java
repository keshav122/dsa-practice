/*Author: keshav122 */
package com.leetcode_practice.problems.medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SeparateSquaresI_3453 {
    public double separateSquares(int[][] squares) {
        long minYi = Long.MAX_VALUE, maxYi = Long.MIN_VALUE, totalArea = 0;
        for (int[] square : squares) {
            minYi = Math.min(minYi, square[1]);
            maxYi = Math.max(maxYi, (long) square[1] + square[2]);
            totalArea += (1L * square[2] * square[2]);
        }
        double low = minYi;
        double high = maxYi;
        double desiredArea = (totalArea) / 2.0;
        while (high - low > (1e-6)) {
            double mid = low + ((high - low) / 2.0);
            double area = getArea(squares, mid);
            if (area >= desiredArea) {
                high = mid;
            } else {
                low = mid;
            }
        }
        return low;

    }

    private double getArea(int[][] squares, double y) {
        double ans = 0;
        for (int[] s : squares) {
            double bottom = s[1];
            double top = (double) s[1] + s[2];
            if (y <= bottom) {
                continue;
            } else if (y < top) {
                ans += 1.0 * (y - s[1]) * s[2];
            } else {
                ans += (double) s[2] * s[2];
            }
        }
        return ans;
    }
}

class SweepLineSolution {
    static class Event {
        long y;
        long deltaSlope;

        Event(long y, long deltaSlope) {
            this.y = y;
            this.deltaSlope = deltaSlope;
        }
    }

    public double separateSquares(int[][] squares) {
        List<Event> events = new ArrayList<>();
        long totalArea = 0;

        // build events + totalArea
        for (int[] s : squares) {
            long y = s[1];
            long l = s[2];
            events.add(new Event(y, l));
            events.add(new Event(y + l, -l));
            totalArea += l * l;
        }

        double target = totalArea / 2.0;

        // Sort events by y
        events.sort(Comparator.comparingLong(e -> e.y));
        long currentSlope = 0;
        double areaSoFar = 0;
        long prevY = events.get(0).y;

        // Sweep upward
        for (Event e : events) {
            long currY = e.y;
            long deltaY = currY - prevY;

            if (deltaY > 0 && currentSlope > 0) {
                double areaAdded = currentSlope * (double) deltaY;

                if (areaSoFar + areaAdded >= target) {
                    double remaining = target - areaSoFar;
                    return prevY + remaining / currentSlope;
                }
                areaSoFar += areaAdded;
            }

            currentSlope += e.deltaSlope;
            prevY = currY;
        }
        return prevY;
    }
}
