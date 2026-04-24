package com.leetcode_practice.problems.easy;

public class FurthestPointFromOrigin_2833 {
    public int furthestDistanceFromOrigin(String moves) {
        int openPos = 0;
        int count = 0;
        for (int i = 0; i < moves.length(); i++) {
            if (moves.charAt(i) == 'R')
                count++;
            else if (moves.charAt(i) == 'L')
                count--;
            else
                openPos++;
        }

        return openPos + Math.abs(count);
    }
}
