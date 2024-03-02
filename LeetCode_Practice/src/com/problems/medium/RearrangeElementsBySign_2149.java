package com.problems.medium;

import java.util.LinkedList;
import java.util.List;

public class RearrangeElementsBySign_2149 {

	// BruteForce -TLE
	public int[] rearrangeArray(int[] nums) {
		List<Integer> positiveInteger = new LinkedList<>();
		List<Integer> negativeInteger = new LinkedList<>();
		for (int val : nums) {
			if (val > 0) {
				positiveInteger.add(val);
			} else {
				negativeInteger.add(val);
			}
		}
		int k = 0;
		for (int i = 0; i <= nums.length - 2; i += 2) {
			nums[i] = positiveInteger.get(k);
			nums[i + 1] = negativeInteger.get(k);
			k++;
		}
		return nums;
	}

	public int[] rearrangeArray_Way1(int[] nums) {
		int n = nums.length;
		int posCounter = 0;
		int negCounter = n / 2;
		int temp[] = new int[n];
		for (int i = 0; i < n; i++) {
			if (nums[i] > 0) {
				temp[posCounter] = nums[i];
				posCounter++;
			} else {
				temp[negCounter] = nums[i];
				negCounter++;
			}
		}

		posCounter = 0;
		negCounter = n / 2;
		for (int i = 0; i <= n - 2; i += 2) {
			nums[i] = temp[posCounter];
			nums[i + 1] = temp[negCounter];
			posCounter++;
			negCounter++;
		}
		return nums;
	}
	
	//Not by me - From Solution Section
	public static int[] rearrangeArray_Way2(int[] nums) {
		int n = nums.length;
		int ans[] = new int[n];
		int posCounter = 0,negCounter = 1;
		for(int i = 0 ; i< n ; i++) {
			if(nums[i] > 0) {
				ans[posCounter] = nums[i] ;
				posCounter+= 2;
			}else {
				ans[negCounter] = nums[i] ;
				negCounter+= 2;
			}
		}
		return ans;
	}
}
