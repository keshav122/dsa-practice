package com.leetcode_practice.problems.hard;

import java.util.ArrayList;
import java.util.List;

public class NumberOfWaysToDivideACorridor_2147 {
    public int numberOfWays(String corridor) {
        int MOD = (int) (1e9) + 7;
        int n = corridor.length();
        int totalSeats = 0;
        for (int i = 0; i < n; i++) {
            if (corridor.charAt(i) == 'S')
                totalSeats++;
        }
        if (totalSeats == 0 || totalSeats % 2 == 1)
            return 0;
        // We need to calculate the plants that come up after 2 seats are covered and
        // till the new seat is added
        List<Integer> list = new ArrayList<>();
        int i = 0;
        int seats = 0, plants = 0;
        while (i < n) {
            if (corridor.charAt(i) == 'S') {
                if (seats < 2) {
                    seats++;
                } else {
                    list.add(plants);
                    plants = 0;
                    seats = 1;
                }
            } else {
                if (seats == 2) {
                    plants++;
                }
            }
            i++;
        }
        long product = 1;
        for (Integer plant : list) {
            product = (product * (plant + 1)) % MOD;
        }
        return (int) product;
    }

    public int numberOfWays_optimal(String corridor) {
        long ways = 1;
        int MOD = 1000000007;
        int seats = 0, plants = 0;
        for (char ch : corridor.toCharArray()) {
            if (ch == 'S') {
                seats++;
                if (seats > 2 && seats % 2 == 1) {
                    ways = (ways * (plants + 1)) % MOD;
                    plants = 0;
                }
            } else {
                if (seats % 2 == 0 && seats > 0) {
                    plants++;
                }
            }
        }
        return (seats > 0 && seats % 2 == 0) ? (int) ways : 0;
    }
}
