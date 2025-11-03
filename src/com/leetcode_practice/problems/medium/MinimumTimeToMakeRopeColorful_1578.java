package com.leetcode_practice.problems.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinimumTimeToMakeRopeColorful_1578 {
    public int minCost(String colors, int[] neededTime) {
        List<Integer> list = new ArrayList<>();
        char lastChar = colors.charAt(0);
        list.add(neededTime[0]);
        int time = 0;
        for (int i = 1; i < colors.length(); i++) {
            char c = colors.charAt(i);
            if (c == lastChar) {
                list.add(neededTime[i]);
            } else {
                if (list.size() > 1) {
                    Collections.sort(list);
                    for (int j = 0; j < list.size() - 1; j++) {
                        time += list.get(j);
                    }
                }
                list.clear();
                list.add(neededTime[i]);
                lastChar = c;
            }
        }
        if (list.size() > 1) {
            Collections.sort(list);
            for (int j = 0; j < list.size() - 1; j++) {
                time += list.get(j);
            }
        }
        return time;
    }

    public int minCost_better(String colors, int[] neededTime) {
        List<Integer> list = new ArrayList<>();
        char lastChar = colors.charAt(0);
        list.add(neededTime[0]);
        int currMax = neededTime[0];
        int time = 0;
        for (int i = 1; i < colors.length(); i++) {
            char c = colors.charAt(i);
            if (c == lastChar) {
                currMax = Math.max(currMax, neededTime[i]);
                list.add(neededTime[i]);
            } else {
                if (list.size() > 1) {
                    for (int j = 0; j < list.size(); j++) {
                        time += list.get(j);
                    }
                    time -= currMax;
                }
                list.clear();
                list.add(neededTime[i]);
                lastChar = c;
                currMax = neededTime[i];
            }
        }
        if (list.size() > 1) {
            for (int j = 0; j < list.size(); j++) {
                time += list.get(j);
            }
            time -= currMax;
        }
        return time;
    }

    public int minCost_optiml(String colors, int[] neededTime) {
        int totalTime = 0;
        int maxTime = neededTime[0];

        for (int i = 1; i < colors.length(); i++) {
            if (colors.charAt(i) == colors.charAt(i - 1)) {
                totalTime += Math.min(maxTime, neededTime[i]);
                maxTime = Math.max(maxTime, neededTime[i]);
            } else {
                maxTime = neededTime[i];
            }
        }
        return totalTime;
    }
}
