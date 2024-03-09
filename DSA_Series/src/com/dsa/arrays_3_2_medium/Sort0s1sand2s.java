package com.dsa.arrays_3_2_medium;

import java.util.ArrayList;

public class Sort0s1sand2s {

	//Brute Force
	public static void sortArray(ArrayList<Integer> arr, int n) {
		int zeroCount = 0, oneCount = 0,twoCount = 0;
	      for(Integer i : arr) {
	    	  if(i == 0) {
	    		  zeroCount++;
	    	  }else if(i == 1) {
	    		  oneCount++;
	    	  }else {
	    		  twoCount++;
	    	  }
	      }
	      
	      int j = 0;
	      while(j < zeroCount) {
	    	  arr.set(j, 0);
	    	  j++;
	      }
	      
	      int k = 0;
	      while(k < oneCount) {
	    	  arr.set(j, 1);
	    	  j++;
	          k++;
	      }
	      
	      int l = 0;
	      while(l < twoCount) {
	    	  arr.set(j, 2);
	    	  j++;
	          l++;
	      }
    }
	
	//Dutch National Flag Algorithm
	//Elements b/w 0 to low-1 will be 0
	//Elements b/w low to mid-1 will be 1
	//Elements b/w high+1 to n-1 will be 2
	//Elements b/w mid to high will be unsorted 0,1 and 2 and we need to sort them

	public static void sortArray_DNF(ArrayList<Integer> arr, int n) {
		 int low = 0;
			int mid = 0;
			int high = n-1;
			while(mid <= high) {
				if(arr.get(mid) == 0) {
					//swap low & curr index
					arr.set(mid, arr.get(low));
					arr.set(low, 0);
					low++;
					mid++;
				}else if(arr.get(mid) == 1) {
					mid++;
				}else {
					//swap high & curr index
					arr.set(mid, arr.get(high));
					arr.set(high, 2);
					high--;
				}
			}
	}
	
	public static void main(String[] args) {
		
	}
}
