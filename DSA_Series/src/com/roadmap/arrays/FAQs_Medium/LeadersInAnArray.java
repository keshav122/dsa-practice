package com.roadmap.arrays.FAQs_Medium;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LeadersInAnArray {
    public int[] leaders(int[] nums) {
        int n = nums.length;
        List<Integer> leadersList = new LinkedList<>();
        int maxElement = nums[n - 1];
        leadersList.add(maxElement);
        int i = n - 2;
        while (i >= 0) {
            if (nums[i] > maxElement) {
                leadersList.add(nums[i]);
                maxElement = nums[i];
            }
            i--;
        }
        Collections.reverse(leadersList);
        return listToArr(leadersList);
    }

    private int[] listToArr(List<Integer> leadersList) {
        int[] result = new int[leadersList.size()];
        int k = 0;
        for (int element : leadersList) {
            result[k++] = element;
        }
        return result;
    }
}
