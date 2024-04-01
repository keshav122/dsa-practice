package com.dsa.arrays_3_3_hard;

import java.util.HashMap;
import java.util.Map;

public class MissingandRepeatingNumbers {

	public static int[] findMissingRepeatingNumbers(int[] a) {
		int hash[] = new int[a.length];
		int missing = 0;
		int repeat = 0;
		for (int i : a) {
			hash[i - 1]++;
		}

		for (int i = 0; i < hash.length; i++) {
			if (hash[i] == 0) {
				missing = i + 1;
			}

			if (hash[i] == 2) {
				repeat = i + 1;
			}
		}
		int ans[] = new int[2];
		ans[0] = repeat;
		ans[1] = missing;
		return ans;
	}

	public static int[] findMissingRepeatingNumbers_better(int[] a) {
		Map<Integer, Integer> map = new HashMap<>();
		int n = a.length;
		int ans[] = new int[2];
		int repeat = 0;
		long sum = 0;
		for(int i : a) {
			if(map.containsKey(i)) {
				ans[0] = i;
				repeat = i;
				map.put(i, 2);
			}else {
				map.put(i,1);
			}
			sum += i;
		}
		ans[1] = (int) (repeat + ((n * (n+1))/2) - sum);
		return ans;
		
	}
	public static void main(String[] args) {
		int n = 14;
		int a[] = { 10, 11, 1, 12, 3, 4, 13, 8, 2, 6, 7, 9, 5, 3 };
		int res[] = findMissingRepeatingNumbers_better(a);
		System.out.println("Missing :" + res[1] + " Repeat : " + res[0]);
	}
}
