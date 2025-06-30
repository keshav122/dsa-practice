package com.leetcode-practice.problems.medium;

public class NumberofStepstoReduceaNumberinBinaryRepresentationtoOne {

   public int numSteps(String s) {
        Integer a  = Integer.parseInt(s, 2);
        int steps = 0;
        while (a != 1) {
        	if( a% 2 == 0) a /= 2;
        	else a += 1;
        	
        	steps++;
        }
        return steps;
    }
}
