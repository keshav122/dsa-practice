package com.dsa.arrays_3_1_easy;

import java.util.ArrayList;

public class LeftRotateByKPlaces {

	public static ArrayList<Integer> rotateArray(ArrayList<Integer> arr, int k) {
		int n = arr.size();
        if(n == 1){
            return arr;
        }
		ArrayList<Integer> res = new ArrayList<>();
		for (int i = k; i < n; i++) {
			res.add(arr.get(i));
		}
		for (int i = 0; i < k; i++) {
			res.add(arr.get(i));
		}
		return res;
	}
}
