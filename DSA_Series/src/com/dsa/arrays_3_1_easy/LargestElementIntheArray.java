package com.dsa.arrays_3_1_easy;

public class LargestElementIntheArray {

	 static int largestElement(int[] arr, int n) {
	        int maxValue = arr[0];
	        for(int i = 1; i< n; i++) {
	        	if(arr[i] > maxValue) {
	        		maxValue = arr[i];
	        	}
	        }
            return maxValue;
	   }
}
