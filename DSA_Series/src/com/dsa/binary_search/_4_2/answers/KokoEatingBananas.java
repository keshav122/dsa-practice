package com.dsa.binary_search._4_2.answers;

public class KokoEatingBananas {

	public static int minimumRateToEatBananas(int[] v, int h) {

		//Because the max bananas Koko can eat is in one pile
		//After eating one pile she will not eat bananas from the next pile
		//even if time is left
		//It is very imp in binary search on answers to decide the range
		//as the range will determine the Time Complexity
		int max = 0;
		
		for(int i: v) {
			max = Math.max(max, i);
		}
		for (int k = 1; k <=  max; k++) {
			long val = 0;
			for (int i : v) {
				val += Math.ceilDiv(i, k);
				if (val > h)
					break;
			}
			if (val <= h) {
				return k;
			}
		}
		return -1;
	}

	public static int minimumRateToEatBananas1(int[] v, int h) {
        int max = 0;
		for(int i: v) {
			max = Math.max(max, i);
		}
		for (int k = 1; k <= max; k++) {
			long val = 0;
			for (int i : v) {
				if (i % k == 0) {
					val += (i / k);
				} else {
					val = val + (i / k) + 1;
				}

				if (val > h)
					break;
			}
			if (val <= h) {
				return k;
			}
		}
		return -1;
	}

	public static int minimumRateToEatBananas2(int[] v, int h) {
        int max = 0;
		for(int i: v) {
			max = Math.max(max, i);
		}
		int minVal = max;
		int low = 1;
		int high = max;
		while(low <= high) {
			int mid = (low + high)/2;
			long val = 0; 
			for(int i : v) {
				if (i % mid == 0) {
					val += (i / mid);
				} else {
					val = val + (i / mid) + 1;
				}

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
	public static void main(String[] args) {
		int[] v = {25 ,12 ,8 ,14 ,19};
		int h = 5;
		System.out.println(minimumRateToEatBananas1(v, h));
	}
}
