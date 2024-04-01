package com.dsa.arrays_3_2_medium;

import java.util.Collections;
import java.util.List;

public class NextGreaterPermutation {

	public static List< Integer > nextGreaterPermutation(List< Integer > A) {
		int n = A.size();
        int breakPt = -1;
        for(int i = n-2 ; i >= 0; i--) {
        	if(A.get(i) < A.get(i+1)) {
        		breakPt = i;
        		
        		break;
        	}
        }
        if(breakPt == -1) {
        	Collections.reverse(A);
        	return A;
        }
 
        int breakVal = A.get(breakPt);
        for(int i = n-1 ; i >= breakPt; i--) {
        	if(A.get(i) >breakVal) {
        		//swap
        		A.set(breakPt, A.get(i));
        		A.set(i, breakVal);
        		break;
        	}
        }
        
       //reverse breakPt +1  to n-1
        int start = breakPt+1;
        int end = n-1;
        while(start<= end) {
        	int temp = A.get(start);
        	A.set(start, A.get(end));
        	A.set(end, temp);
        	start++;
        	end--;
        }
        return A;
       
        
    }
}
