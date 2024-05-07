package com.dsa.binary_search._4_1.oneDArray;

public class Rotation {

	public static int findKRotation(int []arr){
       int low = 0;
       int high = arr.length -1;
       while(low <= high) {
    	   int mid = (low + high)/2;
    	   if(mid > 0 && arr[mid] <arr[mid-1]) return mid;
    	   if(mid < arr.length -1 && arr[mid] > arr[mid+1]) return mid+ 1;
    	   
    	   if(arr[low] <= arr[mid]) {
    		   low = mid + 1;
    	   }else {
    		   high = mid -1;
    	   }
       }
       return 0;
    }
}
