package com.dsa.arrays_3_1_easy;

public class MaximumConsecutiveOnes_Traffic {

	public static int traffic(int n, int m, int[] vehicle) {
		int maxSize = 0;
		for(int i = 0; i< n; i++) {
			int j = i;
			int size = 0;
			int temp = m;
			while(temp >= 0 && j < n) {
				if(vehicle[j] == 0 && temp > 0) {
					temp--;
					size++;
				}else if(vehicle[j] == 1) {
					size++;
				}
				
				j++;
			}
			maxSize = Math.max(maxSize, size);
		}
		return maxSize;
	}
	
	public static void main(String[] args) {
		int[] vehicle = {0,1,0,0,1,0};
		int m = 3;
		System.out.println(traffic(vehicle.length, m, vehicle));
	}
}
