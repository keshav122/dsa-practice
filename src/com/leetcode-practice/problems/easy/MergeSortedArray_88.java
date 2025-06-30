package com.leetcode-practice.problems.easy;

import java.util.Arrays;

public class MergeSortedArray_88 {

	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int[] ans = new int[m + n];
		int i = 0;
		int j = 0;
		int k = 0;
		while (i < m && j < n) {
			if (nums1[i] <= nums2[j]) {
				ans[k] = nums1[i];
				i++;
				k++;
			} else {
				ans[k] = nums2[j];
				j++;
				k++;

			}
		}

		while (i < m) {
			ans[k] = nums1[i];
			i++;
			k++;
		}
		while (j < n) {
			ans[k] = nums2[j];
			j++;
			k++;
		}

		for (int l = 0; l < m + n; l++) {
			nums1[l] = ans[l];
		}
	}
	
	public void merge_1(int[] nums1, int m, int[] nums2, int n) {
		int left = m-1;
		int right = 0;
		int k = m;
		if(m == 0) {
		   for(int i = 0; i< n;i++) {
			   nums1[k] = nums2[i];
			   k++;
		   }
		   return;
		}
		while(left >= 0 && right < n) {
			if(nums1[left] > nums2[right]) {
				nums1[k] = nums1[left];
				nums1[left] = nums2[right];
				right++;
				left--;
				k++;
			}else {
				while(k <(m+n) && right < n) {
					nums1[k] = nums2[right];
					right++;
					k++;
				}
			}
		}
		while(right < n) {
			nums1[k] = nums2[right];
			right++;
			k++;
		}
		Arrays.sort(nums1);
	}
	
	public static void main(String[] args) {
		int[] nums1 = {4,0,0,0,0,0};
		int[] nums2 = {1,2,3,5,6};
		MergeSortedArray_88 m = new MergeSortedArray_88();
		m.merge_1(nums1, 1, nums2, 5);
		for(int i: nums1) {
			System.out.print(i+" ");
		}
	}
}
