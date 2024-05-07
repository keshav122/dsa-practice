package com.dsa.binary_search._4_1.oneDArray;

public class SearchInRotatedSortedArrayII {

	//O(N) solution - Linear Search
	public static boolean searchInARotatedSortedArrayII(int[] A, int key) {
		for (int i : A) {
			if (i == key)
				return true;
		}
		return false;
	}

	public static boolean searchInARotatedSortedArrayIIOptimal(int[] A, int key) {
		int low = 0;
		int high = A.length -1;
		while(low <= high) {
			int mid = (low + high)/2;
			if(A[mid] == key) {
				return true;
			}
			
			if (A[low] == A[mid] && A [mid] == A[high]) {
				low += 1;
				high -= 1;
			}
			//Left half is sorted
			else if(A[low] <= A[mid]) {
				if(A[low] <= key && key <= A[mid]) {
					high = mid-1;
				}else {
					low = mid + 1;
				}
			}else if(A[low] > A[mid]) {
				if(A[mid] < key && key <= A[high]) {
					low = mid + 1;
				}else {
					high = mid-1; 
				}
			}
			
		}
		return false;
	}
	
	public static void main(String[] args) {

	}
}
