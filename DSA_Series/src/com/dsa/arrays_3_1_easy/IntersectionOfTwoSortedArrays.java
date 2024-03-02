package com.dsa.arrays_3_1_easy;

import java.util.ArrayList;

public class IntersectionOfTwoSortedArrays {


	//Brute Force
	public static ArrayList<Integer> findArrayIntersection(ArrayList<Integer> arr1, int n, ArrayList<Integer> arr2, int m)
	{
		ArrayList<Integer> ans = new ArrayList<>();
		int visited[] = new int[m];
		for(int i = 0; i< n ; i++) {
			int val = arr1.get(i);
			for(int j = 0; j < m ; j++) {
				if(val == arr2.get(j) && visited[j] == 0) {
					ans.add(val);
					visited[j] = 1;
					break;
				}
				if(val < arr2.get(j)) break;
			}
		}
		return ans;
	}
	
	//Optimal Solution - Two Pointer Approach
	public static ArrayList<Integer> findArrayIntersection_Improved(ArrayList<Integer> arr1, int n, ArrayList<Integer> arr2, int m)
	{
		ArrayList<Integer> ans = new ArrayList<>();
		int i = 0, j= 0;
		while(i < n && j < m) {
			if(arr1.get(i) < arr2.get(j)) {
				i++;
			}else if(arr1.get(i) > arr2.get(j)) {
				j++;
			}else {
				ans.add(arr1.get(i));
				i++;
				j++;
			}
		}
		return ans;
	}
}
