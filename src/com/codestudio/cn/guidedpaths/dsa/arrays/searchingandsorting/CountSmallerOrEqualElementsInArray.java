package com.codestudio.cn.guidedpaths.dsa.arrays.searchingandsorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountSmallerOrEqualElementsInArray {
	
	 public static List<Integer> countSmallerOrEqual_BruteForce(int[] a, int[] b, int n, int m) {
		    Arrays.sort(b);
	        List<Integer> li = new ArrayList<Integer>(a.length);
	        for(int i = 0; i< a.length;i++){
	        	int count = 0;
	        	for(int j = 0; j < b.length;j++){
	        		if(b[j] <= a[i]){
	        			count++;
	        		}else{
	        			break;
	        		}
	        	}
	        	li.add(count);
	        	
	        }
	        return li;
	    }

	 public static List<Integer> countSmallerOrEqual(int[] a, int[] b, int n, int m){
		 Arrays.sort(b);
		 List<Integer> li = new ArrayList<Integer>(a.length);
	        for(int i = 0; i< a.length;i++){
	        	int temp = a[i];
	        	int sI = 0;
	        	int eI = b.length-1;
	        	while(sI != eI){
	        		int mid = sI + (eI-sI)/2;
	        		if(b[mid] <= temp){
	        			sI = mid+ 1;
	        		}else{
	        			eI = mid-1;
	        		}
	        	}
	        	
	        	li.add(sI);
	        	
	        }
	        return li;
	 }
}
