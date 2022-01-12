package com.cn.guidedpaths.dsa.basicalgorithms.twopointerstechnique;

import java.util.HashSet;
import java.util.ArrayList;
import java.util.Collections;

public class FindAllTripletsWithZeroSum {

	private static HashSet<PairClass> set = new HashSet<>();

	public static ArrayList<ArrayList<Integer>> findTriplets(ArrayList<Integer> arr, int n) {
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		Collections.sort(arr);
		int f = 0;

		for (int i = 0; i < n; i++) {

			int target = -arr.get(i);
			int front = i + 1;
			int back = n - 1;

			while (front < back) {

				int sum = arr.get(front) + arr.get(back);

				if (sum < target) {
					front++;
				}

				else if (sum > target) {
					back--;
				} else {
					f = 1;

					int x = arr.get(front);
					int y = arr.get(back);

					ArrayList<Integer> list = new ArrayList<>();

					list.add(arr.get(i));
					list.add(arr.get(front));
					list.add(arr.get(back));

					Collections.sort(list);

					if (!set.contains(new PairClass(list.get(0), list.get(1), list.get(2)))) {
						set.add(new PairClass(list.get(0), list.get(1), list.get(2)));
						ans.add(list);
					}

					while (front < back && arr.get(front).equals(x)) {
						front++;
					}

					while (front < back && arr.get(back) == y) {
						back--;
					}
				}
			}

			while (i + 1 < n && arr.get(i) == arr.get(i + 1)) {
				i++;
			}
		}
		return ans;

	}

}



