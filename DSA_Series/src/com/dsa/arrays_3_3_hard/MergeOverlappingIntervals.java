package com.dsa.arrays_3_3_hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeOverlappingIntervals {

	public static List<List<Integer>> mergeOverlappingIntervals(int[][] arr) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (arr[0][1] >= arr[1][0]) {
			List<Integer> li = Arrays.asList(arr[0][0], Math.max(arr[0][1],arr[1][1]));
			res.add(li);
		} else {
			List<Integer> li1 = Arrays.asList(arr[0][0], arr[0][1]);
			List<Integer> li2 = Arrays.asList(arr[1][0], arr[1][1]);
			res.add(li1);
			res.add(li2);
		}
		int i = 2;
		while (i < arr.length - 1) {
			List<Integer> temp1 = res.get(res.size() - 1);
			List<Integer> temp2 = Arrays.asList(arr[i][0], arr[i][1]);
			if (temp1.get(1) >= temp2.get(0)) {
				if (res.size() != 0) {
					res.remove(res.size() - 1);
				}
				List<Integer> li = Arrays.asList(temp1.get(0), Math.max(temp1.get(1), temp2.get(1)));
				res.add(li);
			} else {
				res.add(temp2);
			}
			i++;
		}
		return res;
	}

	public static void main(String[] args) {

		int[][] arr = { { 1, 2 }, { 1, 3 }, { 1, 6 }, { 3, 4 }, { 4, 4 }, { 4, 5 }, { 5, 5 }, { 6, 6 }, { 6, 6 } };
		List<List<Integer>> ans = mergeOverlappingIntervals(arr);
		for (List<Integer> li : ans) {
			System.out.println(li.toString());
		}

	}

}
