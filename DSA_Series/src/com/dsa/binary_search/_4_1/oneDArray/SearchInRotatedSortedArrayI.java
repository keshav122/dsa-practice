package com.dsa.binary_search._4_1.oneDArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchInRotatedSortedArrayI {

	public static int search(ArrayList<Integer> arr, int n, int k) {
		int low = 0;
		int high = n - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (arr.get(mid) == k) {
				return mid;
			} 
			if(arr.get(low) <= arr.get(mid)) {
				if(arr.get(low) <= k && k <= arr.get(mid)) {
					high = mid-1;
				}else {
					low = mid +1;
				}
			}else {
				if(arr.get(mid) <k && k <= arr.get(high)) {
					low = mid +1;
				}else {
					high = mid-1;
				}
			}
		}
		return -1;
	} 

	public static void main(String[] args) {
		// 9 7
		// 5 6 7 8 9 10 0 2 3
		
		//9 9
		//7 8 9 10 0 1 2 5 6 

		List<Integer> temp = Arrays.asList(11 ,3, 4 ,5, 6, 7, 8, 9 );
		ArrayList<Integer> li = new ArrayList<>();
		li.addAll(temp);
		System.out.println(search(li, li.size(), 3));
	}
}
