package com.codestudio.cn.guidedpaths.dsa.arrays.mixedproblems;

import java.util.ArrayList;
import java.util.HashMap;

public class MaxProductCount {
	public static long[] maxProductCount(int arr[], int n) {
		long res[] = new long[2];
		HashMap<Long, Integer> map = new HashMap<>();
		ArrayList<Long> li = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				long product = (long) arr[i] * arr[j];
				System.out.println(product +" Value of I :"+i + "Value of j :"+j);
				if (map.containsKey(product)) {
					map.put(product, map.get(product) + 1);
					li.add(product);
				} else {
					map.put(product, 1);
				}
			}
		}
		long count = 0;
		long finalProduct = 0;
		for (Long l : li) {
			if (map.get(l) > count) {
				count = map.get(l);
				finalProduct = l;
			} else if (map.get(l) == count && l < finalProduct) {
				finalProduct = l;
			}
		}
		res[0] = finalProduct;
		res[1] = (count * (count - 1)) / 2;
		return res;
	}

	public static void main(String[] args) {

		int arr[] = {100000000,200,200000000,100,9,40000000,500};
		long ans[] = maxProductCount(arr, arr.length);
		for(int i = 0; i< ans.length;i++){
			System.out.print(ans[i]+" ");
		}
	}
}
