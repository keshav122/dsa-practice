package com.leetcode-practice.problems.medium;

import java.util.Arrays;

public class MagneticForceBetweenTwoBalls_1552 {

	public int maxDistance(int[] position, int m) {
		Arrays.sort(position);
		int n = position.length;
		int maxForce = position[n-1] - position[0];
		for(int minDist = 1; minDist< maxForce; minDist++) {
			if(!canPlaceBalls(position,m, minDist ,n)) {
				return minDist-1;
			}
		}
		return maxForce;
	}

	public int maxDistanceBS(int[] position, int m) {
		Arrays.sort(position);
		int n = position.length;
		int maxForce = position[n-1] - position[0];
		int low =1 ;
		while(low <= maxForce) {
			int mid = (low + maxForce)/2;
			if(!canPlaceBalls(position,m, mid ,n)) {
				maxForce = mid-1;
			}else {
				low = mid + 1;
			}
		}
		return maxForce;
	}
	private boolean canPlaceBalls(int[] position, int ballsToPlace, int minDist,int n) {
		int ballsCount = 1;
		int lastBallPos = position[0];
		for(int i = 1; i < n;i++) {
			if(position[i] - lastBallPos >= minDist) {
				ballsCount++;
				lastBallPos = position[i];
			}
			if(ballsCount >= ballsToPlace) return true;
		}
		return false;
	}
}
