/*Author: keshav122 */
package com.leetcode_practice.problems.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RelativeSortArray_1122 {

	public int[] relativeSortArray(int[] arr1, int[] arr2) {
		Map<Integer, Integer> freqMapArr1 = new HashMap<>();
		Map<Integer, Integer> freqMapArr2 = new HashMap<>();
		for (Integer i : arr2) {
			freqMapArr2.put(i, 1);
		}
		List<Integer> nonCommonElem = new ArrayList<>();
		for (Integer i : arr1) {
			freqMapArr1.merge(i, 1, Integer::sum);
			if (!freqMapArr2.containsKey(i)) {
				nonCommonElem.add(i);
			}
		}
		Collections.sort(nonCommonElem);
		int i = 0;
		int j = 0;
		while (i < arr1.length && j < arr2.length) {
			int count = freqMapArr1.get(arr2[j]);
			for (int k = 0; k < count; k++) {
				arr1[i] = arr2[j];
				i++;
			}
			j++;
		}
		for (int l = 0; l < nonCommonElem.size(); l++) {
			arr1[i] = nonCommonElem.get(l);
			i++;
		}
		return arr1;
	}
	
	public static void main(String[] args) {
		int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19};
		int[] arr2 = {2,1,4,3,9,6};
		RelativeSortArray_1122 r = new RelativeSortArray_1122();
		System.out.println(r.relativeSortArray(arr1, arr2));
	}
}
