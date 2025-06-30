/*Author: keshav122 */
package com.problems.medium;

public class KokoEatingBananas_875 {
	
	public int minEatingSpeed(int[] piles, int h) {
		for(int k = 1; k<= Math.pow(10,9) ; k++) {
			long val = 0; 
			for(int i : piles) {
				val += Math.ceilDiv(i,k);
				if(val > h)  break;
			}
			if(val <= h) {
				return k;
			}
		}
		return -1;
	}
	
	
	public int minEatingSpeed1(int[] piles, int h) {
		int minVal = Integer.MAX_VALUE;
		int low = 1;
		int high = (int) Math.pow(10, 9);
		while(low <= high) {
			int mid = (low + high)/2;
			long val = 0; 
			for(int i : piles) {
				val += Math.ceilDiv(i,mid);
			}
			if(val <= h) {
				minVal = Math.min(minVal, mid);
				high = mid-1;
			}else {
				low = mid + 1;
			}
		}
		
		return minVal;
	}
	
	public int minEatingSpeed2(int[] piles, int h) {
		int max = 0;
		for(int i: piles) {
			max = Math.max(max, i);
		}
		int minVal = max;
		int low = 1;
		int high = max;
		while(low <= high) {
			int mid = (low + high)/2;
			long val = 0; 
			for(int i : piles) {
				val += Math.ceilDiv(i,mid);
			}
			if(val <= h) {
				minVal = Math.min(minVal, mid);
				high = mid-1;
			}else {
				low = mid + 1;
			}
		}
		
		return minVal;
	}
	
	public int minEatingSpeed3(int[] piles, int h) {
		int max = 0;
		for(int i: piles) {
			max = Math.max(max, i);
		}
		int low = 1;
		int high = max;
		while(low <= high) {
			int mid = (low + high)/2;
			long val = 0; 
			for(int i : piles) {
				val += Math.ceilDiv(i,mid);
			}
			if(val <= h) {
				high = mid-1;
			}else {
				low = mid + 1;
			}
		}
		
		return low;//because low started from impossible region and will move to a possible region
	}
	public static void main(String[] args) {
		int[] piles = {805306368,805306368,805306368};
		int h = 1000000000;
		KokoEatingBananas_875 k = new KokoEatingBananas_875();
		System.out.println(k.minEatingSpeed1(piles, h));
	}
}
