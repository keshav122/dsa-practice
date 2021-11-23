package com.cn.guidedpaths.dsa.arrays.prefixandsuffixsum;

import java.util.Arrays;

public class ProductofArrayExceptSelf {

	private static final int modulo = (int) (1e9 + 7);

	public static int[] getProductArrayExceptSelf(int[] arr) {
		int product = 1;
		int zeroCount = 0;
		for (Integer i : arr) {
			if (i != 0) {
				product = ((product % modulo) * (i % modulo)) % modulo;
			} else {
				zeroCount++;
			}
		}
		if (zeroCount > 1) {
			Arrays.fill(arr, 0);
			return arr;
		}else if(zeroCount == 1){
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] != 0) {
					arr[i] = 0;
				} else {
					arr[i] = product;
				}
			}
			return arr;
		}else{
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] != 0) {
					arr[i] = (product / arr[i]) % modulo;
				} else {
					arr[i] = product;
				}
			}
			return arr;
		}
		
		
	}
}
