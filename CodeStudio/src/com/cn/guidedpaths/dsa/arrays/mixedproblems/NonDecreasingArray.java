package com.cn.guidedpaths.dsa.arrays.mixedproblems;

public class NonDecreasingArray {

	public static boolean isPossible_mySol(int[] arr, int n) {
		int count = 0;
		for(int i = 0; i<n-1 ;i++){
			if(arr[i] > arr[i+1]){
				
				if(count > 1 || (arr[i-1] > arr[i] || arr[i+1] > arr[i+2] || arr[i-1] < arr[i] && arr[i+1] < arr[i+2] ) ){
					return false;
				}
				count++;
			}
		}		
		return true;
	}

	public static boolean isPossible(int[] arr, int n) {
		 for (int i = 1, err = 0; i < n; i++){
			 if (arr[i] < arr[i-1]){
				 if (err++ > 0 || (i > 1 && i < arr.length - 1 && arr[i-2] > arr[i] && arr[i+1] < arr[i-1])){
					 return false; 
				 }     
			 }     
		 }
	     return true;	
	}
	
	
}
