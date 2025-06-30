package com.codestudio.cn.guidedpaths.dsa.arrays.mixedproblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PairSum {

	  public static int[][] pairSum_1(int[] arr, int s) {
		   List<Pair<Integer>> li = new ArrayList<>();
	        Arrays.sort(arr);
	        int size = arr.length;
	        for(int i = 0; i< size;i++){
	        	int value = s-arr[i];
	        	for(int j = i + 1; j < size ; j++){
	        		if(arr[j] == value){
	        			Pair<Integer> p = new Pair<Integer>(Math.min(arr[i], arr[j]),Math.max(arr[i], arr[j]));
	        			li.add(p);
	        		}else if(arr[j] > value ){ 
	        			break;
	        		}
	        	}
	        }
	        
	        int ans[][] = new int[li.size()][2];
	        
	        for(int i= 0; i< li.size();i++){
	        	ans[i][0] =(int) li.get(i).a ;
    			ans[i][1]= (int) li.get(i).b ;
	        }
	        return ans;
	    }
	  
//	  public static int[][] pairSum(int[] arr, int s) {
//		  List<Pair<Integer>> li = new ArrayList<>();
//	      Arrays.sort(arr);
//	      int size = arr.length;
//	      for(int i = 0; i< size;i++){
//	    	  int value = s-arr[i];
//	    	  
//	    	  int index = searchValue(arr,value);
//	      }
//	  }

	private static int searchValue(int[] arr, int value) {
		return 0;
	}
	  
}

class Pair<T>{
	T a;
	T b;
	
	public Pair(T a, T b) {
		this.a = a;
		this.b = b;
	}
	
}