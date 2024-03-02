package com.dsa.arrays_3_2_medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SuperiorElements {

	 public static List< Integer > superiorElements(int []a) {
	       List<Integer> ans = new ArrayList<>();
	       int n = a.length;
	       ans.add(a[n-1]);
	       for(int i = 0; i<n-1;i++) {
	    	   boolean isSuperiorElem = true;
	    	   for(int j = i+1; j < n ; j++) {
	    		   if(a[i] <= a[j]) {
	    			   isSuperiorElem = false;
	    			   break;
	    		   }
	    	   }
	    	   if(isSuperiorElem) {
	    		   ans.add(a[i]);
	    	   }
	       }
	       Collections.sort(ans);
	       return ans;
	    }
	 
	 public static List< Integer > superiorElements_Way1(int []a) { 
		 List<Integer> ans = new ArrayList<>();
	     int n = a.length;
		 int max_value_so_far = a[n-1];
		 ans.add(max_value_so_far);
		 for(int i = n-1; i>= 0;i--) {
			 if(a[i] > max_value_so_far ) {
				 ans.add(a[i]);
			 }
			 max_value_so_far = Math.max(max_value_so_far, a[i]);
		 }
		 return ans;
	 }
}
