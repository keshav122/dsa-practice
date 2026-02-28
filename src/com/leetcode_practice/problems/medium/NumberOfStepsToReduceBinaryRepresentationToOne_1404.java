package com.leetcode_practice.problems.medium;

public class NumberOfStepsToReduceBinaryRepresentationToOne_1404 {
    public int numSteps(String s) {
        int n = s.length();
        int steps = 0;
        int carry = 0;
        for (int i = n - 1; i > 0; i--) {
            if (s.charAt(i) == '1') {
                if (carry == 0) {
                    steps += 2;
                    carry = 1;
                } else {
                    steps++;
                    carry = 0;
                }
            } else {
                if (carry == 0) {
                    steps++;
                    carry = 0;
                } else {
                    steps += 2;
                    carry = 1;
                }
            }
        }

        if (s.charAt(0) == '1') {
            steps += (carry == 0) ? 0 : 1;
        }
        return steps;
    }
}
