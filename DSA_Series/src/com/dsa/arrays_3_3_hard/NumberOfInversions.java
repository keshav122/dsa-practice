package com.dsa.arrays_3_3_hard;

public class NumberOfInversions {

	public static int numberOfInversions(int []a, int n) {
		int count = 0;
        for(int i = 0; i < n-1 ; i++) {
        	for(int j = i+ 1; j< n ; j++) {
        		if(a[i] > a[j]) {
        			count++;
        		}
        	}
        }
        return count;
    }
	public static int numberOfInversions_better(int []a, int n) {
		//TODO Implement a better solution
        return 0;
    }
}
