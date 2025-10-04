package com.leetcode_practice.problems.medium;

public class WaterBottlesII_3100 {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int count = numBottles;
        int emptyBottles = numBottles;
        while (emptyBottles >= numExchange) {
            emptyBottles = emptyBottles - numExchange + 1;
            count++;
            numExchange++;

        }
        return count;
    }
}
