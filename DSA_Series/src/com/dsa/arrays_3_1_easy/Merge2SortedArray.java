package com.dsa.arrays_3_1_easy;

import java.util.ArrayList;
import java.util.List;

public class Merge2SortedArray {

	public static List<Integer> sortedArray(int[] a, int[] b) {
		List<Integer> ans = new ArrayList<>();
		int i = 0;
		int j = 0;
		while (i < a.length && j < b.length) {
			if (a[i] < b[j]) {
				if(!ans.contains(a[i])) {//Rather than checking the whole list 
					// you should only check the last element and also take care of the
					//element at index 0 because there the index-1 will give 
					//Index out of bound exception
					ans.add(a[i]);
				}
				i++;
			} else if (a[i] > b[j] && !ans.contains(b[j])) {
				if(!ans.contains(b[j])) {
					ans.add(b[j]);
				}
				j++;
			} else {
				if(!ans.contains(a[i])) {
					ans.add(a[i]);
				}
				i++;
				j++;
			}
		}

		while (i < a.length) {
			if(!ans.contains(a[i])) {
				ans.add(a[i]);
			}
			i++;
		}
		while (j < b.length) {
			if(!ans.contains(b[j])) {
				ans.add(b[j]);
			}
			j++;
		}
		return ans;
	}

	public static void main(String[] args) {
		int a[] = { 1, 2, 3, 3 };
		int b[] = { 2, 2, 4 };
		List<Integer> ans = sortedArray(a, b);
		for (Integer i : ans) {
			System.out.print(i + " ");
		}
	}
}
