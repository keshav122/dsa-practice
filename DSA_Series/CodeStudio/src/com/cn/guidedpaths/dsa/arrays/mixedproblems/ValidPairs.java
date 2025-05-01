package com.cn.guidedpaths.dsa.arrays.mixedproblems;

import java.util.HashMap;
import java.util.Iterator;

public class ValidPairs {

	public static boolean isValidPair_BruteForce(int[] arr, int n, int k, int m) {
		if (n % 2 != 0) {
			return false;
		}
		boolean visited[] = new boolean[n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (visited[i] == false && visited[j] == false) {
					if ((arr[i] + arr[j]) % k == m) {
						visited[i] = true;
						visited[j] = true;
						break;
					}
				}
			}
		}
		for (int i = 0; i < n; i++) {
			if (visited[i] == false) {
				return false;
			}
		}
		return true;
	}

	public static boolean isValidPair_OptimalSolution(int[] arr, int n, int k, int m) {
		if (n % 2 == 1) {
			return false;
		}
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			int rem = arr[i] % k;
			if (!map.containsKey(rem)) {
				map.put(rem, 1);
			} else {
				map.put(rem, map.get(rem) + 1);
			}
		}

		Iterator<Integer> it = map.keySet().iterator();
		while (it.hasNext()) {
			int rem = it.next();
			if (2 * rem == m) {
				if (map.get(rem) % 2 == 1) {
					return false;
				}
			} else {
				if (!map.get((m - rem + k) % k).equals(map.get(rem))) {
					return false;
				}
			}
		}
		return true;
	}
}
