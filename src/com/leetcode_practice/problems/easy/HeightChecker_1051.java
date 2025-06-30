package com.leetcode_practice.problems.easy;

import java.util.Arrays;

public class HeightChecker_1051 {

	public int heightChecker_BForce(int[] heights) {
		int n = heights.length;
		int[] temp = new int[n];
		for(int i = 0; i< n; i++) {
			temp[i] = heights[i];
		}
		int count = 0;
        Arrays.sort(temp);
        for(int i = 0; i< n ; i++) {
        	if(heights[i] != temp[i]) {
        		 count++;
        	}
        }
        return count;
    }
	
	public int heightChecker_better(int[] heights) {
		int currMax = heights[0];
		int count = 0;
		int maxIndex = 0;
		for(int i = 1; i< heights.length; i++) {
			if(heights[i] < currMax) {
				count++;
			}
			currMax = Math.max(currMax, heights[i]);
 			if(currMax <= heights[i]) { 
				maxIndex = i;
			}
		}
		if(maxIndex == 0) {
			return count + 1;
		}
		return count;
	}
	
	public static void main(String[] args) {
		int[] a = {5,1,2,3,4};
		HeightChecker_1051 h = new HeightChecker_1051();
		System.out.println(h.heightChecker_better(a));
	}
}
