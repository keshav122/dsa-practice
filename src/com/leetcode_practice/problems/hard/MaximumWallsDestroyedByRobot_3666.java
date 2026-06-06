/*Author: keshav122 */
package com.leetcode_practice.problems.hard;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/* 
Problem Statement : 
There is an endless straight line populated with some robots and walls. You are given integer arrays robots, distance, and walls:
robots[i] is the position of the ith robot.
distance[i] is the maximum distance the ith robot's bullet can travel.
walls[j] is the position of the jth wall.
Every robot has one bullet that can either fire to the left or the right at most distance[i] meters.

A bullet destroys every wall in its path that lies within its range. Robots are fixed obstacles: if a bullet hits another robot before reaching a wall, it immediately stops at that robot and cannot continue.

Return the maximum number of unique walls that can be destroyed by the robots.

Notes:

A wall and a robot may share the same position; the wall can be destroyed by the robot at that position.
Robots are not destroyed by bullets.

*/
public class MaximumWallsDestroyedByRobot_3666 {

    class Pair {
        int robot, dist;

        Pair(int r, int d) {
            robot = r;
            dist = d;
        }
    }

    int[][] canDestroy; // canDestroy[i][0] = left walls, canDestroy[i][1] = right walls
    Map<Long, Integer> memo;
    int n, m;

    public int maxWalls(int[] robots, int[] distance, int[] walls) {
        n = robots.length;
        m = walls.length;

        Pair[] p = new Pair[n];
        for (int i = 0; i < n; i++) {
            p[i] = new Pair(robots[i], distance[i]);
        }

        Arrays.sort(p, Comparator.comparingInt(a -> a.robot));
        Arrays.sort(walls);

        canDestroy = new int[n][2];
        memo = new HashMap<>();

        // Precompute walls each robot can destroy in each direction
        for (int i = 0; i < n; i++) {
            int r = p[i].robot;
            int d = p[i].dist;

            int leftStart = (i == 0) ? r - d : Math.max(r - d, p[i - 1].robot);
            int leftEnd = r;

            int rightStart = r;
            int rightEnd = (i == n - 1) ? r + d : Math.min(r + d, p[i + 1].robot);

            canDestroy[i][0] = (int) (((long) lower_bound(walls, leftStart) << 16) | upper_bound(walls, leftEnd));
            canDestroy[i][1] = (int) (((long) lower_bound(walls, rightStart) << 16) | upper_bound(walls, rightEnd));
        }

        return solve(0, 0);
    }

    private int solve(int i, long destroyedMask) {
        if (i == n)
            return Long.bitCount(destroyedMask);

        long key = (((long) i) << 32) | destroyedMask;
        if (memo.containsKey(key))
            return memo.get(key);

        // Try left direction
        long leftInterval = canDestroy[i][0];
        int leftL = (int) (leftInterval >> 16);
        int leftR = (int) (leftInterval & 0xFFFF) - 1;
        long newMaskLeft = destroyedMask;
        for (int j = leftL; j <= leftR && j < m; j++) {
            newMaskLeft |= (1L << j);
        }
        int resultLeft = solve(i + 1, newMaskLeft);

        // Try right direction
        long rightInterval = canDestroy[i][1];
        int rightL = (int) (rightInterval >> 16);
        int rightR = (int) (rightInterval & 0xFFFF) - 1;
        long newMaskRight = destroyedMask;
        for (int j = rightL; j <= rightR && j < m; j++) {
            newMaskRight |= (1L << j);
        }
        int resultRight = solve(i + 1, newMaskRight);

        int result = Math.max(resultLeft, resultRight);
        memo.put(key, result);
        return result;
    }

    private int lower_bound(int[] arr, int x) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] < x)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return low;
    }

    private int upper_bound(int[] arr, int x) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] <= x)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return low;
    }
}
