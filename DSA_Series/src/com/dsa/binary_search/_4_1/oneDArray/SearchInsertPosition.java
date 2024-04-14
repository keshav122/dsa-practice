package com.dsa.binary_search._4_1.oneDArray;

public class SearchInsertPosition {

	 public static int searchInsert(int [] arr, int m){
	        int start = 0;
	        int n = arr.length;
	        int end = n-1;
	        while(start <= end) {
	        	int mid = (start + end)/2;
	        	if(arr[mid] == m) {
	        		return mid;
	        	}else if(arr[mid] > m) {
	        		if(mid == 0 || (mid > 0 && arr[mid-1] <m)) {
	        			return mid;
	        		}
	        		end = mid-1;
	        	}else {
	        		if(mid == n-1) {
	        			return n;
	        		}else if(mid < n-1 && arr[mid+1] > m) {
	        			return mid + 1;
	        		}
	        		start = mid + 1;
	        	}
	        }
	        return 0;
	    }
	 
	 //Insert the value is same as calculating the lower bound
	 public static int searchInsert_Optimal(int [] arr, int m){
		 int n = arr.length;
		 int ans = n;
		 int low = 0;
		 int high = arr.length -1;
		 while(low <= high) {
			 int mid = (low + high)/2;
			 if(arr[mid] >= m) {
				ans = mid;
				high = mid-1;
			 }else {
				 low = mid + 1;
			 }
		 }
		 return ans;
	 }
	 public static void main(String[] args) {
		int arr[] = {3,29,30,42,43};
		int m = 17;
		System.out.println(searchInsert(arr, m));
	}
}
