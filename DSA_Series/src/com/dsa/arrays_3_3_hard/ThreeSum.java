package com.dsa.arrays_3_3_hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {

	public static List<List<Integer>> triplet_BruteForce(int n, int[] arr) {
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		Arrays.sort(arr);
		for (int i = 0; i < n - 2; i++) {
			for (int j = i + 1; j < n - 1; j++) {
				int target = -(arr[i] + arr[j]);
				for (int k = j + 1; k < n; k++) {
					if (arr[k] == target) {
						List<Integer> li = new ArrayList<>();
						li.add(arr[i]);
						li.add(arr[j]);
						li.add(arr[k]);
						if (!ans.contains(li)) {
							ans.add(li);
						}
					}
				}
			}
		}
		return ans;
	}

	public static List<List<Integer>> threeSum_Better(int n, int[] arr) {
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		Arrays.sort(arr);
		for (int i = 0; i < n; i++) {
			Set<Integer> hashSet = new HashSet<>();
			for (int j = i + 1; j < n; j++) {
				int target = -(arr[i] + arr[j]);
				if (hashSet.contains(target)) {
					List<Integer> li = new ArrayList<>();
					li.add(arr[i]);
					li.add(arr[j]);
					li.add(target);
					Collections.sort(li);
					if (!ans.contains(li)) {
						ans.add(li);
					}

				}
				hashSet.add(arr[j]);
			}
		}
		return ans;
	}
	
	//Using a two pointer approach
	public static List<List<Integer>> threeSum_Optimal(int n, int[] arr) {
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		Arrays.sort(arr);
		for (int i = 0; i < n; i++) {
			int j = i+1;
			int k = n-1;
			while(j < k) {
			    int sum = arr[i] + arr[j] + arr[k];
				if(sum == 0) {
					List<Integer> li = new ArrayList<>();
					li.add(arr[i]);
					li.add(arr[j]);
					li.add(arr[k]);
					ans.add(li);
					int t1 = arr[k];
					int l = k-1;
					while(arr[l] == t1 && l > j) {
						k--;
						l--;
					}
					int t2 = arr[j];
					int m = j + 1;
					while(arr[m] == t2 &&  m < k) {
						j++;
						m++;
					}
				}else if(sum > 0) {
					int temp = arr[k];
					int l = k-1;
					while(arr[l] == temp && l > j) {
						k--;
						l--;
					}
				}else {
					int temp = arr[j];
					int m = j + 1;
					while(arr[m] == temp &&  m < k) {
						j++;
						m++;
					}
				}
			}
			
		}
		return ans;
	}

	public static List<List<Integer>> threeSum_OptimalOfficialSol(int n, int[] arr) {
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		Arrays.sort(arr);
		for(int i = 0; i <n; i++) {
			if(i> 0 && arr[i] == arr[i-1]) continue;
			int j = i+1;
			int k = n-1;
			while(j < k) {
				 int sum = arr[i] + arr[j] + arr[k];
				 if(sum < 0) {
					 j++;
				 }else if(sum > 0) {
					 k--;
				 }else {
					 List<Integer> li = new ArrayList<>();
						li.add(arr[i]);
						li.add(arr[j]);
						li.add(arr[k]);
						ans.add(li);
						j++;
						k--;
						while(j<k && arr[j] == arr[j-1]) j++;
						while(j < k && arr[k] == arr[k+1]) k--;
				 }
			}
		}
		
		return ans;
	}
}

