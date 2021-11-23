package com.cn.guidedpaths.dsa.arrays.mixedproblems;

public class ValidPairs {

	public static boolean isValidPair(int[] arr, int n, int k, int m) {
		
		if(n % 2 != 0){
			return false;
		}else{
			int pairSumArraylength = n/2;
			int pairSumArray[] = new int[pairSumArraylength];
			for(int i = 0, j= 0; i< pairSumArraylength;i+=2, j++){
				pairSumArray[j] += arr[i] + arr[i+1];
			}
			
			for(int i = 0; i< pairSumArraylength;i++){
				if(pairSumArray[i] % k != m){
					return false;
				}
			}
			return true;
		}
		
	}
}
