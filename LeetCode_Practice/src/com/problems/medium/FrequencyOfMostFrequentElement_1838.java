package com.problems.medium;

import java.util.HashMap;
import java.util.Map;

// Use case : 100 , 100 , 100 , 100 , 3 , 3 ,3 , 4, 4 ,4 &  k= 15 Ans : 6 
// Use case : 1,1,2,4
// Use case : arr = [1,1,1,1,5,6,7,7] k = 9
public class FrequencyOfMostFrequentElement_1838 {

	public static int maxFrequency(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i : nums) {
			map.merge(i, 1, Integer::sum);
		}

		int maxFreq = 1;
		int temp = k;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			int count = entry.getValue();
			int key = entry.getKey();
			k = temp;
			for (Map.Entry<Integer, Integer> e : map.entrySet()) {
				if (e.getKey() < key && k >= 0) {
					int diff = key - e.getKey();
					int possibleChanges = (k / diff);
					int allowedAdditions = Math.min(e.getValue(), possibleChanges);
					count += allowedAdditions;
					k -= allowedAdditions * diff;
				}
			}
			if (count >= maxFreq) {
				maxFreq = count;
			}
		}
		return maxFreq;

	}

	
	public static void main(String[] args) {
		int nums[] = { 9930, 9923, 9983, 9997, 9934, 9952, 9945, 9914, 9985, 9982, 9970, 9932, 9985, 9902, 9975, 9990,
				9922, 9990, 9994, 9937, 9996, 9964, 9943, 9963, 9911, 9925, 9935, 9945, 9933, 9916, 9930, 9938, 10000,
				9916, 9911, 9959, 9957, 9907, 9913, 9916, 9993, 9930, 9975, 9924, 9988, 9923, 9910, 9925, 9977, 9981,
				9927, 9930, 9927, 9925, 9923, 9904, 9928, 9928, 9986, 9903, 9985, 9954, 9938, 9911, 9952, 9974, 9926,
				9920, 9972, 9983, 9973, 9917, 9995, 9973, 9977, 9947, 9936, 9975, 9954, 9932, 9964, 9972, 9935, 9946,
				9966 };
		int k = 3056;
		System.out.println(maxFrequency(nums, k));
	}
}
