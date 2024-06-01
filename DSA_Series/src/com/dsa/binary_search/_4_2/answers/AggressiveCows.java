package com.dsa.binary_search._4_2.answers;

import java.util.Arrays;

public class AggressiveCows {

	public static int aggressiveCows(int[] stalls, int k) {
		Arrays.sort(stalls);
		int maxDist = stalls[stalls.length -1] - stalls[0];
		for(int i = 1; i< maxDist; i++) {
			if(!cowsCanbePlaced(stalls,i,k)) {
				return i-1;//because it was possible for the previous value
			}
		}
		return maxDist;
	}

	private static boolean cowsCanbePlaced(int[] stalls, int minDistToMaintain, int cows) {
		//we will place the first cow always at the first coordinate
		int cowsCount = 1;
		int n = stalls.length;
		int lastCowPosition = stalls[0];
		for(int i = 1; i< n ; i++) {
			if(stalls[i] - lastCowPosition >= minDistToMaintain) {
				cowsCount++;
				lastCowPosition = stalls[i];
			}
				
		}
		return (cowsCount >= cows);
	}
	
	public static int aggressiveCowsBinarySearch(int[] stalls, int k) {
		Arrays.sort(stalls);
		int maxDist = stalls[stalls.length -1] - stalls[0];
		int low = 1;
		while(low <= maxDist) {
			int mid = (low + maxDist)/2;
			if(!cowsCanbePlaced(stalls,mid,k)) {
				maxDist = mid -1;
			}else {
				low = mid + 1;
			}
		}
		return maxDist;
	}
	public static void main(String[] args) {
		int k = 2;
		int[] stalls = {1,2,3};
		System.out.println(aggressiveCows(stalls, k));
	}
}
