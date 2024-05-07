package com.dsa.binary_search._4_1.oneDArray;

public class FindMinimumInRotatedSortedArray {

	public static int findMin(int []arr) {
       int low = 0;
       int high = arr.length -1;
       int min = Integer.MAX_VALUE;
       while(low <= high) {
    	   int mid = (low + high)/2;
    	   if(arr[mid] < min)   min = arr[mid];
    	   
    	   if(arr[low] <= arr[mid]) {
    		   if(arr[low] < min) {
    			   min = arr[low];
    		   }
    		   low = mid + 1;
    	   }else {
    		   if(arr[mid] < min) {
    			   min = arr[mid];
    		   }
    		   high = mid -1;
    	   }
       }
       return min;
    }
}
