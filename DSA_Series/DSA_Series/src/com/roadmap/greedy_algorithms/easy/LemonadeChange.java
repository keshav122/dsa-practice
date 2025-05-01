package com.roadmap.greedy_algorithms.easy;

public class LemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        int fives = 0, tens = 0;
        for (int bill : bills) {
            int change = bill - 5;
            if (change == 5) {
                tens++;
                if (fives > 0) {
                    fives--;
                } else {
                    return false;
                }
            } else if (change == 15) {
                if (tens > 0 && fives > 0) {
                    tens--;
                    fives--;
                } else if (fives > 2) {
                    fives -= 3;
                } else {
                    return false;
                }
            } else {
                fives++;
            }
        }
        return true;
    }
}
