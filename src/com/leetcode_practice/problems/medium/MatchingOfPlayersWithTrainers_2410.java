package com.leetcode_practice.problems.medium;

import java.util.Arrays;

public class MatchingOfPlayersWithTrainers_2410 {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int l = 0, r = 0;
        while (l < players.length && r < trainers.length) {
            if (trainers[r] >= players[l]) {
                l++;
            }
            r++;
        }
        return l;
    }
}
