package com.problems.easy;

import java.util.ArrayList;
import java.util.List;

public class KthMissingPositiveInteger_1539 {
	
	public int findKthPositive(int[] arr, int k) {
		int n = arr.length;
		List<Integer> missingList = new ArrayList<>();
		if(arr[0] > 1) {
			for(int a = 1; a < arr[0]; a++) {
				missingList.add(a);
			}
				
		}
		
		if(missingList.size() >= k) {
			return missingList.get(k-1);
		}
		for(int i = 1; i< n; i++) {
			if(arr[i] - arr[i-1] > 1) {
				for(int a = arr[i-1] + 1; a < arr[i]; a++) {
					missingList.add(a);
				}
				if(missingList.size() >= k) {
					return missingList.get(k-1);
				}
			}
		}
		if(missingList.size() < k) {
			return arr[n-1] + (k - missingList.size()) ;
		}
		return missingList.get(k-1);
	}
	
	//Logic : Each number that comes up in the array will increse the possible value
	//The moment arr[i] > k , we return the k.
	//For example : {5,7,9 , 11} and k = 6 . So we want to find 6th missing number;
	//We first encounter 5 so we increase k to 7
	//Then we encounter 7 so we increase k to 8
	//Then we encounter 9 which is greater than k , so we return k -> 8 is the 6th missing integer
	public int findKthPositiveEasyBruteForce(int[] arr, int k) {
		for(int i : arr) {
			if(i > k) {
				return k;
			}else {
				k++;
			}
		}
		return k;
	}
	
	public int findKthPositivBinarySearch(int[] arr, int k) {
		int low = 0;
		int high = arr.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			int missing = arr[mid] - (mid + 1);
			if (missing < k) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}

		return high + 1 + k;
	}
}
