package com.leetcode_practice.problems.medium;

import java.util.ArrayList;
import java.util.List;

public class NumberOfLaserBeamsInAbank_2125 {

    public int numberOfBeams(String[] bank) {
        List<Integer> rowCount = new ArrayList<>();
        for (String s : bank) {
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '1') {
                    count++;
                }
            }
            if (count != 0) {
                rowCount.add(count);
            }
        }
        int total = 0;
        for (int i = 1; i < rowCount.size(); i++) {
            total += (rowCount.get(i - 1) * rowCount.get(i));
        }
        return total;
    }
}
