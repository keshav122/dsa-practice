package com.dsa.arrays_3_3_hard;

public class TeamContest {
	public static int team(int []skill, int n){
		int count = 0;
        for(int i = 0; i < n-1 ; i++) {
        	for(int j = i+ 1; j< n ; j++) {
        		if(skill[i] > 2 * skill[j]) {
        			count++;
        		}
        	}
        }
        return count;
    }
}
