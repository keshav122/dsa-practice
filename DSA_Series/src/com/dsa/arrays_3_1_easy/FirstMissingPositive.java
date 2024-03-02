package com.dsa.arrays_3_1_easy;

import java.util.Arrays;

public class FirstMissingPositive {

	
	public static int firstMissing(int[] arr, int n) {
		boolean missingFound = false;
		boolean isPosPresent = false;
		for(int i= 1; i<=n ; i++) {
			int flag = 0;
			for(int j = 0; j < n; j++) {
				if(arr[j] == i) {
					flag = 1;
					isPosPresent = true;
					break;
				}
			}
			if(flag == 0) { 
				missingFound = true;
				return i;
			
			}
		}
		if(!missingFound) {
			if(isPosPresent) return n+1;
			else return 1;
		}
		return 1;
	}
	
	
	public static int firstMissing_Optimized(int[] arr, int n) {
		int hash[] = new int[n+2];// To take into account all Positives
		for(int i = 0 ;i < n ; i++) {
			if(arr[i] >= 1 && arr[i] <= n) {
				hash[arr[i]]++;
			}
		}
		
		for(int i = 1; i <= n+1 ; i++) {
			if(hash[i] == 0) return i;
		}
		
		return 1;
	}
	
	
//	3
//	3
//	1 2 0
//	4
//	3 4 -1 1
//	5
//	7 8 9 11 12
	
	public static void main(String[] args) {
		int t = 3;
		int arr1[] = {3,4,-1,1}; 
		
	}
}
