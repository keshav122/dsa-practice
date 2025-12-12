/*Author: keshav122 */
package com.leetcode_practice.problems.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountCoveredBuildings_3531 {
    public int countCoveredBuildings_BF(int n, int[][] buildings) {
        // Contains y points for same x
        Map<Integer, List<Integer>> xPtMap = new HashMap<>();
        // //Contains x points for same y
        Map<Integer, List<Integer>> yPtMap = new HashMap<>();

        for (int[] building : buildings) {
            if (xPtMap.containsKey(building[0])) {
                List<Integer> li = xPtMap.get(building[0]);
                li.add(building[1]);
                xPtMap.put(building[0], li);
            } else {
                List<Integer> li = new ArrayList<>();
                li.add(building[1]);
                xPtMap.put(building[0], li);
            }

            if (yPtMap.containsKey(building[1])) {
                List<Integer> li = yPtMap.get(building[1]);
                li.add(building[0]);
                yPtMap.put(building[1], li);
            } else {
                List<Integer> li = new ArrayList<>();
                li.add(building[0]);
                yPtMap.put(building[1], li);
            }
        }

        for (List<Integer> li : xPtMap.values()) {
            Collections.sort(li);
        }
        for (List<Integer> li : yPtMap.values()) {
            Collections.sort(li);
        }

        int count = 0;
        for (int[] b : buildings) {
            int x = b[0], y = b[1];
            if (xPtMap.get(x).size() < 3 || yPtMap.get(y).size() < 3) {
                continue;
            }
            boolean leftCovered = isLessThan(xPtMap.get(x), y);
            boolean rightCovered = isGreaterThan(xPtMap.get(x), y);
            boolean topCovered = isLessThan(yPtMap.get(y), x);
            boolean bottomCovered = isGreaterThan(yPtMap.get(y), x);
            if (leftCovered && rightCovered && topCovered && bottomCovered) {
                count++;
            }
        }
        return count;
    }

    private boolean isGreaterThan(List<Integer> list, int x) {
        int low = 0, high = list.size() - 1;
        while (low <= high) {
            int mid = (low + high) >> 1;
            if (list.get(mid) > x) {
                return true;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }

    private boolean isLessThan(List<Integer> list, int x) {
        int low = 0, high = list.size() - 1;
        while (low <= high) {
            int mid = (low + high) >> 1;
            if (list.get(mid) < x) {
                return true;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }

    public int countCoveredBuildings(int n, int[][] buildings) {
        Map<Integer, List<Integer>> xPtMap = new HashMap<>();
        Map<Integer, List<Integer>> yPtMap = new HashMap<>();
        for (int[] b : buildings) {
            xPtMap.computeIfAbsent(b[0], k -> new ArrayList<>()).add(b[1]);
            yPtMap.computeIfAbsent(b[1], k -> new ArrayList<>()).add(b[0]);
        }
        for (List<Integer> li : xPtMap.values()) {
            Collections.sort(li);
        }
        for (List<Integer> li : yPtMap.values()) {
            Collections.sort(li);
        }
        int count = 0;
        for (int[] b : buildings) {
            int x = b[0], y = b[1];
            List<Integer> yCoordinates = xPtMap.get(x);
            List<Integer> xCoordinates = yPtMap.get(y);
            if (yCoordinates.size() < 3 || xCoordinates.size() < 3) {
                continue;
            }

            if (yCoordinates.get(0) < y && yCoordinates.get(yCoordinates.size() - 1) > y && xCoordinates.get(0) < x
                    && xCoordinates.get(xCoordinates.size() - 1) > x) {
                count++;
            }
        }
        return count;
    }

}
