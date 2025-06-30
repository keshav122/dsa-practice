package com.codestudio.cn.guidedpaths.dsa.arrays.searchingandsorting;

public class AlgorithmToFindInsertPositionInSortedArray {
	
	public static int bestInsertPos(int [] arr, int n, int m){
	   int sI =0 , eI = n-1;
	   while(sI <= eI){
		   int mid = sI + (eI-sI)/2;
		   if(arr[mid] == m){
			   return mid;
		   }else if(arr[mid] < m){
			   sI = mid + 1;
		   }else{
			   eI = mid-1;
		   }
	   }
	   return eI + 1;
	}

}
