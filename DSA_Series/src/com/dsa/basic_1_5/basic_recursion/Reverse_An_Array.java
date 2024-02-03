package com.dsa.basic_1_5.basic_recursion;

public class Reverse_An_Array {

	 public static int[] reverseArray(int n, int []nums) {
	        return reverseArray(n, nums, 0 ,n-1);
	   }

	private static int[] reverseArray(int n, int[] nums, int sI, int eI) {
		if(sI > eI) {
			return nums;
		}
		int temp = nums[sI];
		nums[sI] = nums[eI];
		nums[eI] = temp;
		return reverseArray(n, nums, ++sI, --eI);
	}
	
	public static int[] reverseArray_OnePointer(int n, int []nums) {
        return reverseArray(n, nums, 0);
   }
	
	private static int[] reverseArray(int n, int[] nums, int i) {
		if(i >= n/2) {
			return nums;
		}
		int temp = nums[i];
		nums[i] = nums[n-i-1];
		nums[n-i-1] = temp;
		return reverseArray(n, nums, ++i);
	}

	public static void main(String[] args) {
		int arr[] = {1,2,3,4,5};
		int a[] = reverseArray(5,arr);
		for(int i : a) {
			System.out.print(i+" ");
		}
	}
}
