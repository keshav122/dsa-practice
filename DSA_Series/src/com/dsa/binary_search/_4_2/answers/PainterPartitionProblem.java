package com.dsa.binary_search._4_2.answers;

import java.util.ArrayList;
import java.util.Collections;

public class PainterPartitionProblem {

	public static int findLargestMinDistance(ArrayList<Integer> boards, int k)
    {
		int n = boards.size();
        int minTime = Collections.max(boards);
        int maxTime = boards.stream().mapToInt(Integer::intValue).sum();
        while(minTime <= maxTime) {
        	int midTime = (minTime + maxTime)/2;
        	if(paintersUtilized(boards,midTime,n) <= k) {
        		maxTime = midTime -1;
        	}else {
        		minTime = midTime + 1;
        	}
        }
        return minTime;
    }

	private static int paintersUtilized(ArrayList<Integer> boards, int allowedTime,int n) {
		int painterCount = 1;
		int time = 0;
		for(int i = 0; i< n ; i++) {
			if(time + boards.get(i) <= allowedTime) {
				time += boards.get(i);
			}else {
				time = boards.get(i);
				painterCount++;
			}
		}
		return painterCount;
	}
	
}
