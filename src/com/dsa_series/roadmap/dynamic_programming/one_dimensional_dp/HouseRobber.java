package com.dsa_series.roadmap.dynamic_programming.one_dimensional_dp;

import java.util.Arrays;

public class HouseRobber {
    public int houseRobber(int[] money) {
        int n = money.length;
        if (n == 1)
            return money[0];
        int[] temp1 = Arrays.copyOfRange(money, 0, n - 1);
        int[] temp2 = Arrays.copyOfRange(money, 1, n);
        return Math.max(nonAdjacent_Tabulation_SO(temp1), nonAdjacent_Tabulation_SO(temp2));
    }

    public int nonAdjacent_Tabulation_SO(int[] nums) {
        int prev2 = 0;
        int prev = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int notPick = prev;
            int pick = nums[i];
            if (i > 1) {
                pick += prev2;
            }
            int curr = Math.max(pick, notPick);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}
