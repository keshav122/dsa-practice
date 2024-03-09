package com.dsa.arrays_3_2_medium;

import java.util.HashMap;
import java.util.Map;

public class CountAllSubArraysWithGivenSum {

	// Brute Force
	public static int findAllSubarraysWithGivenSum(int arr[], int s) {
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				int sum = 0;
				for (int k = i; k <= j; k++) {
					sum += arr[k];
				}
				if (sum == s)
					count++;
			}
		}
		return count;
	}

	public static int findAllSubarraysWithGivenSum_1(int arr[], int s) {
		int count = 0;
		Map<Integer, Integer> sumMap = new HashMap<>();
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			sumMap.put(sum, i);
			if (sum == s) {
				count++;
			} else if (sumMap.containsKey(sum - s)) {
				count++;
			}
		}
		return count;
	}
	
	//From LC solutions
	public static int findAllSubarraysWithGivenSum_2(int arr[], int s) {
		Map<Integer, Integer> sumfreqMap = new HashMap<>();//This stores the freq of each sum
		sumfreqMap.put(0, 1);
		int sum = 0;
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			
		   if (sumfreqMap.containsKey(sum - s)) {
				count += sumfreqMap.get(sum - s);
			}
		   sumfreqMap.put(sum, sumfreqMap.getOrDefault(sum, 0)  + 1);
		}
		return count;
	}

}
