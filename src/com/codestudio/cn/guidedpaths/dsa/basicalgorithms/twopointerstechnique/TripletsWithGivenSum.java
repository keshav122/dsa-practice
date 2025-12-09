/*Author: keshav122 */
package com.codestudio.cn.guidedpaths.dsa.basicalgorithms.twopointerstechnique;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class TripletsWithGivenSum {
	
	private static HashSet<PairClass> set = new HashSet<>();
	
	public static ArrayList<ArrayList<Integer>> findTriplets(int[] arr, int n, int K)  {
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		Arrays.sort(arr);
		for (int i = 0; i < n; i++) {
			int target = K -arr[i];
			int front = i + 1;
			int back = n - 1;

			while (front < back) {
				int sum = arr[front] + arr[back];
				if (sum < target) {
					front++;
				}
				else if (sum > target) {
					back--;
				} else {
					int x = arr[front];
					int y = arr[back];

					ArrayList<Integer> list = new ArrayList<>();

					list.add(arr[i]);
					list.add(arr[front]);
					list.add(arr[back]);

					Collections.sort(list);

					if (!set.contains(new PairClass(list.get(0), list.get(1), list.get(2)))) {
						set.add(new PairClass(list.get(0), list.get(1), list.get(2)));
						ans.add(list);
					}
					while (front < back && arr[front] == (x)) {
						front++;
					}
					while (front < back && arr[back] == y) {
						back--;
					}
				}
			}

			while (i + 1 < n && arr[i] == arr[i + 1]) {
				i++;
			}
		}
		return ans;
	}
}
